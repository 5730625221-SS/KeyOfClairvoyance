package UI;

import java.awt.Graphics2D;

import Render.GameResource;

public class Four extends RightDrawer {

	public Four(int x, int y) {
		super(x, y);
		img04 = GameResource.img04;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(img04, x, y, 100, 100, null);
	}

}
