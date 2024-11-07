package com.SistemaDeEmpleados.Controllers;

import com.SistemaDeEmpleados.Models.ActualSession;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author katto
 */
public class WindowPositionController {

    /**
     * the mouse x Position on screen
     */
    private int xMouse;

    /**
     * the mouse x Position on screen
     */
    private int yMouse;

    /**
     * the target window
     */
    private JFrame window = null;
    
    /**
     * Handles the events of window position via mouse
     *
     * @param window the target window
     * @param windowBar the window's control bar
     * @param btn_close the button close of the windowBars
     * @throws IllegalArgumentException when the given window or window bar is
     * null
     */
    public WindowPositionController(JFrame window, JPanel windowBar, JPanel btn_close) throws IllegalArgumentException {
        if (window == null || windowBar == null || btn_close == null) {
            throw new IllegalArgumentException("Window, windowBar, btn_close cannot be null");
        }

        this.window = window;
        init(windowBar);
        
        btn_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                ActualSession.getInstance().destroyInstance();
                System.exit(0);
            }
        });

        btn_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                btn_close.setBackground(AppColors.CloseButtonHover());
            }
        });

        btn_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                btn_close.setBackground(AppColors.CloseButton());
            }
        });
    }

    /**
     * Init the events of {@link WindowPositionController}
     *
     * @param windowBar the window's control bar
     */
    private void init(JPanel windowBar) {
        windowBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        windowBar.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
    }

    /**
     * Controls the position of the windowBar
     *
     * @param evt the event generated via Mouse Event
     */
    private void headerMouseDragged(MouseEvent evt) {
        int positionX = evt.getXOnScreen();
        int positionY = evt.getYOnScreen();

        window.setLocation(
                positionX - xMouse,
                positionY - yMouse);
    }

    /**
     * controls the position of the mouse
     *
     * @param evt the event generated via MouseEvent
     */
    private void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
}
