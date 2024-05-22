/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.AddToolName;
import clinicmanagement.constant.ModifyRoomName;
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
public class ModifyToolFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(ModifyToolName.T_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyToolName.T_IMPORTDATE)
    static Document provideImportDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyToolName.T_EXPIREDATE)
    static Document provideExportDateModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyToolName.T_ROOM)
    static Document provideRoomModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyToolName.T_ID)
    static Document provideIdModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyToolName.T_STATUS)
    static ComboBoxModel provideStatusModel() {return new DefaultComboBoxModel(List.of("Tốt", "Hư hỏng", "Đang bảo trì").toArray());}
}
