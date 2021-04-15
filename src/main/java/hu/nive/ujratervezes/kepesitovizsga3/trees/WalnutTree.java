package hu.nive.ujratervezes.kepesitovizsga3.trees;

public class WalnutTree extends Tree {

    public WalnutTree(int leaves) {
        this.leaves = leaves;
        weightOfFruit = 0;
        fruit = Fruit.WALNUT;
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves += numberOfSunnyDays * 30;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        weightOfFruit += leaves / 10;
    }
}
