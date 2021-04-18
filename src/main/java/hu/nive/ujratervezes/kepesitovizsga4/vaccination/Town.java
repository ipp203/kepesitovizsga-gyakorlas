package hu.nive.ujratervezes.kepesitovizsga4.vaccination;

public class Town {
    private final String townName;
    private final String postalCode;

    public Town(String townName, String postalCode) {
        this.townName = townName;
        this.postalCode = postalCode;
    }

    public String getTownName() {
        return townName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
