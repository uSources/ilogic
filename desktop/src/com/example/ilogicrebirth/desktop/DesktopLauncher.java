package com.example.ilogicrebirth.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.example.ilogicrebirth.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ilogic: Rebirth";
		config.addIcon("units/b_Soldier.png", Files.FileType.Internal);
		new LwjglApplication(new MyGame(), config);
	}
}
