package main.java.tianmao;


import main.java.general.BasicCrawler;
import main.java.mongodb.TMInsert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by haolidong on 2016/11/14.
 */
public class PageCrawJob {
    private static Logger logger = Logger.getLogger(PageCrawJob.class.getName());
    public static void main(String[] args){
        List<String> ls = new ArrayList<String>();
        for (int i = 1;i<=99;i++){
            try{
                String url="https://rate.tmall.com/list_detail_rate.htm?itemId=521547074530&spuId=344279177&sellerId=725677994&order=3&currentPage="+i;
                String content = "";
                Thread.sleep(2000);
                System.out.println("crawler--->"+i);
                content = BasicCrawler.crawlPage(url, "gb2312");
                String newcontent = content.replaceAll(";","-");
                int index = newcontent.indexOf("{");
                if(content.contains("{\"rgv587_flag\":\"sm\"")||index==-1){
                    Thread.sleep(5000);
                    System.out.println("ERROR:");
                    i--;
                }else{
                    String json = newcontent.substring(index) ;
                    System.out.println(json);
                    new TMInsert().TMInsertNewAppname("TM","Cowala",json);
                }


            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
