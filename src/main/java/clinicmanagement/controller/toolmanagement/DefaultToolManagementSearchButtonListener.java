package clinicmanagement.controller.toolmanagement;

import clinicmanagement.constant.admin.ToolManagementName;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.entity.Tool;
import clinicmanagement.model.service.ToolService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultToolManagementSearchButtonListener implements ToolManagementSearchButtonListener {
    @Inject @Named(ToolManagementName.TOOL_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private ToolService toolService;
    @Inject
    private Provider<ShowToolWorker> showToolWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String tool_name = DocumentUtil.getText(searchInput);
        ArrayList<Tool> listTool = toolService.getListTool();
        ArrayList<Tool> listToolFilter = new ArrayList<>();
        for (Tool tool : listTool) {
            if (tool.getName().toLowerCase().contains(tool_name.toLowerCase().trim())) {
                listToolFilter.add(tool);
            }
        }
        showToolWorkerProvider.get().refreshTable(listToolFilter);
    }
}
