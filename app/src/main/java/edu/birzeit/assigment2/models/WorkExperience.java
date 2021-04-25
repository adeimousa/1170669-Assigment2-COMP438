package edu.birzeit.assigment2.models;

public class WorkExperience {
    private String organization;
    private String description;
    private JobSkill skill1;
    private JobSkill skill2;
    private JobSkill skill3;

    public WorkExperience() {
    }

    public WorkExperience(String organization, String description, JobSkill skill1, JobSkill skill2, JobSkill skill3) {
        this.organization = organization;
        this.description = description;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobSkill getSkill1() {
        return skill1;
    }

    public void setSkill1(JobSkill skill1) {
        this.skill1 = skill1;
    }

    public JobSkill getSkill2() {
        return skill2;
    }

    public void setSkill2(JobSkill skill2) {
        this.skill2 = skill2;
    }

    public JobSkill getSkill3() {
        return skill3;
    }

    public void setSkill3(JobSkill skill3) {
        this.skill3 = skill3;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "organization='" + organization + '\'' +
                ", description='" + description + '\'' +
                ", skill1=" + skill1 +
                ", skill2=" + skill2 +
                ", skill3=" + skill3 +
                '}';
    }
}
