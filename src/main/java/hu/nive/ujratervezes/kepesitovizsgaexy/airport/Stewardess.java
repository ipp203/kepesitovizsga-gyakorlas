package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

import java.util.Objects;

public class Stewardess extends Person {
    private final Position position;

    public Stewardess(String name, int age, Position position) {
        super(name, age, Type.STEWARDESS);
        this.position = position;
    }

    public Stewardess(String name, Position position) {
        super(name, Type.STEWARDESS);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Stewardess that = (Stewardess) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position);
    }
}
