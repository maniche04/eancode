/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode.helpers;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author manish
 */
public class fontawesome {
    public Font getFont() {
        try (InputStream is = fontawesome.class.getResourceAsStream("/assets/fontawesome.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            return font.deriveFont(Font.PLAIN, 48f);
        } catch (IOException | FontFormatException exp) {
                    exp.printStackTrace();
        }
        
        return null;
    }
}
