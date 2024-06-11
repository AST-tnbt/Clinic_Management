/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory.admin;

import clinicmanagement.constant.admin.ModifyEmployeeName;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.util.List;

/**
 *
 * @author tin-ast
 */
public class ModifyEmployeeFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_ID)
    static Document provideIdModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_POSITION)
    static ComboBoxModel providePositionModel() {
        return new DefaultComboBoxModel(List.of("Quản lý", "Bác sĩ", "Nhân viên kế toán", "Chuyên viên").toArray());
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_SEX)
    static ComboBoxModel provideSexModel() {
        return new DefaultComboBoxModel(List.of("Nam", "Nữ").toArray());
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_DAYOFBIRTH)
    static Document provideDayOfBirthModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_PHONENUMBER)
    static Document providePhoneNumberModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_ADDRESS)
    static Document provideAddressModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_USERNAME)
    static Document provideUsernameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyEmployeeName.E_PASSWORD)
    static Document providePasswordModel() {
        return new PlainDocument();
    }
}
