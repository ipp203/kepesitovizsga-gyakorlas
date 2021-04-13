package hu.nive.ujratervezes.kepesitovizsga2.architect;

public interface Plan {
    String getProjectName();
    int calculateSquareMeter();
    PlanType getType();
}
