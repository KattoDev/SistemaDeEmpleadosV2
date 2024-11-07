package com.SistemaDeEmpleados.Controllers;

import com.SistemaDeEmpleados.Models.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author katto
 */
public class LoginController {

    public LoginController(
            JTextField emailField,
            JTextField passwordField,
            JPanel loginButton) {
        
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                User credentials = new User();

                credentials.setEmail(emailField.getText());
                credentials.setPassword(passwordField.getText());
                
                if(!credentials.authUser()){
                    System.err.println("DEBUG: NO AUTORIZADO");
                }
                else {
                    System.err.println("DEBUG: AUTORIZADO");
                    System.err.println(credentials.toString());
                }
            }
        });

    }
}
