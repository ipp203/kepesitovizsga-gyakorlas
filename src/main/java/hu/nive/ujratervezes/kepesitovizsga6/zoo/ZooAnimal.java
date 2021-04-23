package hu.nive.ujratervezes.kepesitovizsga6.zoo;

import java.util.Objects;

public class ZooAnimal {
    protected String name;
    protected int length;
    protected long weight;
    protected AnimalType type;

    public ZooAnimal(String name, int length, long weight, AnimalType type) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZooAnimal)) return false;
        ZooAnimal zooAnimal = (ZooAnimal) o;
        return Objects.equals(name, zooAnimal.name) && type == zooAnimal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
