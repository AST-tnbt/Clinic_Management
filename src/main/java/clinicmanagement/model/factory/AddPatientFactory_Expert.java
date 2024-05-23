/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.AddPatientName;
import clinicmanagement.constant.AddPatientName_Expert;
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
public class AddPatientFactory_Expert extends AbstractModule {
    @Provides
    @Singleton
    @Named(AddPatientName_Expert.P_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddPatientName_Expert.P_DAYOFBIRTH)
    static Document provideDayOfBirthModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddPatientName_Expert.P_PHONENUMBER)
    static Document providePhoneNumberModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddPatientName_Expert.P_ADDRESS)
    static Document provideAddressModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddPatientName_Expert.P_SEX)
    static ComboBoxModel provideSexModel() {
        return new DefaultComboBoxModel(List.of("Nam", "Nữ").toArray());
    }
}
