package clinicmanagement.controller.employeemanagement;

import clinicmanagement.constant.admin.EmployeeManagementName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultEmployeeManagementSearchBarKeyPress extends KeyAdapter implements EmployeeManagementSearchBarKeyPress {
    @Inject @Named(EmployeeManagementName.EMPLOYEE_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowEmployeeWorker> showEmployeeWorkerProvider;
    @Inject
    private EmployeeService employeeService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).equals("")) {
            showEmployeeWorkerProvider.get().refreshTable(employeeService.getListEmployee());
        }
    }
}
