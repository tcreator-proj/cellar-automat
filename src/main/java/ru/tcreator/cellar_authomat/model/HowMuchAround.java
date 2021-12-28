package ru.tcreator.cellar_authomat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * How much people might be around of a living dots
 */

@Getter
public enum HowMuchAround {
    TREE(3),
    FOUR(4);

    private final Integer people;


    HowMuchAround(int i) {
        this.people = i;
    }
}
