package hu.nive.ujratervezes.kepesitovizsga1.covid;

public class Person {
    public enum ChronicDisease {
        YES, NO
    }

    public enum Pregnancy {
        YES, NO
    }

    private final String name;
    private final int age;
    private final ChronicDisease chronicDisease;
    private final Pregnancy pregnant;

    public Person(String name, int age, ChronicDisease chronicDisease, Pregnancy pregnant) {
        this.name = name;
        this.age = age;
        this.chronicDisease = chronicDisease;
        this.pregnant = pregnant;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasChronicDisease() {
        return chronicDisease == ChronicDisease.YES;
    }

    public boolean isPregnant() {
        return pregnant == Pregnancy.YES;
    }

    public boolean hasNotChronicDisease() {
        return chronicDisease == ChronicDisease.NO;
    }

    public boolean isNotPregnant() {
        return pregnant == Pregnancy.NO;
    }

    public boolean isPensioner() {
        return age > 65;
    }

    public boolean isNotPensioner() {
        return age <= 65;
    }
}

