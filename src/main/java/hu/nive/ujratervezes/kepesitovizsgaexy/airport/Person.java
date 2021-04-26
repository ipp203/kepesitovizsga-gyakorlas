package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

import java.util.Objects;

public abstract class Person {
    private final String name;
    private Integer age;
    private final Type type;

    protected Person(String name, Integer age, Type type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    protected Person(String name, Type type) {
        this.name = name;
        this.age = null;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Type getType() {
        return type;
    }

    public void incAge() {
        if (age != null) {
            age++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && type == person.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
