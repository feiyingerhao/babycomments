package test.java;

/**
 * Created by haolidong on 2016/11/28.
 */
public class TimeTest {
    public static void main(String args[]){
        for (int i=0;i<10;i++){
            try{
                Thread.sleep(2000);
                System.out.println(i);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
