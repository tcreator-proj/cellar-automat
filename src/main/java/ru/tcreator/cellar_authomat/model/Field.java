package ru.tcreator.cellar_authomat.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;
import ru.tcreator.cellar_authomat.service.FieldRunner;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Field {

    protected CopyOnWriteArrayList<CopyOnWriteArrayList> field;

    /**
     * Если поле полностью заполнено или является пустым
     * @return Boolean
     */
    public boolean isHopeless() {
        int overflow = 0;
        int size = this.field.size();
        for (CopyOnWriteArrayList copyOnWriteArrayList : this.field) {
            for (int j = 0; j < size; j++) {
                Dot dot = (Dot) copyOnWriteArrayList.get(j);
                if (dot.getLive()) {
                    overflow++;
                }
            }
        }
        return overflow == 0 || overflow == size;
    }

    public FieldRunner getRunner() {
        return new FieldRunner(this.field);
    }
}
