package ru.tcreator.cellar_authomat.utills;

public enum FieldSize {
    XSMALL(10),
    SMALL(30),
    MEDIUM(40),
    LARGE(50),
    XLARGE(60);

    private final Integer size;


    FieldSize(int i) {
        this.size = i;
    }

    public Integer getSize() {
        return this.size;
    }
}
