package main.java.JDcraw;


import main.java.general.BasicCrawler;

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
        try {
            String url = "http://sclub.jd.com/comment/productPageComments.action?productId=1029507&score=0&sortType=3&page=1&pageSize=10";
            //String filePath = "data/tianmao/nutrilon官方旗舰店-Nutrilon诺优能(牛栏)_荷兰版_4800g_三段";
            String content = "";
            content = BasicCrawler.crawlPage(url, "gb2312");
            System.out.println(content);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
