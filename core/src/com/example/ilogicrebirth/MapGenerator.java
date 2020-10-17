package com.example.ilogicrebirth;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

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

    public Map generateMap(String fileName) {
        JsonReader json = new JsonReader();
        JsonValue base = json.parse(Gdx.files.internal(fileName));
        JsonValue height = base.get("height");
        JsonValue width = base.get("width");
        JsonValue mapValues = base.get("map");
        Map map = new Map(tileList, height.asInt(), width.asInt());


        for (int y = 0; y < mapValues.size; y++) {
            for (int x = 0; x < mapValues.get(y).size; x++) {
                map.setTile(y, x, mapValues.get(y).get(x).asInt());
            }
        }

        return map;
    }
}
