package hu.nive.ujratervezes.kepesitovizsga4.vaccination;

import java.time.LocalDate;

public class MetaData {
    private final String postalCode;
    private final String townName;
    private final LocalDate dateOfVaccination;

    public MetaData(String postalCode, String townName, LocalDate dateOfVaccination) {
        this.postalCode = postalCode;
        this.townName = townName;
        this.dateOfVaccination = dateOfVaccination;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTownName() {
        return townName;
    }

    public LocalDate getDateOfVaccination() {
        return dateOfVaccination;
    }
}
