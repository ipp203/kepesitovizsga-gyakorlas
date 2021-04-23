package hu.nive.ujratervezes.kepesitovizsga5.littleredridinghood;

public class Grandma extends Forest{

    public Grandma(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        LittleRedRidingHood.cake-=2;
    }
}
