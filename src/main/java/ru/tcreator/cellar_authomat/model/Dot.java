package ru.tcreator.cellar_authomat.model;

public class Dot implements AroundChecking {
    private Integer x = 0;
    private Integer y = 0;
    private Boolean live = false;

    public Dot(Integer x, Integer y, Boolean live) {
        this.x = x;
        this.y = y;
        this.live = live;
    }


    /**
     *
     */
    public void isAloneAround() {
        final var HOW_MUCH_AROUND = HowMuchAround.TREE;

    }

    /**
     *
     */
    public void isAloneAround(HowMuchAround dots) {

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

    @Override
    public String toString() {
        return live
                ? DotView.LIVE.getView()
                : DotView.DEAD.getView();
    }
}
