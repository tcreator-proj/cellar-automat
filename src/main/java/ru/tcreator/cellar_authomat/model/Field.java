package ru.tcreator.cellar_authomat.model;

import java.util.concurrent.CopyOnWriteArrayList;

public class Field implements Runnable{

    private final CopyOnWriteArrayList<CopyOnWriteArrayList> field;

    public Field(CopyOnWriteArrayList<CopyOnWriteArrayList> field) {
        this.field = field;
    }

    @Override
    public void run() {

    }



    public CopyOnWriteArrayList<CopyOnWriteArrayList> getField() {
        return this.field;
    }


}
