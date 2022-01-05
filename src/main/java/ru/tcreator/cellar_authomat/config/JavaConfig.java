package ru.tcreator.cellar_authomat.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tcreator.cellar_authomat.utills.FieldUtils;

import java.util.concurrent.CopyOnWriteArrayList;

@Configuration
public class JavaConfig {

    @Bean
    public CopyOnWriteArrayList<CopyOnWriteArrayList> copyOnWriteArraySets() {
        return new CopyOnWriteArrayList<>();


    }


    @Bean
    public FieldUtils fieldUtils() {
        return new FieldUtils();
    }

}
