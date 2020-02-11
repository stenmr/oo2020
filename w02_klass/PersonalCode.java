package w02_klass;

public class PersonalCode {
    
    private String code = "50002090219";
    private int age = 20;
    public static void main(String[] args) {
        PersonalCode myCode = new PersonalCode();
        System.out.println(myCode.gender());
    }

    String gender() {
        int firstNumber = Integer.parseInt(code.substring(0, 1));

        if (firstNumber % 2 == 0) {
            return "female";
        } else {
            return "male";
        }
    }

    void setCode(String code) {
        this.code = code;
    }

    String getCode() {
        return this.code;
    }
    
    public int getAge() {
        return this.age;
    }
}