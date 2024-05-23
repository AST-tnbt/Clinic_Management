/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement;

import clinicmanagement.model.factory.*;
import clinicmanagement.view.Login;
import clinicmanagement.view.expert.AddPatient_Expert;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author tin-ast
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
            new LoginModelFactory(),
            new AddEmployeeFactory(),
            new EmployeeManagementFactory(),
            new EntityModelFactory(),
            new ModifyEmployeeFactory(),
            new PatientManagementFactory(),
            new MedicalRecordFactory(),
            new RoomManagementFactory(),
            new AddRoomFactory(),
            new ModifyRoomFactory(),
            new AddPatientFactory(),
            new ModifyPatientFactory(),
            new ModifyMedicalRecordFactory(),
            new ToolManagementFactory(),
            new AddToolFactory(),
            new ModifyToolFactory(),
            new MedicineManagementFactory(),
            new AddMedicineFactory(),
            new ModifyMedicineFactory(),
            new FeeManagementFactory(),
            new PatientManagementFactory_Expert(),
            new AddPatientFactory_Expert(),
            new ModifyPatientFactory_Expert(),
            new MedicineManagementFactory_Expert(),
            new AddMedicineFactory_Expert(),
            new ModifyMedicineFactory_Expert()
        );
        java.awt.EventQueue.invokeLater(() -> injector.getInstance(Login.class).setVisible(true));
    }
}
