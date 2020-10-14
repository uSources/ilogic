package com.example.ilogicrebirth;

import java.util.List;

public class MapGenerator {
    private final List<Tile> tileList;

    public MapGenerator(List<Tile> tileList) {
        this.tileList = tileList;
    }

    public Map generateMap() {
        Map map = new Map(tileList);

        for (int y = 0; y < map.MAP_HEIGHT; y++) {
            for (int x = 0; x < map.MAP_WIDTH; x++) {
                map.setTile(y, x, (x + y) % tileList.size());
            }
        }

        return map;
    }
}
