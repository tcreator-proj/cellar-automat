package ru.tcreator.cellar_authomat.utills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * How many points might be around of a living or lives dots
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum HowMuchAround {
    ONE(1),
    TWO(2),
    TREE(3),
    FOUR(4);

    private Integer count;
}
