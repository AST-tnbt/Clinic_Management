package clinicmanagement.controller.feemanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultFeeManagementSearchBarKeyPress.class)
public interface FeeManagementSearchBarKeyPress extends KeyListener {}
