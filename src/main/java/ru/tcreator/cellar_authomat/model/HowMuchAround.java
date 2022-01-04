package ru.tcreator.cellar_authomat.model;
import org.springframework.stereotype.Component;

/**
 * How many points might be around of a living or lives dots
 */
@Component
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
