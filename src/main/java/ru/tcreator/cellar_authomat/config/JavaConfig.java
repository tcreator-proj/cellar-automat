package ru.tcreator.cellar_authomat.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CopyOnWriteArrayList;

@Configuration
public class JavaConfig {

    @Bean
    public CopyOnWriteArrayList<CopyOnWriteArrayList> copyOnWriteArraySets() {
        return new CopyOnWriteArrayList<>();
    }

}
