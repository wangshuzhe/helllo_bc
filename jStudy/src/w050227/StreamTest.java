package w050227;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1");
        Stream<Object> empty = Stream.empty();
        Supplier<Stream<String>> supplier = () -> Stream.of("1");
        Stream<Stream<String>> generate = Stream.generate(supplier);
        generate.forEach(System.out::println);
    }
}
