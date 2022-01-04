package ru.tcreator.cellar_authomat.utills;

import ru.tcreator.cellar_authomat.model.AroundChecking;
import ru.tcreator.cellar_authomat.model.Dot;
import ru.tcreator.cellar_authomat.model.Field;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

public class FieldUtils {

    public static Field generateFieldWithRandomDots(FieldSize size, Integer condition) {
        var fieldSize = size.getSize();
        CopyOnWriteArrayList<CopyOnWriteArrayList> column = new CopyOnWriteArrayList<>();
        Field newPlace = new Field(column);
        for (int i = 0; i < fieldSize; i++) {
            CopyOnWriteArrayList<AroundChecking> line = new CopyOnWriteArrayList<>();
            for (int j = 0; j < fieldSize; j++) {

                Supplier<Boolean> result = () -> condition < new Random().nextInt(100);
                line.add(
                        result.get()
                            ? new Dot(i , j, true)
                            : new Dot(i , j, false));
            }
            column.add(line);
        }
        return newPlace;
    }

    public static void printField(Field field) {
        var localField= field.getField();
        StringBuilder stringBuilder = new StringBuilder();
        int size = localField.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append("|");
            for (int j = 0; j < size; j++) {
                stringBuilder.append(localField.get(i).get(j).toString()).append("|");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    //    public static void dotAsyncStarter(Field field) {
//        var localField= field.getField();
//         for (int i = 0; i < localField.size(); i++) {
//            for (int j = 0; j < localField.size(); j++) {
//                var dot = (Dot) localField.get(i).get(j);
//                dot.isAloneAround(field);
//            }
//        }
//    }

}
