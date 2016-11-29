package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Render.*;

@SuppressWarnings("serial")
public class ModePanel extends JPanel {

	static boolean draw;
	public static int mode;

	public ModePanel() {
		draw = true;
		setBackground(new Color(200, 200, 200, 100));
		setLayout(null);
		JLabel background = new JLabel(new ImageIcon(Resource2.bg));
		background.setSize(background.getPreferredSize());

		JLabel single = new JLabel(new ImageIcon(Resource2.img3));
		single.setSize(single.getPreferredSize());
		single.setLocation(28, 151);
		single.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
				single.setIcon(new ImageIcon(Resource2.img4));
				Resource2.clip.play();
				repaint();
				draw = false;
			}

			public void mouseExited(MouseEvent e2) {
				single.setIcon(new ImageIcon(Resource2.img3));
				repaint();
				draw = false;
			}

			public void mouseClicked(MouseEvent e2) {
				// setting
				mode = 1;
				Start.setTime(180);
				GameScreen.setScore(100);
				GameScreen.gameTime.setText("180");
				GameScreen.gameScore.setText("100");
				FirstPanel.maincards.next(FirstPanel.firstPanel);
				// setting

				ControlPanel.controlcards.first(ControlPanel.controlPanel);
				Resource.soundbg.stop();
			}

		});
		JLabel endless = new JLabel(new ImageIcon(Resource2.img5));
		endless.setSize(endless.getPreferredSize());
		endless.setLocation(479, 151);
		endless.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
				endless.setIcon(new ImageIcon(Resource2.img6));
				Resource2.clip.play();
				repaint();
				draw = false;
			}

			public void mouseExited(MouseEvent e2) {
				endless.setIcon(new ImageIcon(Resource2.img5));
				repaint();
				draw = false;
			}

			public void mouseClicked(MouseEvent e2) {
				// setting
				mode = 2;
				Start.setTime(30);
				GameScreen.setScore(100);
				GameScreen.gameTime.setText("30");
				GameScreen.gameScore.setText("100");
				FirstPanel.maincards.next(FirstPanel.firstPanel);
				// setting

				ControlPanel.controlcards.first(ControlPanel.controlPanel);
				Resource.soundbg.stop();
			}

		});

		JLabel exit = new JLabel(new ImageIcon(Resource2.img));
		exit.setSize(exit.getPreferredSize());
		exit.setLocation(900, 20);
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

		add(single);
		add(endless);
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
