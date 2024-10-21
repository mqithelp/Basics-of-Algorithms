package pro.mqithelp;

public class Main {
    public static void main(String[] args) {

        StringList qwe = new MqStringList(10);
        qwe.add("Hello");
        qwe.add("All");
        qwe.add("Bye!");
        qwe.add("Hello");
        qwe.add("All");
        qwe.add("Bye!");
        qwe.add("Hello");
        qwe.add("All");
        qwe.add(3,"RUN");
        qwe.add("Bye!");
        System.out.println(qwe);
    }
}