package edu.birzeit.assigment2.models;

public class JobSkill {
    private String skillName;
    private int experienceRate;

    public JobSkill() {
    }

    public JobSkill(String skillName, int experienceRate) {
        this.skillName = skillName;
        this.experienceRate = experienceRate;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getExperienceRate() {
        return experienceRate;
    }

    public void setExperienceRate(int experienceRate) {
        this.experienceRate = experienceRate;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "skillName='" + skillName + '\'' +
                ", experienceRate=" + experienceRate +
                '}';
    }
}
