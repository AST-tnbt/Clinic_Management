package clinicmanagement.model.base;

import javax.swing.*;

public class TableListModelSelectionWrapper {
    private ListSelectionModel selectionModel;
    public void setSelectionModel(ListSelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
    public ListSelectionModel getSelectionModel() {
        if (selectionModel == null) {
            throw new RuntimeException("Model is used before initialization");
        }
        else {
            return this.selectionModel;
        }
    }
}
