package com.SistemaDeEmpleados.Controllers;

import DEBUGING.Debug;
import com.SistemaDeEmpleados.Models.User;
import com.SistemaDeEmpleados.Models.ActualSession;
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
                User credentials = new User(
                        emailField.getText(), passwordField.getText());

                if (!credentials.authUser()) {
                    new Debug("LOGIN NO AUTORIZADO");
                } else {
                    new Debug("LOGIN AUTORIZADO");
                    new Debug(ActualSession.getInstance().getUser().toString());
                }
            }
        });

    }
}
