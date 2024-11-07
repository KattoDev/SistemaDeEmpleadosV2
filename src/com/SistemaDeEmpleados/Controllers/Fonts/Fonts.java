package com.SistemaDeEmpleados.Controllers.Fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author alexi
 */
public class Fonts {

    private Font font;

    // font list
    final String LILITAONE = "LilitaOne-Regular.ttf";
    final String INTER = "Inter_24pt-Regular.ttf";

    /**
     * Creates a custom font
     *
     * @param fontName The font name | available fonts: LILITAONE, INTER
     * @param style sets the style between PLAIN, BOLD and ITALIC
     * @param fontSize The font size in pixels
     * @return The font created.
     */
    public Font CustomFont(String fontName, String style, float fontSize) {

        int fontStyle = switch (style.toLowerCase()) {
            case "bold" ->
                Font.BOLD;
            case "italic" ->
                Font.ITALIC;
            default ->
                Font.PLAIN;
        };

        String fontNameSelected = switch (fontName) {
            case "INTER" ->
                INTER;
            default ->
                LILITAONE;
        };

        try {
            // loads the font
            InputStream inputStream = getClass()
                    .getResourceAsStream(fontNameSelected);

            font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (FontFormatException ex) {
            System.err.println(fontName + " No es una fuente valida");
            font = new Font("Arial", Font.PLAIN, 14);
        } catch (IOException ioe) {
            System.err.println("Error al generar la tipografia\n"
                    + ioe.getMessage());
        }

        return font.deriveFont(fontStyle, fontSize);
    }
}
