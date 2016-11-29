package UI;

import java.awt.Graphics2D;

import Logic.RandomUtility;
import Render.GameResource;
import Render.Renderable;

public class Key implements Renderable {

	protected int x;
	protected int y;
	protected int radius;
	protected int speed;
	public boolean destroyed;
	public int i;

	public Key() {
		x = RandomUtility.random(0, 380);
		y = -100;
		speed = RandomUtility.random(3, 6);
		i = RandomUtility.random(0, 4);
		GameResource.keyNo[i]++;
		radius = 100;
		destroyed = false;
	}

	public void update() {
		y += speed;
		if (y > 600)
			destroyed = true;

	}

	public boolean isDestroyed() {
		return destroyed;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawImage(GameResource.c[i], null, x, y);
	}

	@Override
	public boolean isVisible() {
		return true;
	}

}
