package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import Render.Resource;
import Render.Resource2;
import Render.Resource5;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel {

	// ...
	static boolean draw;

	public InfoPanel() {
		draw = true;
		setBackground(new Color(200, 200, 200, 100));
		setLayout(null);
		JLabel background = new JLabel(new ImageIcon(Resource5.bg));
		background.setSize(background.getPreferredSize());
		background.setLocation(25, 40);

		JLabel exit = new JLabel(new ImageIcon(Resource2.img));
		exit.setSize(exit.getPreferredSize());
		exit.setLocation(880, 20);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
				exit.setIcon(new ImageIcon(Resource2.img2));
				Resource.exit.play();
				repaint();
				draw = false;
			}

			public void mouseExited(MouseEvent e2) {
				exit.setIcon(new ImageIcon(Resource2.img));
				repaint();
				draw = false;
			}

			public void mouseClicked(MouseEvent e2) {
				ControlPanel.controlcards.first(ControlPanel.controlPanel);
			}

		});

		add(exit);
		add(background);
	}

	public void paintComponent(Graphics g) {
		if (draw) {
			g.setColor(this.getBackground());
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	}

}
