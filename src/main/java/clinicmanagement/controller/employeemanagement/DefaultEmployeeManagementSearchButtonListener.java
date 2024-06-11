package clinicmanagement.controller.employeemanagement;

import clinicmanagement.constant.admin.EmployeeManagementName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultEmployeeManagementSearchButtonListener implements EmployeeManagementSearchButtonListener {
    @Inject @Named(EmployeeManagementName.EMPLOYEE_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private EmployeeService employeeService;
    @Inject
    private Provider<ShowEmployeeWorker> showEmployeeWorkerProvider;

    @Override
    public void actionPerformed(ActionEvent e) {
        String emp_name = DocumentUtil.getText(searchInput);
        ArrayList<Employee> listEmp = employeeService.getListEmployee();
        ArrayList<Employee> listEmpFilter = new ArrayList<>();
        for (Employee emp : listEmp) {
            if (emp.getName().toLowerCase().trim().contains(emp_name.toLowerCase().trim())) {
                listEmpFilter.add(emp);
            }
        }
        showEmployeeWorkerProvider.get().refreshTable(listEmpFilter);
    }
}
