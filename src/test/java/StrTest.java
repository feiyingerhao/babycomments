package test.java;

/**
 * Created by haolidong on 2016/11/28.
 */
public class StrTest {
    public static void main(String args[]){
        String s="\"rateDetail\":{\"paginator\":{\"i";
        if(!s.startsWith("\"rateDetail\"")){
            System.out.println(s);
        }
    }
}
