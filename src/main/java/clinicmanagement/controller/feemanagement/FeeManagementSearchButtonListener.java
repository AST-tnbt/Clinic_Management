package clinicmanagement.controller.feemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

@ImplementedBy(DefaultFeeManagementSearchButtonListener.class)
public interface FeeManagementSearchButtonListener extends ActionListener {}
