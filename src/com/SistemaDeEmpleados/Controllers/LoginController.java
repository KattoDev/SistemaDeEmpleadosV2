package com.SistemaDeEmpleados.Controllers;

import DEBUGING.Debug;
import com.SistemaDeEmpleados.Models.User;
import com.SistemaDeEmpleados.Models.ActualSession;
import com.SistemaDeEmpleados.Views.DashboardView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author katto
 */
public class LoginController {

    public LoginController(
            JFrame loginFrame,
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
                    new DashboardView().setVisible(true);
                    loginFrame.dispose();
                    new Debug("LOGIN AUTORIZADO");
                    new Debug(ActualSession.getInstance().getUser().toString());
                }
            }
        });

    }
}
