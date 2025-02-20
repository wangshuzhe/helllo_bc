package w050120;


import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

public class CountLongWords {
    public static void main(String[] args) {
        String words  = "hello,my,name,wwangshuzhe,aaaaaaaaaaaaaas,by,totel,airport";
        String[] split = words.split(",");
        //filter 产生一个流， 其中包含当前流中满足P的所有元素
        //count 产生当前流中元素的数量，这是一个终止操作
        //Stream 顺序流
        long count = Stream.of(split).filter(s -> s.length() > 5).count();
        System.out.println(count);
        //parallelStream 并行流
        long count1 = Arrays.stream(split).parallel().filter(s -> s.length() > 5).count();
        System.out.println(count1);
    }
}
