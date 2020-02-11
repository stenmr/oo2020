package w02_klass;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        PersonalCode test = new PersonalCode();
        test.setCode("44");
        System.out.println(test.getCode());
        System.out.println(test.gender());

        System.out.println(test.getAge());
    }
}