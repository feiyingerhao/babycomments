package main.java.tianmao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by haolidong on 2016/11/27.
 */
public class FileDel {
    public static void append(String filename,String content){
        try{
            FileOutputStream fo = new FileOutputStream(new File(filename),true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
            bw.write(content+"\n");
            bw.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        append("data/tianmao/naifeng","hello2");
    }
}
