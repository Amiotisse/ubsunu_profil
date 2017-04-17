package com.amiotisse.ubsunu.profile.model;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author himna
 * @since 4/17/2017.
 */
public enum UserType {

    teacher("teacher" ) ,
    student ("student") ;

    private String asString ;
    UserType(String asString){
        this.asString = asString;
    }

    @Override
    public String toString() {
        return asString;
    }

    public static Map<String , UserType> fromString = ImmutableMap
            .<String , UserType> builder()
            .put(UserType.teacher.toString() , UserType.teacher)
            .put(UserType.student.toString() , UserType.student)
            .build();
}
