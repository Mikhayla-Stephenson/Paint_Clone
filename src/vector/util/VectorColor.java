package vector.util;

import java.awt.Color;

public class VectorColor {
    private boolean active;
    private int rgb;

    public VectorColor(int rgb) {
        setRgb(rgb);
        active = true;
    }

    public VectorColor(int rgb, boolean active) {
        setRgb(rgb);
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getRGB() {
        return rgb;
    }

    public void setRgb(int rgb) {
        if (rgb < 0 || rgb > 0xffffff) {
            throw new IllegalArgumentException("Color rgb outside of valid range");
        }
        this.rgb = rgb;
    }

    public void setRgb(String rgb) {
        setRgb(Integer.parseInt(rgb.split("#")[0]));
    }

    public Color asColor() {
        return new Color(rgb);
    }

    public void update(VectorColor color) {
        setRgb(color.getRGB());
        setActive(color.isActive());
    }

    public String toString () {
        if (isActive()) { return  String.format( "#%06x", getRGB()).toUpperCase(); }
        else { return "OFF"; }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VectorColor) {
            VectorColor color = (VectorColor) obj;
            return (color.isActive() == isActive() && color.getRGB() == getRGB()) || (!color.isActive() && !isActive());
        } else { return false; }
    }
}
