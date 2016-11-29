package UI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Render.GameResource;
import Render.Renderable;

public class RightDrawer implements Renderable {

	// Default Position Object...
	int x = 200;
	int y = 150;
	// Object Image...
	public static BufferedImage img01;
	public static BufferedImage img02;
	public static BufferedImage img03;
	public static BufferedImage img04;
	public static BufferedImage bg;

	static {
		try {
			bg = GameResource.bg2;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics2D g) {
	}

	public RightDrawer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean collideWith(int xx, int yy) {
		if (Math.hypot(x + 50 - xx, y + 50 - yy) <= 50) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

}
