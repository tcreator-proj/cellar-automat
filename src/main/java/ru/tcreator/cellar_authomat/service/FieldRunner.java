package ru.tcreator.cellar_authomat.service;
import org.springframework.stereotype.Service;
import ru.tcreator.cellar_authomat.model.Dot;
import ru.tcreator.cellar_authomat.model.Field;
import ru.tcreator.cellar_authomat.model.LookingAround;
import ru.tcreator.cellar_authomat.repository.StateKeeper;
import ru.tcreator.cellar_authomat.utills.HowMuchAround;


import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class FieldRunner extends Field implements LookingAround {


    public FieldRunner(CopyOnWriteArrayList<CopyOnWriteArrayList> field) {
        super(field);
    }



//    public void viewAroundDots(Field f, StateKeeper settings) {
//        var field= f.getField();
//        var size = settings.getFieldSize();
//        var howManyTimes = settings.getHowMuchAround().getCount(); // куб обхода x * x
//        var x = this.x;
//        var y = this.y;
//        var lastDotX = (x - 1) + 3;
//        var lastDotY = (y - 1) + 3;
//        // количество найденных, живых, клеток
//        int foundedNeighbors = 0;
//        for (int i = x - 1; i < lastDotX; i++) {
//            for (int j = y - 1; j < lastDotY; j++) {
//                // если координата обхода уходит за поле, просто игнорируем его
//                if(i >= 0 && j >= 0 && i < size && j < size ) {
//                    //точка
//                    var thatDot = (Dot) field.get(i).get(j);
//                    // если точка жива
//                    if(thatDot.getLive()) {
//                        // Если точка не равна текущей
//                        if(!this.equals(thatDot)) {
//                            foundedNeighbors++;
//                        }
//                    }
//                }
//            }
//            if(foundedNeighbors >= howManyTimes) {
//                alive();
//                break;
//            }
//        }
//        // если количество найденных точек меньше howManyTimes - убить клетку
//        if (foundedNeighbors < howManyTimes ) {
//            die();
//        }
//    }

    @Override
    public void isAloneAround(StateKeeper settings) {
        int size = settings.getField().getField().size();
        var currentField = this.field;
        CopyOnWriteArrayList<CopyOnWriteArrayList> newField = new CopyOnWriteArrayList<>();
        for (int i = 0; i < size; i++) {
            newField.add(new CopyOnWriteArrayList());
            for (int j = 0; j < size; j++) {
                Dot dot = (Dot) currentField.get(i).get(j);
//                dot.isAloneAround(f);
                newField.get(i).add(j, dot.clone());
            }
        }
        this.field = newField;
    }
}
