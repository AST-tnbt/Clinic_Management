/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.toolmanagement;

import clinicmanagement.constant.ToolManagementName;
import clinicmanagement.controller.toolmanagement.worker.ShowToolWorker;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.ToolService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultToolManagementShowTool extends ComponentAdapter implements ToolManagementShowTool {
    @Inject
    private Provider<ShowToolWorker> showToolWorkerProvider;
    @Inject @Named(ToolManagementName.TOOL_TABLE)
    private TableModelWrapper tableModelWrapper;
    @Inject
    private ToolService toolService;

    @Override
    public void componentShown(ComponentEvent e) {
        showToolWorkerProvider.get().refreshTable(toolService.getListTool());
    }
}
