package edu.birzeit.assigment2.models;

public class Training {
    private String description;
    private String organization;
    private String organizationAddress;

    public Training() {
    }

    public Training(String description, String organization, String organizationAddress) {
        this.description = description;
        this.organization = organization;
        this.organizationAddress = organizationAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Training{" +
                "description='" + description + '\'' +
                ", organization='" + organization + '\'' +
                ", organizationAddress='" + organizationAddress + '\'' +
                '}';
    }
}
