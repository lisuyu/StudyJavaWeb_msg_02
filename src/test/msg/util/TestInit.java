package test.msg.util;
/*
* 生成500个随机用户。用来实现分页
*
* */
import test.msg.dao.DAOFactory;
import test.msg.dao.IUserDao;
import test.msg.model.User;

import java.io.*;
import java.util.Random;

public class TestInit {
    static String[] firstName = new String[]{ };

    static String[] centerName = new String[]{};
    static String[] lastName = new String[]{};

    static Random ran = new Random();

    public static void main(String[] args) {
        String str = readToString("d:/workspace/hanzi.txt");
        String str1 = readToString("d:/workspace/xing.txt");
        firstName = str1.split("\\|");
        centerName = str.split("　");
        lastName = str.split("　");

        IUserDao ud = DAOFactory.getUserDao();
        for (int i=0;i<1000;i++){
            User user = new User();
            user.setUsername(ranName());
            user.setPassword("123");
            user.setType(0);
            user.setStatus(0);
            user.setNickname("小"+user.getUsername().substring(0,1));
            ud.add(user);
        }

        for (String s:firstName){
            System.out.println(s);
        }
    }

    private static String ranName(){
        int num = ran.nextInt(5);
        if (num<2){
            String name1 = firstName[ran.nextInt(firstName.length)];
            String name2 = centerName[ran.nextInt(centerName.length)];
            String name3 = lastName[ran.nextInt(lastName.length)];
            return name1+name2+name3;
        }
        if (num>=2){
            String name1 = firstName[ran.nextInt(firstName.length)];
            String name2 = lastName[ran.nextInt(lastName.length)];
            return name1+name2;
        }
        return null;
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
