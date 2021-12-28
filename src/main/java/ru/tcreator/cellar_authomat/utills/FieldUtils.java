package utills;

import model.AroundChecking;
import model.Dot;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FieldUtils {

    public static AroundChecking[][] generateField(FieldSize size, Integer condition) {
        var fieldSize = size.getSize();
        AroundChecking[][] field = new Dot[fieldSize][fieldSize];

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                Supplier<Boolean> result = () -> condition < new Random().nextInt(100);
                field[i][j] = result.get()
                        ? new Dot(i , j, true)
                        : new Dot(i , j, false);
            }
        }
        return field;
    }

    public static void printField(Field field) {
        int fieldLen = field.getField().length;
        AroundChecking[][] tmpField = field.getField();
        StringJoiner stringJoiner = new StringJoiner("|");
        for (int i = 0; i < fieldLen; i++) {
            for (int j = 0; j < fieldLen; j++) {
                stringJoiner.add(tmpField[i][j].toString());
            }
            stringJoiner.add("\n");
        }
        System.out.println(stringJoiner.toString());
    }


    private static String generateRowLine(int size) {
        StringJoiner stringJoiner = new StringJoiner("\u005F");
        for (int i = 0; i < size; i++) {
            stringJoiner.add("");
        }
        return stringJoiner.toString();
    }
}
