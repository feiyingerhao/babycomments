package test.java;

/**
 * Created by haolidong on 2016/12/1.
 */
public class Test {
    public static void main(String args[]){
        String s="/usr/local/hadoop/bin";
        String[] splits=s.split("/");
        for(String ss:splits){
            System.out.println(ss);
        }
    }
}
