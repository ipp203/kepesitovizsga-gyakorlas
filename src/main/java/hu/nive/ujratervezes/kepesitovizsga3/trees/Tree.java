package hu.nive.ujratervezes.kepesitovizsga3.trees;

public abstract class Tree {
    protected int leaves;
    protected int weightOfFruit;
    protected Fruit fruit;

    public int getLeaves(){
        return leaves;
    }

    public int getWeightOfFruit() {
        return weightOfFruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    abstract int growLeaves(int numberOfSunnyDays);
    abstract void ripenFruit(int numberOfSunnyDays);

    public int hostBirdNest(){
        return leaves / 200;
    }
}
