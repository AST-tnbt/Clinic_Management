package clinicmanagement.controller.feemanagement;

import clinicmanagement.constant.EmployeeManagementName;
import clinicmanagement.constant.FeeManagementName;
import clinicmanagement.controller.employeemanagement.worker.ShowEmployeeWorker;
import clinicmanagement.controller.feemanagement.worker.ShowFeeWorker;
import clinicmanagement.model.entity.Employee;
import clinicmanagement.model.entity.Invoice;
import clinicmanagement.model.service.EmployeeService;
import clinicmanagement.model.service.InvoiceService;
import clinicmanagement.model.service.PatientService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DefaultFeeManagementSearchButtonListener implements FeeManagementSearchButtonListener {
    @Inject @Named(FeeManagementName.FEE_SEARCH_INPUT)
    private Document searchInput;
    @Inject
    private InvoiceService invoiceService;
    @Inject
    private Provider<ShowFeeWorker> showFeeWorkerProvider;
    @Inject
    private PatientService patientService;
    @Override
    public void actionPerformed(ActionEvent e) {
        String emp_name = DocumentUtil.getText(searchInput);
        ArrayList<Invoice> listInvoice = invoiceService.getListInvoice();
        ArrayList<Invoice> listInvoiceFilter = new ArrayList<>();
        for (Invoice invoice : listInvoice) {
//            if (patientService.getNameById(invoice.getPatientId()).toLowerCase().contains(emp_name.toLowerCase().trim())) {
//                listInvoiceFilter.add(invoice);
//            }
        }
        showFeeWorkerProvider.get().refreshTable(listInvoiceFilter);
    }
}
