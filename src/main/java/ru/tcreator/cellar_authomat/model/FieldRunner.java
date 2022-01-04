package ru.tcreator.cellar_authomat.model;

import ru.tcreator.cellar_authomat.utills.FieldUtils;

import java.util.concurrent.CopyOnWriteArrayList;

public class FieldRunner extends Field {
    public FieldRunner(CopyOnWriteArrayList<CopyOnWriteArrayList> field) {
        super(field);
    }

    public void run() {
        while (!isHopeless()) {
            FieldUtils.printField(this);
            isAloneAround(this);
            FieldUtils.printField(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("While stopped");
    }
}
