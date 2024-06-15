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
    public void setName(String n) {
        this.name = n;
    }

    public float getHeight() {
        return this.height;
    }
    public void setHeight(float h) {
        this.height = h;
    }

    public Color getColor() {
        return this.colour;
    }
    public void setColor(Color c) {
        this.colour = c;
    }
}
