package ru.tcreator.cellar_authomat.utills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
public enum FieldSize {
    TEST(3),
    XSMALL(10),
    SMALL(30),
    MEDIUM(40),
    LARGE(50),
    XLARGE(60);

    private Integer size;

}
