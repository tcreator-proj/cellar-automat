package ru.tcreator.cellar_authomat.repository;

import lombok.*;
import org.springframework.shell.standard.ShellComponent;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.utills.Delay;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.FieldUtils;
import ru.tcreator.cellar_authomat.utills.HowMuchAround;

@Getter
@Setter
@ShellComponent
@AllArgsConstructor
@NoArgsConstructor
public class StateKeeper {

    private Field field = new FieldUtils().generateEmptyField(FieldSize.SMALL);

    private FieldSize fieldSize = FieldSize.SMALL;

    private HowMuchAround howMuchAround = HowMuchAround.TREE;

    private Delay delay = Delay.MODERATO;

    private Integer accuracy = 90;

    @Override
    public String toString() {
        return "Settings: \n" +
                "Field size = " + fieldSize.getSize() + "\n" +
                "Live cells detect = " + howMuchAround.getCount() + "\n" +
                "Delay temp = " + delay.getTempo() + "\n" +
                "Generate cells accuracy = " + accuracy + "\n" +
                "Field example: " + "\n" + new FieldUtils().toString(field);

    }
}
