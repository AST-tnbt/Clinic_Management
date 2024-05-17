package clinicmanagement.model.factory;

import clinicmanagement.constant.EntityName;
import clinicmanagement.model.entity.*;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.util.ArrayList;

public class EntityModelFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(EntityName.EMPLOYEE_MODEL)
    public static ArrayList<Employee> ProvideEmployee() {
        return new ArrayList<Employee>();
    }
    @Provides
    @Singleton
    @Named(EntityName.PATIENT_MODEL)
    public static ArrayList<Patient> ProvidePatient() {
        return new ArrayList<Patient>();
    }
    @Provides
    @Singleton
    @Named(EntityName.MEDICAL_RECORD)
    public static ArrayList<MedicalRecord> ProvideMedicalRecord() {
        return new ArrayList<MedicalRecord>();
    }
    @Provides
    @Singleton
    @Named(EntityName.PRESCRIPTION)
    public static ArrayList<Prescription> ProvidePrescription() {
        return new ArrayList<Prescription>();
    }
    @Provides
    @Singleton
    @Named(EntityName.PRESCRIPTION_DETAIL)
    public static ArrayList<PrescriptionDetail> ProvidePrescriptionDetail() {
        return new ArrayList<PrescriptionDetail>();
    }
    @Provides
    @Singleton
    @Named(EntityName.MEDICINE)
    public static ArrayList<Medicine> ProvideMedicine() {
        return new ArrayList<Medicine>();
    }
}
