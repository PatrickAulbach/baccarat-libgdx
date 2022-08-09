package com.libgdx.baccarat;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Logger;

import com.libgdx.baccarat.screen.LoadingScreen;
import lombok.Getter;

public class BaccaratGame extends Game {

	@Getter
	private AssetManager assetManager;

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		assetManager = new AssetManager();
		assetManager.getLogger().setLevel(Logger.DEBUG);
		setScreen(new LoadingScreen(this, assetManager));
	}
	
	@Override
	public void dispose () {

	}
}
