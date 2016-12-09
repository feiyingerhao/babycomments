package main.java.tianmao;

import main.java.general.BasicCrawler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by haolidong on 2016/11/14.
 */
public class PageParseJob {
    public static Integer parse(String linkUrl,String filename,int index){
        String content = "";
        try {
            content= BasicCrawler.crawlPage(linkUrl,"gb2312");
            content=BasicCrawler.crawlPage(linkUrl);
            if(content==null){
                return -1;
            }

            if(!content.startsWith("\"rateDetail\"")){
                System.out.println("asoidhd-->"+content+"OKK");
                return -2;
            }
            //FileDel.append(filename,content);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (index==1){
            JSONObject comments = JSONObject.fromString("{"+content+"}");
            JSONObject rateDetail=(JSONObject)comments.get("rateDetail");
            JSONObject paginator = (JSONObject)rateDetail.get("paginator");
            Integer lastPage = (Integer) paginator.get("lastPage");
            return lastPage;
        }
        return 0;
    }

}
