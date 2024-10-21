package pro.mqithelp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] testArrayList;
        StringList qwe = new MqStringList(10);
        qwe.add("1");
        qwe.add("2");
        qwe.add("3");
        qwe.add("4");
        qwe.add("5");
        qwe.add("6");
        qwe.add("7");
        System.out.println(qwe.lastIndexOf("5"));
       // qwe.remove("3");
        qwe.add("8");
        qwe.add("9");
        qwe.add(3,"RUN");
        System.out.println(qwe.isEmpty());
//        qwe.clear();
        System.out.println(qwe.isEmpty());
        System.out.println(qwe);
        testArrayList = qwe.toArray();
        System.out.println(Arrays.toString(testArrayList));
    }
}