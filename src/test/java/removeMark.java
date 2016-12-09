package test.java;

/**
 * Created by haolidong on 2016/11/27.
 */
public class removeMark {
    public static void main(String args[]){
        String test="<b>好</b><b>的</b>";
        String testRemoveb=test.replaceAll("<b>","").replaceAll("</b>","");
        System.out.println(testRemoveb);
        System.out.println(test.replaceAll("<b>","").replaceAll("</b>",""));
    }

}
