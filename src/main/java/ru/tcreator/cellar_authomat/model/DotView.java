package ru.tcreator.cellar_authomat.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("ru.tcreator.cellar_authomat.model")
public enum DotView {
    DEAD(" "),
    LIVE("X");

    private final String view;

    DotView(String s) {
        this.view = s;
    }

    public String getView() {
        return this.view;
    }
}
