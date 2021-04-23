package hu.nive.ujratervezes.kepesitovizsga5.littleredridinghood;

import java.util.List;
import java.util.Objects;

public abstract class Forest {
    public static List<Forest> playersOfTheTale;
    protected String name;

    public String getName() {
        return name;
    }

    public abstract void eat();

    protected Forest getPlayerByName(String name){

        return playersOfTheTale.stream()
                .filter(p->p.getName().equals(name))
                .findFirst().orElseThrow(()->new IllegalArgumentException("This name is not in the tale: " + name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forest forest = (Forest) o;
        return Objects.equals(name, forest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
