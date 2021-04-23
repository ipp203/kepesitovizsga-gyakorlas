package hu.nive.ujratervezes.kepesitovizsga5.littleredridinghood;

public class Hunter extends Forest{

    public Hunter(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        playersOfTheTale.remove(getPlayerByName("Farkas"));
        playersOfTheTale.add(new Grandma("Nagymama"));
        playersOfTheTale.add(new LittleRedRidingHood("Piroska"));
        LittleRedRidingHood.cake-=3;
    }
}
