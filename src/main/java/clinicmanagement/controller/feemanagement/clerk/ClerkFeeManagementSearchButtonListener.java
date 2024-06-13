package clinicmanagement.controller.feemanagement.clerk;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultClerkFeeManagementSearchButtonListener.class)
public interface ClerkFeeManagementSearchButtonListener extends ActionListener {}
