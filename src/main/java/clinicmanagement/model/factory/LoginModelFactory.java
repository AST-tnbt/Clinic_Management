/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.model.factory;

import clinicmanagement.constant.LoginName;
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
public class LoginModelFactory extends AbstractModule {    
    @Provides
    @Singleton
    @Named(LoginName.USERNAME)
    static Document provideUsernameModel() {
        return new PlainDocument();
    }
    
    @Provides
    @Singleton
    @Named(LoginName.PASSWORD)
    static Document providePasswordModel() {
        return new PlainDocument();
    }
}
