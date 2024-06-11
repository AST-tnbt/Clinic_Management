package clinicmanagement.controller.toolmanagement;

import clinicmanagement.constant.admin.ModifyToolName;
import clinicmanagement.constant.admin.ToolManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.util.DocumentUtil;
import clinicmanagement.view.manager.ModifyTool_Admin;
import com.google.inject.Inject;
import jakarta.inject.Named;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultToolManagementModifyButtonListener extends MouseAdapter implements ToolManagementModifyButtonListener {
    @Inject
    ModifyTool_Admin modifyToolAdmin;
    @Inject @Named(ToolManagementName.TOOL_TABLE)
    TableModelWrapper tableModelWrapper;
    @Inject @Named(ToolManagementName.TOOL_TABLE_LIST_SELECTION)
    TableListModelSelectionWrapper tableListModelSelectionWrapper;
    @Inject @Named(ModifyToolName.T_NAME)
    private Document t_name;
    @Inject @Named(ModifyToolName.T_ID)
    private Document t_id;
    @Inject @Named(ModifyToolName.T_ROOM)
    private Document t_room;
    @Inject @Named(ModifyToolName.T_IMPORTDATE)
    private Document t_importDate;
    @Inject @Named(ModifyToolName.T_EXPIREDATE)
    private Document t_expireDate;
    @Inject @Named(ModifyToolName.T_STATUS)
    private ComboBoxModel t_status;

    @Override
    public void mouseClicked(MouseEvent e) {
        int []rows = tableListModelSelectionWrapper.getSelectionModel().getSelectedIndices();
        if (rows.length == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dụng cụ để chỉnh sửa.");
        }
        else if (rows.length >1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dụng cụ.");
        }
        else {
            modifyToolAdmin.setVisible(true);
            try {
                DocumentUtil.removeText(this.t_id);
                DocumentUtil.removeText(this.t_name);
                DocumentUtil.removeText(this.t_importDate);
                DocumentUtil.removeText(this.t_expireDate);
                DocumentUtil.removeText(this.t_room);

                this.t_id.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 0), null);
                this.t_name.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 1), null);
                this.t_importDate.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 2), null);
                this.t_expireDate.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 3), null);
                this.t_room.insertString(0, (String) tableModelWrapper.getModel().getValueAt(rows[0], 5), null);
                this.t_status.setSelectedItem((String) tableModelWrapper.getModel().getValueAt(rows[0], 4));
                } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
