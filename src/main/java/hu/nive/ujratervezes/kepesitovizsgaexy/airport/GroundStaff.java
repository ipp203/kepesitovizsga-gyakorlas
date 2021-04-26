package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

public class GroundStaff extends Person {
    private final String job;

    public GroundStaff(String name, int age, String job) {
        super(name, age, Type.GROUNDSTAFF);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

}
