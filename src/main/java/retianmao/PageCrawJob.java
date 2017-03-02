package main.java.retianmao;


import main.java.general.BasicCrawler;
import main.java.mongodb.TMInsert;
import main.java.tianmao.PageParseJob;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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
        for (int i = 2;i<=99;i++){
            try{
                String url="https://rate.tmall.com/list_detail_rate.htm?itemId=521547074530&spuId=344279177&sellerId=725677994&order=3&currentPage="+i;
                String content = "";
                Thread.sleep(2000);
                System.out.println("crawler--->"+i);
                content = BasicCrawler.crawlPage(url, "gb2312");
                String newcontent = content.replaceAll(";","-");
                int index = newcontent.indexOf("{");
                String json = newcontent.substring(index);
                if(index==-1){
                    Thread.sleep(120000);
                    System.out.println("ERROR:");
                }
                System.out.println(json);
                new TMInsert().TMInsertNewAppname("qingtingfm","Cowala",json);

            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
