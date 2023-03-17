package com.csys.compte.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:OptionVersion.yml")
@ConfigurationProperties

public class OptionVersion {




}
