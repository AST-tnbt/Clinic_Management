package clinicmanagement.model.base;
import javax.swing.table.TableModel;

public class TableModelWrapper {
    private TableModel tableModel = null;
    public void setModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }
    public TableModel getModel() {
        if (tableModel == null) {
            throw new RuntimeException("Model is used before initialization");
        }
        return this.tableModel;
    }
}
