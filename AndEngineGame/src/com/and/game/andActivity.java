package com.and.game;

import java.util.LinkedList;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.view.Display;


public class andActivity extends BaseGameActivity  {
	//private
	private Camera mCamera;
	private Scene mainScene;
    private BitmapTextureAtlas bitmap;
    private TextureRegion playTextureRegion;
    private TextureRegion enemyTextureRegion;
    private LinkedList enemies;
    private LinkedList enemiesToBeAdded;
    private Sprite player;
	@Override
	public Engine onLoadEngine() {
		final Display display = getWindowManager().getDefaultDisplay();
		mCamera = new Camera(0, 0, display.getWidth(), display.getHeight());
		
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				         new RatioResolutionPolicy(mCamera.getWidth(), mCamera.getHeight()),
				         mCamera).setNeedsMusic(true).setNeedsSound(true));
	}

	@Override
	public void onLoadResources() {
		//SoundFactory.setAssetBasePath("sounds/");
		// used to stick image on it
		bitmap = new BitmapTextureAtlas(512, 512, // Resolution
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		playTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bitmap, this, "sub.png", 0, 0);
		enemyTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				bitmap, this, "Target.png", 128, 0);
	    mEngine.getTextureManager().loadTexture(bitmap);	
	}

	@Override
	public Scene onLoadScene() {
		mEngine.registerUpdateHandler(new FPSLogger());
		mainScene = new Scene();
		mainScene.setBackground(new ColorBackground(0.09f, 0.6f, 0.8f));
		int playerX = playTextureRegion.getWidth() / 2;
		int playerY = (int)(mCamera.getHeight() - playTextureRegion.getHeight()) / 2;
		
		player = new Sprite(playerX, playerY, playTextureRegion);
		player.setScale(2);
		
		mainScene.attachChild(player);
		
		return mainScene;
	}

	@Override
	public void onLoadComplete() {
		
		
	}
    
  
}