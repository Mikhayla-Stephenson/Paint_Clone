package vector;

import java.awt.*;

class Util {
    static String getColorRGB(Color color) {
        return  String.format( "#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue()).toUpperCase();
    }
}
