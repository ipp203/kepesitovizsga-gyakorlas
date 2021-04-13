package hu.nive.ujratervezes.kepesitovizsga2.architect;

public class ResidentialBuildingPlan implements Plan{

    private final String projectName;
    private final PlanType planType;
    private final House house;
    private final int stock;
    private final int area;


    public ResidentialBuildingPlan(String projectName, House house, int stock, int area) {
        this.projectName = projectName;
        this.house = house;
        this.stock = stock;
        this.area = area;
        planType = PlanType.RESIDENTIAL;
    }

    public House getHouse() {
        return house;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }

    @Override
    public int calculateSquareMeter(){
        return stock*area;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public PlanType getType() {
        return planType;
    }
}
