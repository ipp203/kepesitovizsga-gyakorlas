package hu.nive.ujratervezes.kepesitovizsga3.trees;

public class AppleTree extends Tree {

    public AppleTree(int leaves) {
        this.leaves = leaves;
        weightOfFruit = 0;
        fruit = Fruit.APPLE;
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves += numberOfSunnyDays * 10;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        weightOfFruit += leaves / 50;
    }

}
