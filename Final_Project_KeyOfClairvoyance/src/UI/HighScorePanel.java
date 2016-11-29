package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

import Render.GameResource;
import Render.Resource;
import Render.Resource2;
import Render.Resource3;

@SuppressWarnings("serial")
public class HighScorePanel extends JPanel {

	static boolean draw;
	static boolean sc = true;
	static boolean ec = false;
	static JLabel h1;
	static JLabel h2;
	static JLabel h3;
	static JLabel h4;
	static JLabel h5;

	public HighScorePanel() {
		draw = true;
		setBackground(new Color(200, 200, 200, 100));
		setLayout(null);
		JLabel background = new JLabel(new ImageIcon(Resource3.bg));
		background.setSize(background.getPreferredSize());
		background.setLocation(0, 0);

		JLabel single = new JLabel(new ImageIcon(Resource3.img5));
		single.setSize(single.getPreferredSize());
		single.setLocation(28, 259);

		JLabel endless = new JLabel(new ImageIcon(Resource3.img6));
		endless.setSize(endless.getPreferredSize());
		endless.setLocation(28, 377);

		h1 = new JLabel(HighScoreUtility.displayTop5(0));
		h1.setFont(GameResource.highscoreFont);
		h1.setForeground(Color.BLUE);
		h1.setSize(h1.getPreferredSize());
		h1.setLocation(320, 180);

		h2 = new JLabel(HighScoreUtility.displayTop5(1));
		h2.setFont(GameResource.highscoreFont);
		h2.setForeground(Color.BLUE);
		h2.setSize(h2.getPreferredSize());
		h2.setLocation(320, 260);

		h3 = new JLabel(HighScoreUtility.displayTop5(2));
		h3.setFont(GameResource.highscoreFont);
		h3.setForeground(Color.BLUE);
		h3.setSize(h3.getPreferredSize());
		h3.setLocation(320, 340);

		h4 = new JLabel(HighScoreUtility.displayTop5(3));
		h4.setFont(GameResource.highscoreFont);
		h4.setForeground(Color.BLUE);
		h4.setSize(h4.getPreferredSize());
		h4.setLocation(320, 420);

		h5 = new JLabel(HighScoreUtility.displayTop5(4));
		h5.setFont(GameResource.highscoreFont);
		h5.setForeground(Color.BLUE);
		h5.setSize(h5.getPreferredSize());
		h5.setLocation(320, 500);

		single.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
				if (sc) {
					single.setIcon(new ImageIcon(Resource3.img5));
				} else
					single.setIcon(new ImageIcon(Resource3.img4));
				Resource3.clip2.play();
				repaint();
				draw = false;
			}

			public void mouseExited(MouseEvent e2) {
				if (sc) {
					single.setIcon(new ImageIcon(Resource3.img5));
				} else
					single.setIcon(new ImageIcon(Resource3.img3));
				repaint();
				draw = false;
			}

			public void mouseClicked(MouseEvent e2) {
				single.setIcon(new ImageIcon(Resource3.img5));
				endless.setIcon(new ImageIcon(Resource3.img6));
				h1.setText(HighScoreUtility.displayTop5(0));
				h1.setSize(h1.getPreferredSize());
				h2.setText(HighScoreUtility.displayTop5(1));
				h2.setSize(h2.getPreferredSize());
				h3.setText(HighScoreUtility.displayTop5(2));
				h3.setSize(h3.getPreferredSize());
				h4.setText(HighScoreUtility.displayTop5(3));
				h4.setSize(h4.getPreferredSize());
				h5.setText(HighScoreUtility.displayTop5(4));
				h5.setSize(h5.getPreferredSize());
				sc = true;
				ec = false;
				repaint();
				draw = false;
			}

		});

		endless.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e2) {
				if (ec) {
					endless.setIcon(new ImageIcon(Resource3.img8));
				} else
					endless.setIcon(new ImageIcon(Resource3.img7));
				Resource3.clip2.play();
				repaint();
				draw = false;
			}

			public void mouseExited(MouseEvent e2) {
				if (ec) {
					endless.setIcon(new ImageIcon(Resource3.img8));
				} else
					endless.setIcon(new ImageIcon(Resource3.img6));
				repaint();
				draw = false;
			}

			public void mouseClicked(MouseEvent e2) {
				endless.setIcon(new ImageIcon(Resource3.img8));
				single.setIcon(new ImageIcon(Resource3.img3));
				h1.setText(HighScoreUtility2.displayTop5(0));
				h1.setSize(h1.getPreferredSize());
				h2.setText(HighScoreUtility2.displayTop5(1));
				h2.setSize(h2.getPreferredSize());
				h3.setText(HighScoreUtility2.displayTop5(2));
				h3.setSize(h3.getPreferredSize());
				h4.setText(HighScoreUtility2.displayTop5(3));
				h4.setSize(h4.getPreferredSize());
				h5.setText(HighScoreUtility2.displayTop5(4));
				h5.setSize(h5.getPreferredSize());

				sc = false;
				ec = true;
				repaint();
				draw = false;
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

		add(h1);
		add(h2);
		add(h3);
		add(h4);
		add(h5);
		add(exit);
		add(single);
		add(endless);
		add(background);
	}

	public static void rescore1() {
		h1.setText(HighScoreUtility.displayTop5(0));
		h1.setSize(h1.getPreferredSize());
		h2.setText(HighScoreUtility.displayTop5(1));
		h2.setSize(h2.getPreferredSize());
		h3.setText(HighScoreUtility.displayTop5(2));
		h3.setSize(h3.getPreferredSize());
		h4.setText(HighScoreUtility.displayTop5(3));
		h4.setSize(h4.getPreferredSize());
		h5.setText(HighScoreUtility.displayTop5(4));
		h5.setSize(h5.getPreferredSize());
	}

	public static void rescore2() {
		h1.setText(HighScoreUtility2.displayTop5(0));
		h1.setSize(h1.getPreferredSize());
		h2.setText(HighScoreUtility2.displayTop5(1));
		h2.setSize(h2.getPreferredSize());
		h3.setText(HighScoreUtility2.displayTop5(2));
		h3.setSize(h3.getPreferredSize());
		h4.setText(HighScoreUtility2.displayTop5(3));
		h4.setSize(h4.getPreferredSize());
		h5.setText(HighScoreUtility2.displayTop5(4));
		h5.setSize(h5.getPreferredSize());
	}

	public void paintComponent(Graphics g) {
		if (draw) {
			g.setColor(this.getBackground());
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
	}

}
