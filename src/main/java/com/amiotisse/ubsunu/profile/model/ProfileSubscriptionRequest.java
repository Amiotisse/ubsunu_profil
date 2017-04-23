package com.amiotisse.ubsunu.profile.model;


/**
 * @author himna
 * @since 4/23/2017.
 */
public class ProfileSubscriptionRequest {

    public ProfileSubscriptionRequest(){
        profile = new Profile();
    }

    private Profile profile;

    private String password;

    public String getFirstName() {
        return profile.getFirstName();
    }

    public void setFirstName(String firstName) {
        profile.setFirstName(firstName);
    }

    public String getLastName() {
       return profile.getLastName();
    }

    public void setLastName(String lastName) {
        profile.setLastName(lastName);
    }

    public String getUserName() {
        return profile.getUserName();
    }

    public void setUserName(String userName) {
        profile.setUserName(userName);
    }

    public String getBirthDay() {
        return profile.getBirthDay();
    }

    public void setBirthDay(String birthDay) {
        profile.setBirthDay(birthDay);
    }

    public String getEmail() {
        return profile.getEmail();
    }

    public void setEmail(String email) {
        profile.setEmail(email);
    }

    public UserType getUserType() {
        return profile.getUserType();
    }

    public void setUserType(UserType userType) {
        profile.setUserType(userType);
    }

    public String getOrganisation() {
        return profile.getOrganisation();
    }

    public void setOrganisation(String organisation) {
        profile.setOrganisation(organisation);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
