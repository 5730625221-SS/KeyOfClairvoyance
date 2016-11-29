package UI;

import java.awt.Graphics2D;

import Render.GameResource;

public class Three extends RightDrawer {

	public Three(int x, int y) {
		super(x, y);
		img03 = GameResource.img03;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(img03, x, y, 100, 100, null);
	}

}
