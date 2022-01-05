package ru.tcreator.cellar_authomat.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
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
    private FieldUtils fieldUtils;

    @ShellMethod("Generate randomize dots on field")
    public String random() {
        stateKeeper.setField(fieldUtils.generateFieldWithRandomDots(stateKeeper));
        return fieldUtils.toString(stateKeeper.getField());
    }

    @ShellMethod(value = "Set settings")
    public String setting(
            @ShellOption(value = {"--size", "-S"}, defaultValue = "SMALL") FieldSize size,
            @ShellOption(value = {"--cells_alive", "-C"}, defaultValue = "TREE") HowMuchAround cellsAlive,
            @ShellOption(value = {"--delay", "-D"}, defaultValue = "MODERATO") Delay delay,
            @ShellOption(value = {"--accuracy", "-A"}, defaultValue = "90") int accuracy
    ) {
        stateKeeper.setDelay(delay);
        stateKeeper.setHowMuchAround(cellsAlive);
        stateKeeper.setFieldSize(size);
        stateKeeper.setAccuracy(accuracy);
        return "Your params " + stateKeeper;
    }

    @ShellMethod("Draw field")
    private String draw() {
        return fieldUtils.toString(stateKeeper.getField());
    }

//    @ShellMethod("Started cellar automation")
//    public String run(@ShellOption(defaultValue = "10") Integer tact) {
//        if(!createField) {
//            field = fieldUtils.generateFieldWithRandomDots(stateKeeper);
//        }
//        var runner = this.field.getRunner();
//        var counter = tact;
//        var field = this.field;
//            while (counter-- > 0 && !field.isHopeless()) {
//                runner.isAloneAround(stateKeeper);
//                System.out.println(fieldUtils.drawField(field));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            return "Cycle is over";
//    }
}
