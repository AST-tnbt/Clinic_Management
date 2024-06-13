package clinicmanagement.controller.feemanagement.clerk;

import com.google.inject.ImplementedBy;

import java.awt.event.KeyListener;

@ImplementedBy(DefaultClerkFeeManagementSearchBarKeyPress.class)
public interface ClerkFeeManagementSearchBarKeyPress extends KeyListener {}
