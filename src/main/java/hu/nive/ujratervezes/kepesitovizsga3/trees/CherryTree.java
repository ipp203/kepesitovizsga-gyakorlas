package hu.nive.ujratervezes.kepesitovizsga3.trees;

public class CherryTree extends Tree{

    public CherryTree(int leaves) {
        this.leaves = leaves;
        weightOfFruit = 0;
        fruit = Fruit.CHERRY;
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        leaves += numberOfSunnyDays * 20;
        return leaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        weightOfFruit += leaves / 30;
    }
}
