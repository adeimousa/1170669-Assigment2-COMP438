package edu.birzeit.assigment2.models;

public class ContactInfo {
    private String email;
    private String phone;
    private SocialMedia socialMedia;
    private String socialMediaLink;
    private String addressLine1;
    private String addressLine2;
    private String city;

    public ContactInfo() {
    }

    public ContactInfo(String email, String phone, SocialMedia socialMedia, String socialMediaLink, String addressLine1, String addressLine2, String city) {
        this.email = email;
        this.phone = phone;
        this.socialMedia = socialMedia;
        this.socialMediaLink = socialMediaLink;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SocialMedia getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getSocialMediaLink() {
        return socialMediaLink;
    }

    public void setSocialMediaLink(String socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", socialMedia=" + socialMedia +
                ", socialMediaLink='" + socialMediaLink + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
