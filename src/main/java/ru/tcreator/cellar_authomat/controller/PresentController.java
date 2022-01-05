package ru.tcreator.cellar_authomat.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PresentController {

    @ShellMethod("visual")
    public String present(String s) {
        return s;
    }

}
