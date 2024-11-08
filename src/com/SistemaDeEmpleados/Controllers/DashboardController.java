package com.SistemaDeEmpleados.Controllers;

import DEBUGING.Debug;
import com.SistemaDeEmpleados.Models.ActualSession;
import com.SistemaDeEmpleados.Views.EmployeeSearchModule;
import com.SistemaDeEmpleados.Views.EmployeeProfileModule;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author katto
 */
public class DashboardController {

    private final ModuleController moduleController = new ModuleController();

    /**
     * Show the buttons if the user logged is admin
     *
     * @param employees
     * @param departments
     * @param employeeSearch
     * @param employeeRegistration
     */
    public void showButtons(JPanel employees,
            JPanel departments, JPanel employeeSearch,
            JPanel employeeRegistration,
            JPanel moduleContainer) {

        if (ActualSession.getInstance().getUser().getAdmin() == false) {
            
            // hide the admin buttons
            employees.setVisible(false);
            departments.setVisible(false);
            employeeSearch.setVisible(false);
            employeeRegistration.setVisible(false);
            
            // redirect to profile
            new ModuleController().insertModule(
                    moduleContainer,
                    new EmployeeProfileModule());
        } else {
            // TODO 
//            ContentHandle.Panel.Show(displaycontent, CM_Views.EmployeesModule.FindEmployee(), contentWidth,
//                    contentHeight);
            employees.setVisible(true);
            departments.setVisible(true);
        }
    }

    /**
     * Handles the click events of the dashboard buttons
     *
     * @param employeesbtn
     * @param employeeSearchModulebtn
     * @param employeeRegistrationModulebtn
     * @param departmentsbtn
     * @param reportsbtn
     * @param projectsbtn
     * @param moduleContainer
     * @param logoutbtn
     * @param profilebtn
     */
    public void buttonsEventListener(
            JPanel employeesbtn,
            JPanel employeeSearchModulebtn,
            JPanel employeeRegistrationModulebtn,
            JPanel departmentsbtn,
            JPanel reportsbtn,
            JPanel projectsbtn,
            JPanel profilebtn,
            JPanel logoutbtn,
            JPanel moduleContainer
    ) {

        /**
         * ---------------------------------------------------------------------
         * employees module
         * ---------------------------------------------------------------------
         */
        employeesbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                new Debug("clicked");
                // TODO Handle the employees submodule
                moduleController.insertModule(
                        moduleContainer,
                        new EmployeeSearchModule());
                employeeRegistrationModulebtn.setVisible(true);
                employeeSearchModulebtn.setVisible(true);
            }
        });

        employeeSearchModulebtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // TODO handle the employeeSearch submodule
                // ContentHandle.Panel.Show(displaycontent, CM_Views.EmployeesModule.FindEmployee(), contentWidth,
                // contentHeight);
            }
        });

        employeeRegistrationModulebtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // TODO handle the employee registration submodule
//                ContentHandle.Panel.Show(displaycontent, CM_Views.EmployeesModule.EmployeeRegister(), contentWidth,
//                        contentHeight);
            }
        });

        /**
         * ---------------------------------------------------------------------
         * departments module
         * ---------------------------------------------------------------------
         */
        departmentsbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // TODO handle the department submodule
//                ContentHandle.Panel.Show(displaycontent, CM_Views.DepartmentsModule.Departaments(), contentWidth,
//                        contentHeight);
            }
        });

        /**
         * ---------------------------------------------------------------------
         * reports module
         * ---------------------------------------------------------------------
         */
        reportsbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // TODO
                // ContentHandle.Panel.Show(displaycontent, CM_Views.ReportModule.GeneralReports(), contentWidth,
                //        contentHeight);
            }
        });

        /**
         * ---------------------------------------------------------------------
         * projects module
         * ---------------------------------------------------------------------
         */
        projectsbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // TODO
//                ContentHandle.Panel.Show(displaycontent, CM_Views.ProjectsModule.Projects(), contentWidth,
//                contentHeight);
            }
        });

        /**
         * ---------------------------------------------------------------------
         * profile module
         * ---------------------------------------------------------------------
         */
        profilebtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                new ModuleController().insertModule(
                        moduleContainer,
                        new EmployeeProfileModule());
            }
        });

        /**
         * ---------------------------------------------------------------------
         * logout button
         * ---------------------------------------------------------------------
         */
        logoutbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {

                String[] messageOptions = {
                    "Terminar turno", "Cerrar sesión", "Cancelar"};

                int option = JOptionPane.showOptionDialog(null,
                        "¿Desea cerrar sesión y terminar el turno o solo cerrar sesión?", "Aviso",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, messageOptions,
                        messageOptions[1]);

                switch (option) {
                    case 0 -> {
                        /**
                         * TODO adjust checkout hour [CLASS Assistance] new
                         * Assistance().updateCheckout(Login.dbc.connection,
                         * Login.actualSession);
                         */
                        if (ActualSession.getInstance().getUser().logOut()) {
                            System.exit(0);
                            new Debug("Se cerró sesión y "
                                    + "se actualizó la hora de salida");
                        }
                    }
                    case 1 -> {
                        if (ActualSession.getInstance().getUser().logOut()) {
                            System.exit(0);
                            
                        }
                    }
                }
            }
        });
    }

    // boton cerrar sesion
//    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
//        JOptionPane.showMessageDialog(this, "Para salir de la aplicación primero debe cerrar sesión",
//                "Atención", JOptionPane.INFORMATION_MESSAGE);
//    }// GEN-LAST:event_jLabel1MouseClicked
//
//    // boton cerrar app
//    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseEntered
//        btn_close.setBackground(CM_Color.CloseButtonHover());
//    }// GEN-LAST:event_jLabel1MouseEntered
//
//    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseExited
//        btn_close.setBackground(CM_Color.CloseButton());
//    }// GEN-LAST:event_jLabel1MouseExited
}
