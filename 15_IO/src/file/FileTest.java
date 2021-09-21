package file;

import org.junit.Test;

import javax.crypto.spec.PSource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class FileTest {
    /**
     * File的三种创建方式
     * 1.File(pathname):pathname可以是绝对路径也可以是相对路径
     * 2.File(parent,child):parent/child就是文件路径
     * 3.File(File file,child):file路径下的child文件
     */
    @Test
    public void test1(){
       //第一种创建File的方式
        File file1 = new File("test1.txt");
        //写绝对路径的时候，分隔符可以是 \\ 也可以是 / ,因为java是跨平台语言
        //File中还提供了一个分隔符的方式：File.separator
        File file2 = new File("D:\\java\\JavaWeb\\15_IO\\test2.txt");
        //第二种创建File的方式
        File file3 = new File("D:\\java\\JavaWeb", "15_IO");
        //第三种创建File的方式
        File file4 = new File(file3, "test4.txt");
        //输出File在内存中的位置
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);
    }

    /**
     * 测试File类的方法
     * getAbsoluteFile()：获取绝对路径
     * getPath(),获取相对路径
     * getPrent():获取文件上一级路径,如果没有则返回null
     * getName():返回文件名
     * lastModified()：获取最近修改时间
     */
    @Test
    public void test2(){
        File file1 = new File("test1.txt");
        File file2 = new File("D:\\java\\JavaWeb\\15_IO\\test2.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile().getParent());
        System.out.println(file1.getName());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }

    /**
     * renameTo(): 将file1/file2文件中的内容重命名到file2/file1所在的路径
     */
    @Test
    public void test3(){
        File file2 = new File("test1.txt");
        File file1 = new File("D:\\java\\JavaWeb\\15_IO\\test2.txt");
        System.out.println(file1.renameTo(file2));
    }

    /**
     * listFiles():File :返回指定目录下所有文件或者文件目录的File数组
     * list():String :获取指定目录习所有文件或者文件目录的名称数组
     */
    @Test
    public void test4(){
        File file = new File("D:\\java\\JavaWeb");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
        System.out.println("+++++++++++++++");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * isDirectory() :是否问文件路径
     * isFile():是否是文件
     * exists():是否存在于硬板中
     * canRead():是否可读
     * canWrite():是否可写
     * isHidden():是否是隐藏文件
     */
    @Test
    public void test5(){
        File file1 = new File("test1.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    /**
     * delete()：在硬盘中删除，不走回收站
     * createFile():创建该文件
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        File file = new File("test1.txt");
        if (file.exists()){
            file.delete();
            System.out.println("删除成功");
        }else {
            file.createNewFile();
            System.out.println("创建成功");
        }
    }

    /**
     * mkdir():创建目录（只能创建当前存在文件路径的下一级）
     * mkdirs():级联创建文件夹(可以创建当前存在文件下路径的多层下一级路径)
     */
    @Test
    public void test7(){
        File file1 = new File("D:\\java\\JavaWeb\\15_IO\\io");
        System.out.println(file1.mkdir());
        File file2 = new File("D:\\java\\JavaWeb\\15_IO\\io\\io1\\io2");
        System.out.println(file2.mkdirs());
        System.out.println("helloWorld");
        Scanner scanner = new Scanner(System.in);
    }
}
