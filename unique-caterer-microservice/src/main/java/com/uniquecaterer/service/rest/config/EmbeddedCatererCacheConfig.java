package com.uniquecaterer.service.rest.config;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@EnableCaching
@Configuration
public class EmbeddedCatererCacheConfig {

	
	@Value("${spring.appconfig.cache.liveseconds}")
	private int liveSeconds; 
	
	
	@Bean
	Config config() {
		Config config = new Config();
		MapConfig mapConfig = new MapConfig();
		mapConfig.setTimeToLiveSeconds(liveSeconds);
		config.getMapConfigs().put("caterers", mapConfig);
		return config;
	}
}
