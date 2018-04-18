package com.Spring.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

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

	
	@Bean
	public MongoClient getMongoClient() throws Exception {

		List<MongoCredential> credentials = new ArrayList<>();
		credentials.add(MongoCredential.createCredential("administrator", "admin", "1234".toCharArray()));
		//credentials.add(MongoCredential.createCredential("administrator", "local", "1234".toCharArray()));
		List<ServerAddress> seeds = new ArrayList<>();
		seeds.add(new ServerAddress("34.225.145.243", 27017));
		//seeds.add(new ServerAddress("localhost", 27017));
		MongoClientOptions.Builder mongoOperations = MongoClientOptions.builder();

		mongoOperations.connectionsPerHost(50);
		mongoOperations.threadsAllowedToBlockForConnectionMultiplier(5);
		mongoOperations.connectTimeout(1000);
		mongoOperations.socketTimeout(1500);
		mongoOperations.maxWaitTime(1000);
		mongoOperations.socketKeepAlive(true);

		MongoClientOptions options = mongoOperations.build();
		MongoClient mongoClient = new MongoClient(seeds, credentials, options);
		mongoClient.setReadPreference(ReadPreference.secondaryPreferred());
		 return new MongoClient(seeds, credentials, options);
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
	return new MongoTemplate(getMongoClient(), "admin");
	}
}
