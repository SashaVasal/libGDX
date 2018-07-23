package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;
import javax.swing.JFrame;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;



public class MyGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public int Planet1;
	public int Planet2;
	public int Planet3;
	public int Planet4;
	public Texture btn;

	public boolean pause;

	public class Planet{
		public int RadiusPlanet;
		public int SpeedPlanet;
		public int SizePlanet;
		public long X0Planet;
		public long Y0Planet;
		public double XPlanet;
		public double YPlanet;
		public Texture TexturePlanet;
		public int AngelPlanet;
		public long X;
		public long Y;


	}
	@Override


	public void create () {
		batch = new SpriteBatch();
		btn = new Texture("btn.png");
		pause = false;

	}

	@Override
	public void render () {
		Planet Sun = new Planet();
		Sun.SizePlanet = 300;
		Sun.X0Planet = 800;
		Sun.Y0Planet = 400;
		Sun.TexturePlanet = new Texture("Render_sun.png");

		Planet Earth = new Planet();
		Earth.TexturePlanet = new Texture("earth1.png");
		Earth.RadiusPlanet = 200;
		Earth.SizePlanet = 100;
		Earth.X0Planet = Sun.X0Planet + 100 ;
		Earth.Y0Planet = Sun.Y0Planet + 100;
		Earth.SpeedPlanet = 10 ;
		if(pause == false){
			Planet1 +=Earth.SpeedPlanet;
		}

		Earth.XPlanet = Earth.X0Planet + Earth.RadiusPlanet * Math.cos(Math.toRadians(Planet1 / 2 / 3.14));
		Earth.YPlanet = Earth.Y0Planet + Earth.RadiusPlanet * Math.sin(Math.toRadians(Planet1  / 2 / 3.14));
		Earth.X = Math.round(Earth.XPlanet);
		Earth.Y = Math.round(Earth.YPlanet);

		Planet Mars = new Planet();
		Mars.TexturePlanet = new Texture("mars.png");
		Mars.RadiusPlanet = -400;
		Mars.SizePlanet = 100;
		Mars.X0Planet = Sun.X0Planet + 100;
		Mars.Y0Planet = Sun.Y0Planet + 100;
		Mars.SpeedPlanet = 12 ;
		if(pause == false){
			Planet2 +=Mars.SpeedPlanet;
		}
		Mars.XPlanet = Mars.X0Planet + Mars.RadiusPlanet * Math.cos(Math.toRadians(Planet2 / 2 / 3.14));
		Mars.YPlanet = Mars.Y0Planet + Mars.RadiusPlanet * Math.sin(Math.toRadians(Planet2  / 2 / 3.14));
		Mars.X = Math.round(Mars.XPlanet);
		Mars.Y = Math.round(Mars.YPlanet);

		Planet Moon = new Planet();
		Moon.TexturePlanet = new Texture("moon.png");
		Moon.RadiusPlanet = 100;
		Moon.SizePlanet = 20;
		Moon.X0Planet = Mars.X +33;
		Moon.Y0Planet = Mars.Y + 33;
		Moon.SpeedPlanet = 30 ;
		if(pause == false){
			Planet3 +=Moon.SpeedPlanet;
		}
		Moon.XPlanet = Moon.X0Planet + Moon.RadiusPlanet * Math.cos(Math.toRadians(Planet3 / 2 / 3.14));
		Moon.YPlanet = Moon.Y0Planet + Moon.RadiusPlanet * Math.sin(Math.toRadians(Planet3  / 2 / 3.14));
		Moon.X = Math.round(Moon.XPlanet);
		Moon.Y = Math.round(Moon.YPlanet);

		Planet Jupiter = new Planet();
		Jupiter.TexturePlanet = new Texture("jupiter.png");
		Jupiter.RadiusPlanet = 500;
		Jupiter.SizePlanet = 300;
		Jupiter.X0Planet = Sun.X0Planet + 100;
		Jupiter.Y0Planet = Sun.Y0Planet + 100;
		Jupiter.SpeedPlanet = 7;
		if(pause == false){
			Planet4 +=Jupiter.SpeedPlanet;
		}
		Jupiter.XPlanet = Jupiter.X0Planet + Jupiter.RadiusPlanet * Math.cos(Math.toRadians(Planet4 / 2 / 3.14));
		Jupiter.YPlanet = Jupiter.Y0Planet + Jupiter.RadiusPlanet * Math.sin(Math.toRadians(Planet4  / 2 / 3.14));
		Jupiter.X = Math.round(Jupiter.XPlanet);
		Jupiter.Y = Math.round(Jupiter.YPlanet);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(Sun.TexturePlanet, Sun.X0Planet, Sun.Y0Planet , Sun.SizePlanet, Sun.SizePlanet);
		batch.draw(Earth.TexturePlanet, Earth.X, Earth.Y , Earth.SizePlanet, Earth.SizePlanet);
		batch.draw(Moon.TexturePlanet, Moon.X, Moon.Y , Moon.SizePlanet, Moon.SizePlanet);
		batch.draw(Mars.TexturePlanet, Mars.X, Mars.Y , Mars.SizePlanet, Mars.SizePlanet);
		batch.draw(Jupiter.TexturePlanet, Jupiter.X, Jupiter.Y , Jupiter.SizePlanet, Jupiter.SizePlanet);
		batch.draw(btn, 100, 100 , 100, 100);
		batch.end();
		if(Gdx.input.getY()>=860 && Gdx.input.getY()<=960){
			if(Gdx.input.getX()>=100 && Gdx.input.getX()<=200){
				if(pause == false){
					pause = true;
				} else{
					pause = false;
				}
			}

		}
	}



	@Override
	public void dispose () {
		batch.dispose();
	}
	@Override
	public void pause () {

	}
}
