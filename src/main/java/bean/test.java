package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        String a = "hello";
        String b = a;
        Map<Integer,String> map1 = new HashMap<Integer, String>();
        Map<Integer,String> map2 = new HashMap<Integer, String>();
        map1.put(1,"hello");
        map1.put(2,"world");
        map2.put(1,"hello");
        map2.put(3,"worldworld");
        map1.putAll(map2);
        System.out.println(map1);
        System.out.println(map2);
    }
}
