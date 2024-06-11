package clinicmanagement.controller.toolmanagement;

import clinicmanagement.constant.admin.ToolManagementName;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.service.ToolService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultToolManagementSearchBarKeyPress extends KeyAdapter implements ToolManagementSearchBarKeyPress {
    @Inject @Named(ToolManagementName.TOOL_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowToolWorker> showToolWorkerProvider;
    @Inject
    private ToolService toolService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).isEmpty()) {
            showToolWorkerProvider.get().refreshTable(toolService.getListTool());
        }
    }
}
