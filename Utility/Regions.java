package Utility;

import java.util.ArrayList;

public class Regions {
    private ArrayList<TerrainType> TerrainList;

    public Regions() {
        TerrainList = new ArrayList<>();
    }

    public Regions(ArrayList<TerrainType> list) {
        TerrainList = list;
    }

    public void addTerrain(TerrainType t) {
        for (int i = 0 ; i < TerrainList.size() ; i++ ) {
            if (t.getHeight() < TerrainList.get(i).getHeight() ) {
                TerrainList.add(i, t);
                break;
            }
        } 
    }

    public void removeTerrain(TerrainType t) {
        TerrainList.remove(t);
    }

    public ArrayList<TerrainType> getTerrainList() {
        return TerrainList;
    }

}
