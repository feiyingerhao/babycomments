package main.java.tianmao;


import java.util.logging.Logger;

/**
 * Created by haolidong on 2016/11/14.
 */
public class PageCrawJob {
    private static Logger logger = Logger.getLogger(PageCrawJob.class.getName());
    public static void main(String[] args){
        try{

            PageParseJob crawler =new PageParseJob();
            int end=1;
            String url="https://rate.tmall.com/list_detail_rate.htm?itemId=22843468031&spuId=215701922&sellerId=1115154404&order=3&currentPage=";
            String filePath="data/tianmao/nutrilon官方旗舰店-Nutrilon诺优能(牛栏)_荷兰版_4800g_三段";
            for (int i = 1;i<=99;i++){
                System.out.println(i);
                Thread.currentThread().sleep(2000);
                if(i==1){
                    end=crawler.parse(url+i, filePath,i);
                    System.out.println("-->"+end);
                    if(end==-2){
                        i--;
                    }
                }else{
                    int tmp=crawler.parse(url+i, filePath,i);
                    System.out.println("tmp-->"+tmp);
                    if(tmp!=0){
                        i--;
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
