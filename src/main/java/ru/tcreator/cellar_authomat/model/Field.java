package ru.tcreator.cellar_authomat.model;
import java.util.concurrent.CopyOnWriteArrayList;

public class Field implements AroundChecking {
    private CopyOnWriteArrayList<CopyOnWriteArrayList> field;

    public Field(CopyOnWriteArrayList<CopyOnWriteArrayList> field) {
        this.field = field;
    }

    public CopyOnWriteArrayList<CopyOnWriteArrayList> getField() {
        return this.field;
    }

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

    @Override
    public void isAloneAround(Field f) {
        int size = f.getField().size();
        var currentField = this.field;
        CopyOnWriteArrayList<CopyOnWriteArrayList> newField = new CopyOnWriteArrayList<>();
        for (int i = 0; i < size; i++) {
            newField.add(new CopyOnWriteArrayList());
            for (int j = 0; j < size; j++) {
                Dot dot = (Dot) currentField.get(i).get(j);
                dot.isAloneAround(f);
                newField.get(i).add(j, dot.clone());
            }
        }
        this.field = newField;
    }

    public FieldRunner getRunner() {
        return new FieldRunner(this.field);
    }
}
