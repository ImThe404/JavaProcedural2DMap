package Utility;

import java.util.ArrayList;

public class Regions {
    private ArrayList<TerrainType> TerrainList;

    public Regions() {
        TerrainList = new ArrayList<>();
    }

    public void addTerrain(TerrainType t) {
        TerrainList.add(t);
    }

    public void removeTerrain(TerrainType t) {
        TerrainList.remove(t);
    }

}
