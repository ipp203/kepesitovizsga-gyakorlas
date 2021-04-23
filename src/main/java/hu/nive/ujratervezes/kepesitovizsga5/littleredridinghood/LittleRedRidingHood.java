package hu.nive.ujratervezes.kepesitovizsga5.littleredridinghood;

public class LittleRedRidingHood extends Forest{
    public static int cake;

    public LittleRedRidingHood(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        cake--;
    }

}
