package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

public class Pilot extends Person {
    private final Position position;

    public Pilot(String name, int age, Position position) {
        super(name, age, Type.PILOT);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
