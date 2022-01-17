package com.devoria.stockoria;

import com.devoria.stockoria.models.Currency;
import com.devoria.stockoria.services.auth.JwtConfiguration;
import com.devoria.stockoria.services.data.CurrencyService;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static com.nimbusds.jose.JWSAlgorithm.RS256;

@SpringBootApplication
@EnableMongock
public class StockoriaApplication {

    private final JwtConfiguration jwtConfiguration;

    public StockoriaApplication(JwtConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
    }

    public static void main(String[] args) {
        SpringApplication.run(StockoriaApplication.class, args);
    }

    @Bean
    public ConfigurableJWTProcessor configurableJWTProcessor() throws MalformedURLException {
        ResourceRetriever resourceRetriever =
                new DefaultResourceRetriever(jwtConfiguration.getConnectionTimeout(),
                        jwtConfiguration.getReadTimeout());
        URL jwkSetURL= new URL(jwtConfiguration.getJwkUrl());
        JWKSource keySource= new RemoteJWKSet(jwkSetURL, resourceRetriever);
        ConfigurableJWTProcessor jwtProcessor= new DefaultJWTProcessor();
        JWSKeySelector keySelector= new JWSVerificationKeySelector(RS256, keySource);
        jwtProcessor.setJWSKeySelector(keySelector);
        return jwtProcessor;
    }

}
