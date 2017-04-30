package com.amiotisse.ubsunu.profile.repository;

import com.amiotisse.ubsunu.profile.model.Profile;
import com.amiotisse.ubsunu.profile.model.UserType;
import com.amiotisse.ubsunu.profile.model.builder.ProfileBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.*;
/**
 * @author himna
 * @since 4/23/2017.
 */
@Repository
public class ProfileRepository {

    private static final java.lang.String COLLECTION_NAME = "profile";

    private MongoCollection<Document> collection;

    public ProfileRepository(MongoDatabase database ){
        this.collection = database.getCollection(COLLECTION_NAME);
    }

    public Profile save(Profile profile){

        collection.insertOne(documentFromProfile(profile));
        return profile;
    }

    public Profile find (String userName , UserType userType ){
        return profileFromDocument(
                collection.find(
                        and(
                                eq("userName",userName),
                                eq("userType", userType.toString())
                        )
                ).first()
        );
    }

    private Document documentFromProfile (Profile profile){
        return new Document()
                .append("userId" , profile.getUserId())
                .append("userName" , profile.getUserName())
                .append("userType", profile.getUserType().toString())
                .append("email", profile.getEmail())
                .append("lastName" , profile.getLastName())
                .append("firstName" , profile.getFirstName())
                .append("birthDay", profile.getBirthDay())
                .append("organisation", profile.getOrganisation());
    }

    private Profile profileFromDocument (Document document){
        return new ProfileBuilder()
                .setUserId(document.getString("userId"))
                .setUserName(document.getString("userName"))
                .setUserType(UserType.fromString.get(document.getString("userType")))
                .setEmail(document.getString("email"))
                .setLastName(document.getString("lastName"))
                .setFirstName(document.getString("firstName"))
                .setBirthDay(document.getString("birthDay"))
                .setOrganisation(document.getString("organisation"))
                .build();
    }

}
