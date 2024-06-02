/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.AddMedicalRecordName;
import clinicmanagement.constant.ModifyMedicalRecordName;
import clinicmanagement.model.service.MedicineService;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
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
public class AddMedicalRecordFactory extends AbstractModule {
    @Inject
    private static MedicineService medicineService;
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_DATEOFBIRTH)
    static Document provideDateOfBirthModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_SEX)
    static ComboBoxModel provideSexModel() {
        return new DefaultComboBoxModel(List.of("Nam", "Nữ").toArray());
    }
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_STATUS)
    static ComboBoxModel provideStatusModel() {
        return new DefaultComboBoxModel(List.of("Đang điều trị", "Nhập viện", "Đã xuất viện").toArray());
    }
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_DIAGNOSIS)
    static Document provideDiagnosisModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_APPOINTMENTDATE)
    static Document provideAppointmentDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_ROOM)
    static Document provideRoomModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_AMOUNT)
    static Document provideAmountModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_PRESCRIPTION)
    static Document providePrescriptionModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_PRESCRIPTION_PREVIEW)
    static Document providePreviewPrescriptionModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_ID)
    static Document provideId() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(AddMedicalRecordName.P_MEDICINELIST)
    static ComboBoxModel provideMedicineListModel() {
        return new DefaultComboBoxModel();
    }
}
