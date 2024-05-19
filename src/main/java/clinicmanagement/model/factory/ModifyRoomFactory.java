/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.AddRoomName;
import clinicmanagement.constant.ModifyRoomName;
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
public class ModifyRoomFactory extends AbstractModule {
    @Provides
    @Singleton
    @Named(ModifyRoomName.R_NAME)
    static Document provideNameModel() {
        return new PlainDocument();
    }
    @Provides
    @Singleton
    @Named(ModifyRoomName.R_CAPACITY)
    static Document provideCapacityModel() {return new PlainDocument();}
    @Provides
    @Singleton
    @Named(ModifyRoomName.R_ID)
    static Document provideIDModel() {return new PlainDocument();}
}
