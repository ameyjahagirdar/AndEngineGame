package com.and.game;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.view.Display;


public class andActivity extends BaseGameActivity  {
	//private
	private Camera mCamera;
	private Scene mainScene;

	@Override
	public Engine onLoadEngine() {
		final Display display = getWindowManager().getDefaultDisplay();
		mCamera = new Camera(0, 0, display.getWidth(), display.getHeight());
		
		return new Engine(new EngineOptions(true, ScreenOrientation.LANDSCAPE,
				         new RatioResolutionPolicy(mCamera.getWidth(), mCamera.getHeight()),
				         mCamera));
	}

	@Override
	public void onLoadResources() {
		
		
	}

	@Override
	public Scene onLoadScene() {
		mEngine.registerUpdateHandler(new FPSLogger());
		mainScene = new Scene();
		mainScene.setBackground(new ColorBackground(0.09f, 0.6f, 0.8f));
		return mainScene;
	}

	@Override
	public void onLoadComplete() {
		
		
	}
    
  
}