package hu.nive.ujratervezes.kepesitovizsga5.littleredridinghood;

public class Wolf extends Forest{

    public Wolf(String name) {
        this.name = name;
    }


    @Override
    public void eat() {
        Forest.playersOfTheTale.remove(getPlayerByName("Piroska"));
        Forest.playersOfTheTale.remove(getPlayerByName("Nagymama"));
    }
}
