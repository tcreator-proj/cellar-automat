package ru.tcreator.cellar_authomat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.FieldUtils;

@Component
public class App implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        Field field = FieldUtils.generateField(FieldSize.SMALL,50);
        FieldUtils.dotsStarter(field);
        for (int i = 0; i < 50; i++) {
            FieldUtils.printField(field);
            Thread.sleep(450);
        }
    }
}
