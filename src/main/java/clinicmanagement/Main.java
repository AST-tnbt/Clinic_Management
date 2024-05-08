/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement;

import clinicmanagement.model.factory.AddEmployeeFactory;
import clinicmanagement.model.factory.EmployeeManagementFactory;
import clinicmanagement.model.factory.EntityModelFactory;
import clinicmanagement.model.factory.LoginModelFactory;
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
            new EntityModelFactory()
        );
        java.awt.EventQueue.invokeLater(() -> injector.getInstance(Login.class).setVisible(true));
    }
}
