package ru.tcreator.cellar_authomat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import utills.Field;
import utills.FieldSize;
import utills.FieldUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

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
