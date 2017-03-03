package main.java.suning;


import main.java.general.BasicCrawler;
import main.java.mongodb.SNInsert;
import main.java.mongodb.TMInsert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by haolidong on 2016/11/14.
 */
public class SuningPageCrawJob {
    private static Logger logger = Logger.getLogger(SuningPageCrawJob.class.getName());
    public static void main(String[] args){
//        for (int i = 1;i<=99;i++){
            try{
                String url="http://review.suning.com/ajax/review_lists/general-000000000102878794-0000000000-total-4-default-10-----reviewList.htm?callback=reviewList";
                String content = "";
                Thread.sleep(2000);
                System.out.println("crawler--->");
                content = BasicCrawler.crawlPage(url, "utf-8");
                int index = content.indexOf("{");
                int lastIndex = content.lastIndexOf("}");
                    String json = content.substring(index,lastIndex+1) ;
                    System.out.println(json);
                    new SNInsert().SNInsertNewAppname("Suning","Nestle",json);

            } catch (Exception e){
                e.printStackTrace();
            }
//        }

    }
}
