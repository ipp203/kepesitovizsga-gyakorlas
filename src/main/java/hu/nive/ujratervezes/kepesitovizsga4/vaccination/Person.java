package hu.nive.ujratervezes.kepesitovizsga4.vaccination;

public class Person {
    public static final int TAJ_LENGTH = 9;
    private final String name;
    private final int age;
    private final String email;
    private final String taj;
    private final VaccinationType type;

    public Person(String name, int age, String email, String taj, VaccinationType type) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.taj = taj;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTaj() {
        return taj;
    }

    public VaccinationType getType() {
        return type;
    }

    public boolean notValidateTaj() {
        if (taj.length() != TAJ_LENGTH) {
            return true;
        }

        char[] numbers = taj.toCharArray();
        int cdv = Character.getNumericValue(numbers[TAJ_LENGTH - 1]);

        int sum = 0;
        for (int i = 0; i < TAJ_LENGTH - 1; i++) {
            if (Character.isDigit(numbers[i])) {
                sum = addToSum(numbers[i], sum, i);
            } else {
                return true;
            }
        }

        return sum % 10 != cdv;
    }

    private int addToSum(char number, int sum, int i) {
        int c = Character.getNumericValue(number);
        if (i % 2 == 0) {
            sum += c * 3;
        } else {
            sum += c * 7;
        }
        return sum;
    }
}
