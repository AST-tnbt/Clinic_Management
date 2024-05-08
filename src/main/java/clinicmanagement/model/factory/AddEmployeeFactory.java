/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.AddEmployeeName;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author tin-ast
 */
public class AddEmployeeFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_ID)
    static Document provideIdModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_POSITION)
    static ComboBoxModel providePositionModel() {
        return new DefaultComboBoxModel(List.of("Quản lý", "Bác sĩ", "Nhân viên kế toán", "Chuyên viên").toArray());
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_SEX)
    static ComboBoxModel provideSexModel() {
        return new DefaultComboBoxModel(List.of("Nam", "Nữ").toArray());
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_DAYOFBIRTH)
    static Document provideDayOfBirthModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_PHONENUMBER)
    static Document providePhoneNumberModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_ADDRESS)
    static Document provideAddressModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_USERNAME)
    static Document provideUsernameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddEmployeeName.E_PASSWORD)
    static Document providePasswordModel() {
        return new PlainDocument();
    }
}
