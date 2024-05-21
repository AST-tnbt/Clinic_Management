/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.prescriptionmanagement;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;

/**
 *
 * @author tin-ast
 */
@ImplementedBy(DefaultPrescriptionSubmitListener.class)
public interface PrescriptionSubmitListener extends ActionListener{}
