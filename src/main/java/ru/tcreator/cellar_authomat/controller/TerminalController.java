package ru.tcreator.cellar_authomat.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.utills.FieldSize;
import ru.tcreator.cellar_authomat.utills.FieldUtils;

@ShellComponent
@AllArgsConstructor
public class TerminalController {

    @Autowired
    private Field field;
    @Autowired
    private FieldSize fieldSize;

    @Autowired
    private FieldUtils fieldUtils;

    @ShellMethod("Greetings")
    public String hello(String text) {
        var f = fieldUtils.generateFieldWithRandomDots(FieldSize.XSMALL, 50);
        return fieldUtils.drawField(f);
    }

}
