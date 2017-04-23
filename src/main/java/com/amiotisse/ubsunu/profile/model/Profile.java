package com.amiotisse.ubsunu.profile.model;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author himna
 * @since 4/17/2017.
 */
public class Profile {

    private String userId ;
    private String firstName;
    private String lastName;
    private String userName;
    private String birthDay;
    private String email;
    private String organisation;
    private UserType userType;

    public Profile(){}

    public Profile(
            String userId,
            String firstName,
            String lastName,
            String userName,
            String birthDay,
            String email,
            String organisation,
            UserType userType
    ) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.birthDay = birthDay;
        this.email = email;
        this.organisation = organisation;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", organisation='" + organisation + '\'' +
                ", userType=" + userType +
                '}';
    }
}
