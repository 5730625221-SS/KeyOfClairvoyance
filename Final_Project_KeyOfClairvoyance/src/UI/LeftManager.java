package UI;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.LeftLogic;
import Render.GameResource;

public class LeftManager {

	public JPanel left = new JPanel();
	public LeftGameScreen lg;

	public static int x = 900;
	public static int y = 900;

	public LeftManager() throws InterruptedException {
		left.requestFocus();
		left.setFocusable(true);
		left.setLayout(null);
		left.setPreferredSize(new Dimension(480, 620));
		left.setLocation(0, 100);

		lg = new LeftGameScreen();
		lg.setSize(lg.getPreferredSize());
		JLabel background = new JLabel(new ImageIcon(GameResource.bg));
		background.setSize(background.getPreferredSize());

		left.add(lg);
		left.add(background);

		left.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}

	public static void run(LeftLogic logic) {
		while (true) {
			if (Start.getTime() <= 0) {
				LeftLogic.getInstance().clearKey();
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
