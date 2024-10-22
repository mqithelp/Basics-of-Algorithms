package pro.mqithelp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MqStringList stringList = new MqStringList(10);
        String item = "002";
        stringList.add(item);
        System.out.println(stringList.size());
    }
}