package hu.nive.ujratervezes.kepesitovizsga2.architect;

public class IndustrialBuildingPlan implements Plan{

    private final String projectName;
    private final PlanType planType;
    private final int areaOfOfficeBlock;
    private final int stock;
    private final int areaOfManufacturingHall;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManufacturingHall) {
        this.projectName = projectName;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.stock = stock;
        this.areaOfManufacturingHall = areaOfManufacturingHall;
        planType = PlanType.INDUSTRIAL;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManufacturingHall;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return stock*areaOfOfficeBlock+areaOfManufacturingHall;
    }

    @Override
    public PlanType getType() {
        return planType;
    }
}
