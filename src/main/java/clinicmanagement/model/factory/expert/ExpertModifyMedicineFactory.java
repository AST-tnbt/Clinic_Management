/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory.expert;

import clinicmanagement.constant.admin.ModifyMedicineName;
import clinicmanagement.constant.expert.ExpertModifyMedicineName;
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
public class ExpertModifyMedicineFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(ExpertModifyMedicineName.MEDICINE_ID)
    static Document provideIdModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ExpertModifyMedicineName.MEDICINE_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ExpertModifyMedicineName.MEDICINE_IMPORTDATE)
    static Document provideImportDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ExpertModifyMedicineName.MEDICINE_EXPIREDATE)
    static Document provideExportDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ExpertModifyMedicineName.MEDICINE_PRICE)
    static Document provideRoomModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ExpertModifyMedicineName.MEDICINE_QUANTITY)
    static Document provideStatusModel() {return new PlainDocument();}
}
