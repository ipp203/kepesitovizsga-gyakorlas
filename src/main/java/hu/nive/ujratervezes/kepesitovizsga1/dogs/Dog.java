package hu.nive.ujratervezes.kepesitovizsga1.dogs;

public class Dog {
    private final String name;
    private final String country;
    private final String url;

    public Dog(String name, String country, String url) {
        this.name = name;
        this.country = country;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }
}
