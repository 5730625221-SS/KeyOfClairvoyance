package UI;

import java.awt.Graphics2D;

import Render.GameResource;

public class One extends RightDrawer {

	public One(int x, int y) {
		super(x, y);
		img01 = GameResource.img01;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(img01, x, y, 100, 100, null);
	}

}
