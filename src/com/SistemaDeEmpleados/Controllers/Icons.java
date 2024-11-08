package com.SistemaDeEmpleados.Controllers;

import javax.swing.*;
import DEBUGING.Debug;
import com.SistemaDeEmpleados.Views.DashboardView;
import com.SistemaDeEmpleados.Views.LoginView;

/**
 * @author katto
 */
public class Icons {

    /**
     * Sets the icons for {@link LoginView}
     *
     * @param labels array of the icons JLabels of the login
     * @throws IllegalArgumentException when the array doesn't contain 3
     * elements
     */
    public void setLoginIcons(JLabel[] labels) throws IllegalArgumentException {

        if (labels.length != 3) {
            throw new IllegalArgumentException(
                    "The array must have three elements");
        }

        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[0],
                "src/com/SistemaDeEmpleados/Assets/Icons/user.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[1],
                "src/com/SistemaDeEmpleados/Assets/Icons/lock.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[2],
                "src/com/SistemaDeEmpleados/Assets/Images/citybg.png");
        new Debug("iconos del login aplicados");
    }

    /**
     * Sets the icons for {@link DashboardView}
     * @param labels array of the icons JLabels of the DashboardView
     * @throws IllegalArgumentException when the array doesn't contain 7
     * elements
     */
    public void setDashboardIcons(JLabel[] labels) throws IllegalArgumentException {
        
        if(labels.length != 7){
            throw new IllegalArgumentException(
                    "the array must have seven elements");
        }
        
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[0],
                "src/com/SistemaDeEmpleados/Assets/Icons/admin.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[1],
                "src/com/SistemaDeEmpleados/Assets/Icons/admin.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[2],
                "src/com/SistemaDeEmpleados/Assets/Icons/employees.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[3],
                "src/com/SistemaDeEmpleados/Assets/Icons/depts.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[4],
                "src/com/SistemaDeEmpleados/Assets/Icons/reports.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[5],
                "src/com/SistemaDeEmpleados/Assets/Icons/projects.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(
                labels[6],
                "src/com/SistemaDeEmpleados/Assets/Icons/profile.png");
        new Debug("Iconos del dashboard aplicados");
    }
}
