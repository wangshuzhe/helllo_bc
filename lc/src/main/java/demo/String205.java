package demo;

import java.util.HashMap;
import java.util.Map;

public class String205 {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));

    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i =0; i < s.length(); i++) {
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            if (null != mapS.get(cs) && mapS.get(cs) != ct) {
                return false;
            }
            if (null != mapT.get(ct) && mapT.get(ct) != cs) {
                return false;
            }
            mapT.put(ct, cs);
            mapS.put(cs, ct);
        }
        return true;
    }
}
