package com.SistemaDeEmpleados.Controllers;

import com.SistemaDeEmpleados.Views.DashboardView;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * @author katto
 */
public class ModuleController {

    private int moduleWidth = 1080;
    private int moduleHeight = 640;

    /**
     * Handles the modules of the {@link DashboardView} DEFAULT SIZE: 1080x640
     *
     * @param moduleContainer the DashboardView module container
     * @param module the module inserted
     */
    public void insertModule(JPanel moduleContainer, JPanel module) {
        module.setSize(moduleWidth, moduleHeight);
        module.setLocation(0, 0);

        moduleContainer.removeAll();
        moduleContainer.add(module, BorderLayout.CENTER);
        moduleContainer.revalidate();
        moduleContainer.repaint();
    }

}
