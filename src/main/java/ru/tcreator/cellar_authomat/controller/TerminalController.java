package ru.tcreator.cellar_authomat.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.repository.StateKeeper;
import ru.tcreator.cellar_authomat.utills.Delay;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.FieldUtils;
import ru.tcreator.cellar_authomat.utills.HowMuchAround;

@ShellComponent
@AllArgsConstructor
@NoArgsConstructor
public class TerminalController {
    @Autowired
    private StateKeeper stateKeeper;

    @Autowired
    private Field field;

    @Autowired
    private FieldUtils fieldUtils;

    @ShellMethod("Greetings")
    public String get() {
        var f = fieldUtils.generateFieldWithRandomDots(stateKeeper.getFieldSize(), 50);
//        var runner = field.getRunner();
        fieldUtils.drawField(f);
        return stateKeeper.toString();
    }

    @ShellMethod(value = "Set settings")
    public String setting(
            @ShellOption(value = {"--size", "-s"}, defaultValue = "SMALL") FieldSize size,
            @ShellOption(value = {"--cells_alive", "-C"}, defaultValue = "TREE") HowMuchAround cellsAlive,
            @ShellOption(value = {"--delay", "-D"}, defaultValue = "MODERATO") Delay delay
    ) {
        stateKeeper.setDelay(delay);
        stateKeeper.setHowMuchAround(cellsAlive);
        stateKeeper.setFieldSize(size);
        return "Your params " + stateKeeper;
    }
}
