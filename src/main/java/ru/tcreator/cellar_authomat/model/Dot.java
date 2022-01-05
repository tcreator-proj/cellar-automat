package ru.tcreator.cellar_authomat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.utills.DotView;

import java.util.Objects;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dot implements Cell, Cloneable {
    private Integer x;
    private Integer y;
    private Boolean live;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return Objects.equals(x, dot.x) && Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Dot clone() {
        try {
            return (Dot) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
