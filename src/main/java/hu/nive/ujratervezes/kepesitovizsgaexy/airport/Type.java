package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

public enum Type {
    PASSENGER, GROUNDSTAFF, STEWARDESS, PILOT;

    public boolean isTravel() {
        return this != GROUNDSTAFF;
    }

    public boolean isNotTravel() {
        return this == GROUNDSTAFF;
    }
}
