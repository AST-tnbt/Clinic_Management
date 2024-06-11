/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.feemanagement;

import clinicmanagement.constant.admin.EmployeeManagementName;
import clinicmanagement.controller.feemanagement.worker.ShowFeeWorker;
import clinicmanagement.model.base.TableModelWrapper;
import clinicmanagement.model.service.InvoiceService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


/**
 *
 * @author tin-ast
 */
public class DefaultFeeManagementShowFee extends ComponentAdapter implements FeeManagementShowFee {
    @Inject private Provider<ShowFeeWorker> showEmployeeWorkerProvider;

    @Inject @Named(EmployeeManagementName.EMPLOYEE_TABLE)
    private TableModelWrapper tableModelWrapper;

    @Inject
    InvoiceService invoiceService;

    @Override
    public void componentShown(ComponentEvent e) {
        showEmployeeWorkerProvider.get().refreshTable(invoiceService.getListInvoice());
    }
}
