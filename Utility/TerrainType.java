package Utility;

import java.awt.Color;

public class TerrainType {
    private String name;
    private float height;
    private Color colour;

    public TerrainType(String name_, float height_, Color colour_) {
        name = name_;
        height = height_;
        colour = colour_;
    }

    public String getName() {
        return this.name;
    }

    public float getHeight() {
        return this.height;
    }

    public Color getColor() {
        return this.colour;
    }
    public void setColor(Color c) {
        this.colour = c;
    }

}
