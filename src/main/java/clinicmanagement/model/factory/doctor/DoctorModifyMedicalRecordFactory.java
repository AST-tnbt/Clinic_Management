/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory.doctor;

import clinicmanagement.constant.admin.ModifyMedicalRecordName;
import clinicmanagement.constant.doctor.DoctorModifyMedicalRecordName;
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
public class DoctorModifyMedicalRecordFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_ID)
    static Document provideIdModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_DATEOFBIRTH)
    static Document provideDateOfBirthModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_SEX)
    static ComboBoxModel provideSexModel() {
        return new DefaultComboBoxModel(List.of("Nam", "Nữ").toArray());
    }
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_STATUS)
    static ComboBoxModel provideStatusModel() {
        return new DefaultComboBoxModel(List.of("Đang điều trị", "Nhập viện", "Đã xuất viện").toArray());
    }
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_MEDICINELIST)
    static ComboBoxModel provideMedicineListModel() {
        return new DefaultComboBoxModel();
    }
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_DIAGNOSIS)
    static Document provideDiagnosisModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_APPOINTMENTDATE)
    static Document provideAppointmentDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_ROOM)
    static Document provideRoomModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_AMOUNT)
    static Document provideAmountModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_PRESCRIPTION)
    static Document providePrescriptionModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(DoctorModifyMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    static Document providePreviewPrescriptionModel() {return new PlainDocument();}
}
