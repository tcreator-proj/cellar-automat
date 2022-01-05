package ru.tcreator.cellar_authomat.utills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum DotView {
    DEAD(" "),
    LIVE("X");

    private String view;
}
