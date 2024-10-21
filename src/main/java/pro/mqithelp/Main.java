package pro.mqithelp;

public class Main {
    public static void main(String[] args) {

        StringList qwe = new MqStringList(10);
        qwe.add("1");
        qwe.add("2");
        qwe.add("3");
        qwe.add("4");
        qwe.add("5");
        qwe.add("6");
        qwe.add("7");
        qwe.add("8");
        qwe.add("9");
        qwe.add(30,"RUN");
        qwe.add(2,"GO");
        qwe.add("10");
        System.out.println(qwe);
    }
}