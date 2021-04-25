package edu.birzeit.assigment2.models;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String about;
    private Date dateOfBirth;
    private Gender gender;
    private String Country;
    private Education education;
    private WorkExperience workExperience;
    private Training training;
    private ContactInfo contactInfo;

    public Person() {
    }

    public Person(String firstName, String lastName, String about, Date dateOfBirth, Gender gender, String country, Education education, WorkExperience workExperience, Training training, ContactInfo contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = about;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        Country = country;
        this.education = education;
        this.workExperience = workExperience;
        this.training = training;
        this.contactInfo = contactInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", about='" + about + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", Country='" + Country + '\'' +
                ", education=" + education +
                ", workExperience=" + workExperience +
                ", training=" + training +
                ", contactInfo=" + contactInfo +
                '}';
    }
}
