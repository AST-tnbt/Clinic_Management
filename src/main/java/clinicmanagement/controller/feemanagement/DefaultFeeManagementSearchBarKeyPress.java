package clinicmanagement.controller.feemanagement;

import clinicmanagement.constant.admin.FeeManagementName;
import clinicmanagement.controller.feemanagement.worker.ShowFeeWorker;
import clinicmanagement.model.service.InvoiceService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultFeeManagementSearchBarKeyPress extends KeyAdapter implements FeeManagementSearchBarKeyPress {
    @Inject @Named(FeeManagementName.FEE_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ShowFeeWorker> showFeeWorkerProvider;
    @Inject
    private InvoiceService invoiceService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).equals("")) {
            showFeeWorkerProvider.get().refreshTable(invoiceService.getListInvoice());
        }
    }
}
