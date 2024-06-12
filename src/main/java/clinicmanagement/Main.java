/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement;

import clinicmanagement.constant.expert.ExpertAddMedicineName;
import clinicmanagement.model.factory.*;
import clinicmanagement.model.factory.admin.*;
import clinicmanagement.model.factory.expert.*;
import clinicmanagement.view.Login;
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
            new MedicalRecordManagementFactory(),
            new AddMedicalRecordFactory(),
            new ExpertMedicineManagementFactory(),
            new ExpertAddMedicineFactory(),
            new ExpertModifyMedicineFactory(),
            new ExpertPatientManagementFactory(),
            new ExpertAddPatientFactory(),
            new ExpertModifyPatientFactory()
        );
        java.awt.EventQueue.invokeLater(() -> injector.getInstance(Login.class).setVisible(true));
    }
}
