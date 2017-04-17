package com.amiotisse.ubsunu.profile.model.builder;

import com.amiotisse.ubsunu.profile.model.Profile;
import com.amiotisse.ubsunu.profile.model.UserType;

public class ProfileBuilder {
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private UserType userType;

    public ProfileBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public ProfileBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ProfileBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ProfileBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public ProfileBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ProfileBuilder setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public Profile build() {
        return new Profile(userId, firstName, lastName, userName, email, userType);
    }
}