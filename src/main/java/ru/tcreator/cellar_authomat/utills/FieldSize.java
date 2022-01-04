package ru.tcreator.cellar_authomat.utills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public enum FieldSize {
    TEST(3),
    XSMALL(10),
    SMALL(30),
    MEDIUM(40),
    LARGE(50),
    XLARGE(60);

    private final Integer size;


    FieldSize(int i) {
        this.size = i;
    }

    public Integer getSize() {
        return this.size;
    }
}
