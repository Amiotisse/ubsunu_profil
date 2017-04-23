package com.amiotisse.ubsunu.profile.repository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author himna
 * @since 2/12/2017.
 */
@Configuration
public class RepositoryConfiguration {

    @Value("${ubsunu.profile.db.mongo.uri}")
    String mongodbUri;
    @Value("${ubsunu.profile.db.mongo.databaseName}")
    String databaseName;

   /*
   @Bean
    MongoClientOptions clientOptions (){
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(new JacksonCodecProvider(ObjectMapperFactory.createObjectMapper())));

        return MongoClientOptions.builder()
                .codecRegistry(codecRegistry)
                .build();
    }
    */

    @Bean MongoClient client (){
        MongoClientURI connectionString = new MongoClientURI(mongodbUri);
        return new MongoClient(connectionString);
    }

    @Bean
    public MongoDatabase database (@Qualifier("client") MongoClient mongoClient ) {
        return mongoClient.getDatabase(databaseName);
    }


}
