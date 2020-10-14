package com.example.ilogicrebirth;

import java.util.List;

public class MapGenerator {
    private final Assets assets;
    private final List<Tile> tileList;
    private final List<UnitType> unitTypeList;

    public MapGenerator(Assets assets) {
        this.assets = assets;

        TileLoader tileLoader = new TileLoader(assets);
        UnitTypeLoader unitTypeLoader = new UnitTypeLoader(assets);
        this.tileList = tileLoader.loadTiles();
        this.unitTypeList = unitTypeLoader.loadUnits();
    }

    public Map generateMap() {
        Map map = new Map(tileList, unitTypeList);

        for (int y = 0; y < map.MAP_HEIGHT; y++) {
            for (int x = 0; x < map.MAP_WIDTH; x++) {
                map.setTile(y, x, (x + y) % tileList.size());
            }
        }

        map.addUnit(0, 0, 0);

        return map;
    }
}
