package UI;

import java.awt.*;

import javax.swing.*;

import Render.LeftRenderObj;

@SuppressWarnings("serial")
public class LeftGameScreen extends JComponent {

	public LeftGameScreen() {
		super();
		setPreferredSize(new Dimension(480, 620));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		if (FirstPanel.check) {
			synchronized (LeftRenderObj.getInstance().getRenderableList()) {
				for (int i = 0; i < LeftRenderObj.getInstance().getRenderableList().size(); i++) {
					LeftRenderObj.getInstance().getRenderableList().get(i).draw(g2d);
				}
			}
		}

	}

}
