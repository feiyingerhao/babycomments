package main.java.retianmao;


import main.java.general.BasicCrawler;
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
        try{
            String url="https://rate.tmall.com/list_detail_rate.htm?itemId=22843468031&spuId=215701922&sellerId=1115154404&order=3&currentPage=";
            String filePath="data/tianmao/nutrilon官方旗舰店-Nutrilon诺优能(牛栏)_荷兰版_4800g_三段";
            String content="";
            for (int i = 1;i<=99;i++){
                System.out.println(i);
                Thread.currentThread().sleep(1000);
                content= BasicCrawler.crawlPage(url+i,"gb2312");
                //System.out.println(content);
                //if(content.startsWith("\"rateDetail\"")){
                if(!content.contains("rgv587_flag")){
                    ls.add(content);
                } else {
                    i--;
                }


                //}
            }
            FileOutputStream fo = new FileOutputStream(new File(filePath));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
            for (int i=0;i<ls.size();i++){
                String bwStr=ls.get(i).replaceAll("\\n","")+"\n";
                System.out.print(bwStr);
                bw.write(bwStr);
            }
            bw.close();
            fo.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
