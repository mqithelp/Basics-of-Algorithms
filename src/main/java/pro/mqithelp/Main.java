package pro.mqithelp;

public class Main {
    public static void main(String[] args) {
        MqStringList stringList = new MqStringList(10);
        int index = 20;
        int i = 0;
        do {
            stringList.add(Integer.toString(i));
        } while (index > i++);
        System.out.println(stringList);
    }
}