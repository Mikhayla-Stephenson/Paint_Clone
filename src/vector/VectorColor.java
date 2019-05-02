package vector;

import java.awt.*;

public class VectorColor {
    static final VectorColor CLEAR = new VectorColor(0, false);
    private boolean active;
    private int rgb;

    VectorColor(int rgb) {
        this.rgb = rgb;
        active = true;
    }

    VectorColor(int rgb, boolean active) {
        this.rgb = rgb;
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
        this.rgb = rgb;
    }

    public Color asColor() {
        return new Color(rgb);
    }

    public String toString () {
        if (isActive()) { return  String.format( "#%06x", getRGB()).toUpperCase(); }
        else { return "OFF"; }
    }

    public boolean isEquals(VectorColor c) {
        return (c.isActive() == isActive() && c.getRGB() == getRGB()) || (!c.isActive() && !isActive());
    }


}
