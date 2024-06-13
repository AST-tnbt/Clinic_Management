package clinicmanagement.controller.feemanagement.clerk;

import clinicmanagement.constant.admin.FeeManagementName;
import clinicmanagement.constant.clerk.ClerkFeeManagementName;
import clinicmanagement.controller.feemanagement.clerk.worker.ClerkShowFeeWorker;
import clinicmanagement.model.service.InvoiceService;
import clinicmanagement.util.DocumentUtil;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DefaultClerkFeeManagementSearchBarKeyPress extends KeyAdapter implements ClerkFeeManagementSearchBarKeyPress {
    @Inject @Named(ClerkFeeManagementName.FEE_SEARCH_INPUT)
    private Document input;
    @Inject
    private Provider<ClerkShowFeeWorker> showFeeWorkerProvider;
    @Inject
    private InvoiceService invoiceService;
    @Override
    public void keyReleased(KeyEvent e) {
        if (DocumentUtil.getText(input).isEmpty()) {
            showFeeWorkerProvider.get().refreshTable(invoiceService.getListInvoice());
        }
    }
}
