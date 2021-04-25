package edu.birzeit.assigment2.models;

public class Education {
    private String degree;
    private String organization;
    private String organizationAddress;

    public Education() {
    }

    public Education(String degree, String organization, String organizationAddress) {
        this.degree = degree;
        this.organization = organization;
        this.organizationAddress = organizationAddress;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    @Override
    public String toString() {
        return "Education{" +
                "degree='" + degree + '\'' +
                ", organization='" + organization + '\'' +
                ", organizationAddress='" + organizationAddress + '\'' +
                '}';
    }
}
