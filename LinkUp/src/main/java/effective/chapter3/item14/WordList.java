package effective.chapter3.item14;

import java.util.Set;
import java.util.TreeSet;

//实现 comparable方法的好处 page 66
public class WordList {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Set<String> set = new TreeSet<>();
        for (String s : words) {
            set.add(s);
        }
        System.out.println(set);
    }
}
