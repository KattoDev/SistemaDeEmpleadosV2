package com.SistemaDeEmpleados.Controllers;

import java.awt.Color;

/**
 * Controller for app colors.
 * DEPENDENCY {@link https://github.com/KattoDev/Project-handler} library
 * 
 * @version 2.0.0
 * @author Kris
 */
public class AppColors {

  /**
   * @return the color for the background COSMIC_LATE
   */
  public static Color Background() {
    return ColorScheme.SetColor.COSMIC_LATE;
  }

  /**
   * @return the color for the hero background EGGSHELL
   */
  public static Color Hero() {
    return ColorScheme.SetColor.EGGSHELL;
  }

  /**
   * @return the color for the buttons DESERT_SAND
   */
  public static Color Button() {
    return ColorScheme.SetColor.DESERT_SAND;
  }

  /**
   * @return the color used for text UMBER
   */
  public static Color Text() {
    return ColorScheme.SetColor.UMBER;
  }

  /**
   * @return the color used for the close button in the layout COPPER_RED
   */
  public static Color CloseButton() {
    return ColorScheme.SetColor.COPPER_RED;
  }

  /**
   * @return the color used when the user hovers the mouse on the close button CHESTNUT
   */
  public static Color CloseButtonHover() {
    return ColorScheme.SetColor.CHESTNUT;
  }
}