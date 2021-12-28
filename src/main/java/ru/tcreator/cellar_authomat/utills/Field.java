package ru.tcreator.cellar_authomat.utills;
import ru.tcreator.cellar_authomat.model.AroundChecking;

public class Field {

    private final AroundChecking[][] field;
//    private AroundChecking[][] cField;

    public Field(AroundChecking[][] field) {
        this.field = field;
    }

    public AroundChecking[][] getField() {
        return this.field;
    }
}
