package UI;

import java.awt.Graphics2D;

import Render.GameResource;

public class Two extends RightDrawer {

	public Two(int x, int y) {
		super(x, y);
		img02 = GameResource.img02;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(img02, x, y, 100, 100, null);
	}

}
