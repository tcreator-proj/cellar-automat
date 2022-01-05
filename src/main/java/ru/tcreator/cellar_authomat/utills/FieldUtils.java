package ru.tcreator.cellar_authomat.utills;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.model.Cell;
import ru.tcreator.cellar_authomat.model.Dot;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.repository.StateKeeper;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

@Component
@NoArgsConstructor
public class FieldUtils {

    public Field generateEmptyField(FieldSize size) {
        var fieldSize = size.getSize();
        CopyOnWriteArrayList<CopyOnWriteArrayList> column = new CopyOnWriteArrayList<>();
        Field newPlace = new Field(column);
        for (int i = 0; i < fieldSize; i++) {
            CopyOnWriteArrayList<Cell> line = new CopyOnWriteArrayList<>();
            for (int j = 0; j < fieldSize; j++) {
                line.add(new Dot(i , j, false));
            }
            column.add(line);
        }
        return newPlace;
    }

    public Field generateFieldWithRandomDots(StateKeeper stateKeeper) {
        var fieldSize = stateKeeper.getFieldSize().getSize();
        var accuracy  = stateKeeper.getAccuracy();
        CopyOnWriteArrayList<CopyOnWriteArrayList> column = new CopyOnWriteArrayList<>();
        Field newPlace = new Field(column);
        for (int i = 0; i < fieldSize; i++) {
            CopyOnWriteArrayList<Cell> line = new CopyOnWriteArrayList<>();
            for (int j = 0; j < fieldSize; j++) {
                Supplier<Boolean> result = () -> accuracy < new Random().nextInt(100);

                line.add(
                        result.get()
                            ? new Dot(i , j, true)
                            : new Dot(i , j, false)
                );
            }
            column.add(line);
        }
        return newPlace;
    }

    public String toString(Field field) {
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
        return stringBuilder.toString();
    }

}
