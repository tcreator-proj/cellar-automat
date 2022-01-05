package ru.tcreator.cellar_authomat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.utills.DotView;
import ru.tcreator.cellar_authomat.utills.HowMuchAround;

import java.util.Objects;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Dot implements AroundChecking, Cloneable {
    private Integer x;
    private Integer y;
    private Boolean live;

    @Override
    public void isAloneAround(Field f) {
        var field= f.getField();
        var size = field.size();
        var howManyTimes = HowMuchAround.TREE.getCount(); // куб обхода x * x
        var x = this.x;
        var y = this.y;
        var lastDotX = (x - 1) + 3;
        var lastDotY = (y - 1) + 3;
        // количество найденных, живых, клеток
        int foundedNeighbors = 0;
        for (int i = x - 1; i < lastDotX; i++) {
            for (int j = y - 1; j < lastDotY; j++) {
                // если координата обхода уходит за поле, просто игнорируем его
                if(i >= 0 && j >= 0 && i < size && j < size ) {
                    //точка
                    var thatDot = (Dot) field.get(i).get(j);
                    // если точка жива
                    if(thatDot.getLive()) {
                        // Если точка не равна текущей
                        if(!this.equals(thatDot)) {
                            foundedNeighbors++;
                        }
                    }
                }
            }
            if(foundedNeighbors >= howManyTimes) {
                alive();
                break;
            }
        }
        // если количество найденных точек меньше howManyTimes - убить клетку
        if (foundedNeighbors < howManyTimes ) {
            die();
        }
    }

    // Воскрешает клетку
    public void alive() {
        this.live = true;
    }

    // Убивает клетку
    public void die() {
        this.live = false;
    }

    @Override
    public String toString() {
        return live
                ? DotView.LIVE.getView()
                : DotView.DEAD.getView();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return Objects.equals(x, dot.x) && Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Dot clone() {
        try {
            return (Dot) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
