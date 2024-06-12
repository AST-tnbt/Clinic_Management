/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory.expert;

import clinicmanagement.constant.admin.AddPatientName;
import clinicmanagement.constant.expert.ExpertAddPatientName;
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
public class ExpertAddPatientFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(ExpertAddPatientName.P_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ExpertAddPatientName.P_DAYOFBIRTH)
    static Document provideDayOfBirthModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ExpertAddPatientName.P_PHONENUMBER)
    static Document providePhoneNumberModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ExpertAddPatientName.P_ADDRESS)
    static Document provideAddressModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ExpertAddPatientName.P_SEX)
    static ComboBoxModel provideSexModel() {
        return new DefaultComboBoxModel(List.of("Nam", "Nữ").toArray());
    }
}
