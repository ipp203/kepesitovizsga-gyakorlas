package hu.nive.ujratervezes.kepesitovizsga6.digits;

public class Digits {

    public int getNumbers() {
        int counter = 0;
        for (int i = 10; i < 100; i++) {
            int tens = i / 10;
            int ones = i % 10;
            if (Math.abs(tens-ones) == 5){
                counter++;
            }
        }
        return counter;
    }
}
