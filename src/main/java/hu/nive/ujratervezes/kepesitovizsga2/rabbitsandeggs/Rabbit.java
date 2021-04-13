package hu.nive.ujratervezes.kepesitovizsga2.rabbitsandeggs;

public class Rabbit {
    private final String name;
    private final int eggs;

    public Rabbit(String name, int eggs) {
        this.name = name;
        this.eggs = eggs;
    }

    public String getName() {
        return name;
    }

    public int getEggs() {
        return eggs;
    }
}
