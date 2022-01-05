package ru.tcreator.cellar_authomat.service;
import org.springframework.stereotype.Service;
import ru.tcreator.cellar_authomat.model.Field;


import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class FieldRunner extends Field {


    public FieldRunner(CopyOnWriteArrayList<CopyOnWriteArrayList> field) {
        super(field);
    }

    public void run() {
        while (!isHopeless()) {

            isAloneAround(this);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("While stopped");
    }
}
