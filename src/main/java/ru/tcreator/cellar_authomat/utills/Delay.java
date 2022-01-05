package ru.tcreator.cellar_authomat.utills;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Delay {
    GRAVE(2000),
    LARDO(1800),
    ADAGIO(1500),
    ANDANTE(1300),
    MODERATO(1000),
    ALEGRETTO(700),
    ALEGRO(500),
    PRESTO(200);

    private final int tempo;
}
