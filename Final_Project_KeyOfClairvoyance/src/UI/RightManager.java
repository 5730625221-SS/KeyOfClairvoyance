package UI;

import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.RightLogic;
import Render.GameResource;
import Render.RightRenderObj;

public class RightManager {

	public JPanel right = new JPanel();
	public RightGameScreen rg;

	public static int x = 900;
	public static int y = 900;

	public RightManager() throws InterruptedException {
		right.setLayout(null);
		right.setPreferredSize(new Dimension(480, 620));
		right.setLocation(480, 100);

		rg = new RightGameScreen();
		rg.setSize(rg.getPreferredSize());
		JLabel background = new JLabel(new ImageIcon(GameResource.bg2));
		background.setSize(background.getPreferredSize());

		right.add(rg);
		right.add(background);

		right.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				x = -1;
				y = -1;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				GameResource.circleClick.play();
			}
		});
	}

	public static void run(RightLogic logic) {
		while (true) {
			if (Start.getTime() <= 0) {
				for (int x = 0; x < RightRenderObj.getInstance().getRenderableList().size(); x += 0) {
					RightRenderObj.getInstance().getRenderableList().remove(x);
				}
				break;
			}
			if (FirstPanel.check) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logic.logicUpdate();
				GameScreen.gameScreen.repaint();
			}
		}
	}

}
