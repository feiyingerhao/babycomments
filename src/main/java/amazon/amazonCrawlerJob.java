package main.java.amazon;

import main.java.general.BasicCrawler;
import main.java.mongodb.AmazonInsert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by haolidong on 2017/3/3.
 */

//*[@id="customer_review-R2VIH58VH4NX84"]/div[4]/span
public class amazonCrawlerJob {
    public static void main(String[] args){
        try{
            for (int i = 15;i<=31;i++){
                System.out.println(i);
                String url = "https://www.amazon.cn/Friso-%E7%BE%8E%E7%B4%A0%E4%BD%B3%E5%84%BF-%E9%87%91%E8%A3%853%E6%AE%B5%E5%B9%BC%E5%84%BF%E9%85%8D%E6%96%B9%E4%B8%89%E6%AE%B5%E5%A5%B6%E7%B2%89%E6%95%B4%E7%AE%B1%E8%A3%851200g-3-%E5%8E%9F%E8%A3%85/product-reviews/B010D1DI0Y/ref=cm_cr_getr_d_paging_btm_3?showViewpoints=1&filterByStar=positive&pageNumber=1";
                String content = "";
                Thread.sleep(15000);
                content = BasicCrawler.crawlPage(url, "utf-8");
                Document doc = Jsoup.parse(content);
                Elements elements = doc.select("div[class=a-fixed-right-grid-col a-col-left] div[class=a-section a-spacing-none reviews-content a-size-base] div[id=cm_cr-review_list] div[data-hook=review]");

                for(Element element:elements){
                    String reviewBody = element.select("span[data-hook=review-body]").first().text();
                    String reviewStarRating = element.select("i[data-hook=review-star-rating] span[class=a-icon-alt]").first().text();
                    String reviewTitle = element.select("a[class=a-size-base a-link-normal review-title a-color-base a-text-bold]").first().text();
                    String author = element.select("span[class=a-size-base a-color-secondary review-byline] a[class=a-size-base a-link-normal author]").first().text();
                    String reviewDate = element.select("span[class=a-size-base a-color-secondary review-date]").first().text();
                    String reviewVotes = element.select("span[class=a-size-base cr-vote] span[class=review-votes]").first().text();

                    int reviewStarRatingIndex = reviewStarRating.indexOf(" 颗星，最多 5 颗星");
                    String newReviewStarRatingIndex = reviewStarRating.substring(0,reviewStarRatingIndex);

//                int reviewDateIndex = reviewDate.indexOf("于 ");
                    String newreviewDate = reviewDate.substring(2);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                    SimpleDateFormat sdfout = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date=sdf.parse(newreviewDate);

                    int reviewVotesIndex = reviewVotes.indexOf(" 个人发现此评论有用");
                    String newReviewVotes = reviewVotes.substring(0,reviewVotesIndex);

                    org.bson.Document document = new org.bson.Document();
                    document.append("reviewBody",reviewBody).append("reviewStarRating",Double.parseDouble(newReviewStarRatingIndex))
                            .append("reviewTitle",reviewTitle).append("author",author).append("reviewDate",sdfout.format(date))
                            .append("reviewVotes",Integer.parseInt(newReviewVotes));
                    new AmazonInsert().InsertNewAppname("Amazon","Friso",document);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
