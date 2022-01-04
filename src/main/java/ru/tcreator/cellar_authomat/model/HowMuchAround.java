package ru.tcreator.cellar_authomat.model;

import lombok.Getter;

/**
 * How much people might be around of a living dots
 */

@Getter
public enum HowMuchAround {
    ONE(1),
    TWO(2),
    TREE(3),
    FOUR(4);

    private final Integer count;


    HowMuchAround(int i) {
        this.count = i;
    }

    public Integer getCount() {
        return count;
    }
}
