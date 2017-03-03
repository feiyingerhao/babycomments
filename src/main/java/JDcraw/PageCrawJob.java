package main.java.JDcraw;


import main.java.general.BasicCrawler;
import main.java.mongodb.JDInsert;

import java.util.logging.Logger;

/**
 * Created by haolidong on 2016/11/14.
 */
public class PageCrawJob {
    private static Logger logger = Logger.getLogger(PageCrawJob.class.getName());
    //https://item.jd.com/1016355.html#none
    public static void main(String[] args){
        for (int i = 3818; i < 10000 ; i++){
            try {
                String url = "https://club.jd.com/comment/productPageComments.action?callback=fetchJSON_comment98vv274939&productId=1029507&score=0&sortType=5&page="+i+"&pageSize=10&isShadowSku=0";
                String content = "";
                Thread.sleep(2000);
                System.out.println("crawler--->"+i);
                content = BasicCrawler.crawlPage(url, "gb2312");
                int index = content.indexOf("{");
                int lastIndex = content.lastIndexOf("}");
                if(index==-1||lastIndex==-1){
                    Thread.sleep(120000);
                    System.out.println("ERROR:"+i);
                    continue;
                }
                String newcontent = content.substring(index,lastIndex+1);
                new JDInsert().InsertNewAppname("JD","Friso_1",newcontent);
            } catch(Exception e){

                e.printStackTrace();
            }
        }
    }
}
