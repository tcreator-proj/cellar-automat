package ru.tcreator.cellar_authomat.model;

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
