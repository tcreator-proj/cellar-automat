package utills;

import model.AroundChecking;


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
