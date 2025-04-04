package w050403;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test1 {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        Path path = Paths.get(property, "123.txt");
        System.out.println("返回最后一个元素名称:" + path.getFileName());
        System.out.println("第0个元素:" + path.getName(0));
        System.out.println("跟路径:" + path.getRoot());
        System.out.println("返回当前目录数:" + path.getNameCount());
        System.out.println("截取路径(不包括跟元素):" + path.subpath(0,2));
        System.out.println("返回父目录的路径:" + path.getParent());
        System.out.println("当前目录下的文件路径:" + path);
    }
}
