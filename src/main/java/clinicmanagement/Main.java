/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement;

import clinicmanagement.model.factory.*;
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
            new MedicalRecordFactory(),
            new AppointmentManagementFactory(),
            new RoomManagementFactory(),
            new AddRoomFactory(),
            new ModifyRoomFactory()
        );
        java.awt.EventQueue.invokeLater(() -> injector.getInstance(Login.class).setVisible(true));
    }
}
