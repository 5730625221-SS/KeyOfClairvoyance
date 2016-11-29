package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import Logic.RandomUtility;
import Render.RightRenderObj;

@SuppressWarnings("serial")
public class RightGameScreen extends JComponent {

	public RightGameScreen() {
		super();
		int PositionObj[] = RandomUtility.randomObj();

		RightRenderObj.getInstance().add(new One(PositionObj[0], PositionObj[1]));
		RightRenderObj.getInstance().add(new Two(PositionObj[2], PositionObj[3]));
		RightRenderObj.getInstance().add(new Three(PositionObj[4], PositionObj[5]));
		RightRenderObj.getInstance().add(new Four(PositionObj[6], PositionObj[7]));
		setPreferredSize(new Dimension(480, 620));
		setVisible(true);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		if (FirstPanel.check) {
			synchronized (RightRenderObj.getInstance().getRenderableList()) {
				for (int i = 0; i < RightRenderObj.getInstance().getRenderableList().size(); i++) {
					if (RightRenderObj.getInstance().getRenderableList().get(i).isVisible())
						RightRenderObj.getInstance().getRenderableList().get(i).draw(g2d);
				}
			}
		}

	}

}
