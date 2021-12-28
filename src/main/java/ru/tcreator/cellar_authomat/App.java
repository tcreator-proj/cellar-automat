package ru.tcreator.cellar_authomat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.utills.Field;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.FieldUtils;

@Component
public class App implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        Field field = new Field(
                FieldUtils.generateField(FieldSize.SMALL,98)
        );


        FieldUtils.printField(field);

    }
}
