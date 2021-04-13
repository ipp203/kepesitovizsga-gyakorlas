package hu.nive.ujratervezes.kepesitovizsga2.architect;

public class PublicBuildingPlan implements Plan{

    private final String projectName;
    private final PlanType planType;
    private final int stock;
    private final int area;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
        planType = PlanType.PUBLIC;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return stock*area;
    }

    @Override
    public PlanType getType() {
        return planType;
    }
}
