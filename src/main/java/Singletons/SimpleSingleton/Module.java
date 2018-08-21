package Singletons.SimpleSingleton;

public class Module {
    private String moduleId;
    private String moduleTitle;
    private int level;
    private int points;
    private int grade;




    public Module(String moduleId, String moduleTitle, int level, int points, int grade) {
        this.moduleId = moduleId;
        this.moduleTitle = moduleTitle;
        this.level = level;
        this.points = points;
        this.grade = grade;
    }




    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getModuleId() {
        return moduleId;
    }

    @Override
    public String toString() {
        return "ModuleJsonA{" +
                "moduleId='" + moduleId + '\'' +
                ", moduleTitle='" + moduleTitle + '\'' +
                ", level=" + level +
                ", points=" + points +
                ", grade=" + grade +
                '}';
    }
}