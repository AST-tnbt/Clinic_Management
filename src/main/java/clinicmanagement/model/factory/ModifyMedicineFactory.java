/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.AddMedicineName;
import clinicmanagement.constant.ModifyMedicineName;
import clinicmanagement.constant.ModifyToolName;
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
public class ModifyMedicineFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(ModifyMedicineName.MEDICINE_ID)
    static Document provideIdModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyMedicineName.MEDICINE_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyMedicineName.MEDICINE_IMPORTDATE)
    static Document provideImportDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyMedicineName.MEDICINE_EXPIREDATE)
    static Document provideExportDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyMedicineName.MEDICINE_PRICE)
    static Document provideRoomModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyMedicineName.MEDICINE_QUANTITY)
    static Document provideStatusModel() {return new PlainDocument();}
}
