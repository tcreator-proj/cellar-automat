package ru.tcreator.cellar_authomat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.FieldUtils;

@Component
public class App implements CommandLineRunner {


    @Override
    public void run(String... args) {
        Field field = FieldUtils.generateFieldWithRandomDots(FieldSize.SMALL,80);
        var runner = field.getRunner();
        runner.run();
    }
}
