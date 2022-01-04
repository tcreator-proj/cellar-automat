package ru.tcreator.cellar_authomat.model;

import java.util.Objects;

public class Dot implements AroundChecking, Cloneable {
    private final Integer x;
    private final Integer y;
    private Boolean live;

    public Dot(Integer x, Integer y, Boolean live) {
        this.x = x;
        this.y = y;
        this.live = live;
    }

    @Override
    public void isAloneAround(Field f) {
        var field = f.getField();
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

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public Boolean getLive() {
        return this.live;
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
