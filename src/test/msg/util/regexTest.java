package test.msg.util;

import java.io.*;

public class regexTest {
    public static void main(String[] args) {
        File f = new File("d:/workspace/xing.txt");
        String[] firstName = new String[]{};
        String str = readToString("d:/workspace/xing.txt");
        firstName = str.split("|");
    }


    public static String readToString(String fileName){
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long fileLength = file.length();
        byte[] filecontent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent,encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
