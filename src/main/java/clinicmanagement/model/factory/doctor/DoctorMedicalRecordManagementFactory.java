/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory.doctor;

import clinicmanagement.constant.admin.MedicalRecordManagementName;
import clinicmanagement.constant.doctor.DoctorMedicalRecordManagementName;
import clinicmanagement.model.base.TableListModelSelectionWrapper;
import clinicmanagement.model.base.TableModelWrapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author tin-ast
 */
public class DoctorMedicalRecordManagementFactory extends AbstractModule{
    @Provides
    @Singleton
    @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE)
    private static TableModelWrapper provideTableModelWrapper() {
        return new TableModelWrapper();
    }

    @Provides
    @Singleton
    @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_TABLE_LIST_SELECTION)
    private static TableListModelSelectionWrapper provideListSelectionModelWrapper() {
        return new TableListModelSelectionWrapper();
    }

    @Provides
    @Singleton
    @Named(DoctorMedicalRecordManagementName.MEDICAL_RECORD_NAME)
    private static Document provideSearchInput() {
        return new PlainDocument();
    }
}
