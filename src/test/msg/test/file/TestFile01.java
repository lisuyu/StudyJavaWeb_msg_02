package test.msg.test.file;

import java.io.File;
import java.io.FilenameFilter;

public class TestFile01 {
    public static void main(String[] args) {
        new TestFile01().run();
    }

    public void run(){
        File f = new File("d:/workspace/userauth");
        String[] files = f.list(new JavaFileFilter());
        for (String fn:files){
            System.out.println(fn);
        }
        System.out.println("--------------------");
        File[] fs = f.listFiles();
        for (File file:fs){
            System.out.println(file.getName()+":"+file.isDirectory()+":"+file.length());
        }
    }

    /*
写一个类实现FilenameFilter专门用来过滤文件
内部类的实现：如果这个类仅仅只是在某个类的内部可以访问，可以直接将该类写在类的内部，这个类在外部就无法访问
内部类要在static之后才能声明，所以不能在static的方法中使用内部类
* */
    class JavaFileFilter implements FilenameFilter{

        @Override
        public boolean accept(File dir, String name) {
            //过滤结果为返回显示为true的值
            if (name.endsWith(".java")) return true;
            return false;
        }
    }
}

