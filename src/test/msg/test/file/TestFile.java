package test.msg.test.file;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) {
        try {
            File f = new File("d:/workspace/test.txt");
            File f1 = new File("d:/workspace/test01.txt");
            //创建文件
            f1.createNewFile();
            //判断文件是否存在
            System.out.println(f.exists());
            //删除文件
            f1.delete();
            //获取文件名
            System.out.println(f.getName());
            //获取文件夹路径
            System.out.println(f.getParent());
            //上级文件夹对象
            File pf = f.getParentFile();
            System.out.println(pf);
            //判断是否为文件夹
            System.out.println(pf.isDirectory());

            File f2 = new File("d:/workspace/a");
            //创建目录
            f2.mkdir();

            //创建一连串的目录
            File f3 = new File("d:/workspace/a/b/c/d/e/f/g");
            f3.mkdirs();
            //重命名文件，可以用来做剪切
            f1.renameTo(new File("d:/workspce/test02.txt"));

            //Windows系统可以跨盘符重命名
            f.renameTo(new File("f:1.txt"));

            //正确删除文件夹的操作是递归删除所有文件和子文件夹
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
