package ru.tcreator.cellar_authomat.utills;

import ru.tcreator.cellar_authomat.model.AroundChecking;
import ru.tcreator.cellar_authomat.model.Dot;
import ru.tcreator.cellar_authomat.model.Field;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

public class FieldUtils {


    public static Field generateField(FieldSize size, Integer condition) {
        var fieldSize = size.getSize();
        CopyOnWriteArrayList<CopyOnWriteArrayList> column = new CopyOnWriteArrayList<>();
        Field newPlace = new Field(column);
        for (int i = 0; i < fieldSize; i++) {
            CopyOnWriteArrayList<AroundChecking> line = new CopyOnWriteArrayList<>();
            for (int j = 0; j < fieldSize; j++) {

                Supplier<Boolean> result = () -> condition < new Random().nextInt(100);
                line.add(
                        result.get()
                            ? new Dot(i , j, true, newPlace)
                            : new Dot(i , j, false, newPlace));
            }
            column.add(line);
        }
        return newPlace;
    }

    public static void printField(Field field) {
        var localField = field.getField();
        StringJoiner stringJoiner = new StringJoiner("|");
        for (int i = 0; i < localField.size(); i++) {
            for (int j = 0; j < localField.size(); j++) {
                stringJoiner.add(localField.get(i).get(j).toString());
            }
            stringJoiner.add("\n");
        }
        System.out.println(stringJoiner.toString());
    }


    public static void dotsStarter(Field field) {
        var localField = field.getField();
         for (int i = 0; i < localField.size(); i++) {
            for (int j = 0; j < localField.size(); j++) {
                var dot = (Dot) localField.get(i).get(j);
                new Thread(dot).start();
            }
        }
    }

}
