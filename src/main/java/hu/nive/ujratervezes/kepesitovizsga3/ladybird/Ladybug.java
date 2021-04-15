package hu.nive.ujratervezes.kepesitovizsga3.ladybird;

import java.util.Objects;

public class Ladybug {
    private final String hungarianName;
    private final String latinName;
    private final String genus;
    private final int numberOfPoints;

    public Ladybug(String hungarianName, String latinName, String genus, int numberOfPoints) {
        this.hungarianName = hungarianName;
        this.latinName = latinName;
        this.genus = genus;
        this.numberOfPoints = numberOfPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladybug ladybug = (Ladybug) o;
        return numberOfPoints == ladybug.numberOfPoints &&
                hungarianName.equals(ladybug.hungarianName) &&
                latinName.equals(ladybug.latinName) &&
                genus.equals(ladybug.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hungarianName, latinName, genus, numberOfPoints);
    }
}
