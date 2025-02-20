package w050211;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStreams {

    public static <T> void show(String title, Stream<T> stream){
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0 ) System.out.print(",");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "hello, world,ni,asd,zlxcknaoi,aosidjqoiwd,dasdasdasdioj,north,six,even,ten,one,me";
        Stream<String> words = Stream.of(str.split(","));
        show("song", words);
        Stream<String> silence = Stream.empty();
        Stream.of("silence", silence);
        Stream<String> generate = Stream.generate(() -> "Echo");
        show("echos", generate);
        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);
    }
 }
