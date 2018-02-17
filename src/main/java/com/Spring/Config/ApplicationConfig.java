package com.Spring.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
 
/**
 * 
 * @author Faiz Akram
 *
 */
@Configuration
@ComponentScan(basePackages = "com.Spring")
public class ApplicationConfig {
 
   /* @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongoClient, "local", userCredentials);
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }*/
    
 /*  @SuppressWarnings("serial")
	public @Bean MongoClient mongoClient() throws UnknownHostException {
		return new MongoClient(new ServerAddress(" 34.225.145.243", 27017), new ArrayList<MongoCredential>() {

			{
				add(MongoCredential.createCredential("administrator", "admin", "Comp@0989".toCharArray()));
			}
		});
	}*/

	
	
	/*public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongoClient(), "admin");
	}*/
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {

		   List<MongoCredential> credentials = new ArrayList<>();
		   credentials.add(MongoCredential.createCredential("myUserAdmin", "admin", 
				   "abc123".toCharArray()));
		// Set credentials

		List<ServerAddress> seeds = new ArrayList<>();
		seeds.add(new ServerAddress("localhost", 27017));
		// Mongo Client

		MongoClientOptions.Builder mongoOperations = MongoClientOptions.builder();

		mongoOperations.connectionsPerHost(50);
		mongoOperations.threadsAllowedToBlockForConnectionMultiplier(5);
		mongoOperations.connectTimeout(1000);
		mongoOperations.socketTimeout(1500);
		mongoOperations.maxWaitTime(1000);
		mongoOperations.socketKeepAlive(true);
		
		/* * mongo.slave-ok=true #Write concern NONE: -1, NORMAL: 0, SAFE: 1
		 * (default) mongo.write-number=1 #set the timeout for waiting for write
		 * concern to finish mongo.write-timeout=0 #Durability option that
		 * forces mongo to flush to disk after each write when true
		 * mongo.write-fsync=true*/
		 
		MongoClientOptions options=mongoOperations.build();
		
		MongoClient mongoClient = new MongoClient(seeds, credentials, options);
		
		mongoClient.setReadPreference(ReadPreference.secondaryPreferred());
		//mongoClient.fsync(true);
		// Mongo DB Factory
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "admin");
		return simpleMongoDbFactory;
	}


	public @Bean MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
}
