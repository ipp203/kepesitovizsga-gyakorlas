package hu.nive.ujratervezes.kepesitovizsga2.architect;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArchitectStudio {

    private final Map<String, Plan> planMap = new HashMap<>();

    public void addPlan(String workingTitle, Plan plan) {
        if (workingTitle == null || workingTitle.isBlank() || plan == null) {
            throw new IllegalArgumentException("Working title and plan must not be empty!");
        }

        planMap.put(workingTitle, plan);
    }

    public Plan getPlanWithMaxSquareMeter() {
        return planMap.values().stream()
                .max(Comparator.comparingInt(Plan::calculateSquareMeter)).orElse(null);
    }

    public Plan getPlanByWorkingTitle(String workingTitle) {
        if (workingTitle == null || workingTitle.isBlank()) {
            throw new IllegalArgumentException("Working title must not be empty!");
        }
        if (planMap.containsKey(workingTitle)) {
            return planMap.get(workingTitle);
        } else {
            throw new IllegalArgumentException("No such project.");
        }
    }

    public Plan getPlanByProjectName(String projectName) {
        if (projectName == null || projectName.isBlank()) {
            throw new IllegalArgumentException("Project name must not be empty!");
        }

        return planMap.values().stream()
                .filter(p -> p.getProjectName().equals(projectName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No such project."));

    }

    public List<Plan> getSmallerPlans(int squareMeter) {
        return planMap.values().stream()
                .filter(p -> p.calculateSquareMeter() < squareMeter)
                .collect(Collectors.toList());
    }

    public List<Plan> getListOfPlansByPlanType(PlanType type) {
        if (type == null) {
            throw new IllegalArgumentException("Parameter must not be null!");
        }
        return planMap.values().stream()
                .filter(p -> p.getType() == type)
                .collect(Collectors.toList());
    }

}
