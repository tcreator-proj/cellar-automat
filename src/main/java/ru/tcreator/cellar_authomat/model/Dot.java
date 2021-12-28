package ru.tcreator.cellar_authomat.model;

import ru.tcreator.cellar_authomat.utills.FieldUtils;

public class Dot implements AroundChecking, Runnable {
    private final Integer x;
    private final Integer y;
    private Boolean live = false;
    protected Field field;

    public Dot(Integer x, Integer y, Boolean live,  Field field) {
        this.x = x;
        this.y = y;
        this.live = live;
        this.field = field;
    }

    @Override
    public void run() {
        int count = 20;
        final int STEP = 1000;
        while (count-- > 0) {
            try {
                this.isAloneAround();
                Thread.sleep(STEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Точка " + this.x + "-" + this.y + "остановлена");
    }

    public void isAloneAround() {
        final var HOW_MUCH_AROUND = HowMuchAround.TREE;
        var field = this.field.getField();
        var howManyTimes = 3; // куб обхода 3 * 3
        var x = this.x;
        var y = this.y;
        // количество найденных, живых, клеток
        int foundedNeighbors = 0;
        for (int i = x - 1; i < howManyTimes; i++) {
            for (int j = y - 1; j < howManyTimes; j++) {
                // если координата обхода уходит за поле, просто игнорируем его
                if(i >= 0 && j >= 0) {
                    //точка
                    var thatDot = (Dot) field.get(i).get(j);
                    // если точка жива
                    if(thatDot.getLive()) {
                        // Если точка не равна текущей
                        if (i != thatDot.getX() && j != thatDot.getY()) {
                            foundedNeighbors++;
                        }
                    }
                }
            }
            if(foundedNeighbors == HowMuchAround.FOUR.getCount()) {
                this.alive();
                break;
            }
        }
        if (foundedNeighbors == 0) {
            this.die();
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


}
