/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.controller.login;

import com.google.inject.ImplementedBy;

import java.awt.event.ActionListener;


@ImplementedBy(DefaultLoginListener.class)
public interface LoginListener extends ActionListener {}
