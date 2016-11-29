package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Render.GameResource;

public class GameScreen {

	public static JPanel gameScreen;
	public static RightManager right = null;
	public static LeftManager left = null;
	public static JPanel north;
	public static JLabel gameScore;
	public static JLabel pause;
	public static JLabel gameTime;

	private static int score;

	public GameScreen() {
		gameScreen = new JPanel();
		gameScreen.setLayout(null);
		gameScreen.setPreferredSize(new Dimension(960, 720));

		north = new JPanel();

		try {
			right = new RightManager();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			left = new LeftManager();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		north.setPreferredSize(new Dimension(960, 100));

		north.setBackground(Color.BLUE);
		north.setLocation(0, 0);
		north.setSize(north.getPreferredSize());
		north.setLayout(null);

		gameScore = new JLabel(score + "");
		gameScore.setFont(GameResource.defaultFont);
		gameScore.setForeground(Color.YELLOW);
		gameScore.setSize(new Dimension(140, 120));
		gameScore.setLocation(800, 5);

		gameTime = new JLabel(Start.getTime() + "");
		gameTime.setFont(GameResource.defaultFont);
		gameTime.setForeground(Color.YELLOW);
		gameTime.setSize(new Dimension(117, 120));
		gameTime.setLocation(480, 5);

		JLabel gameBg = new JLabel(new ImageIcon(GameResource.nbg));
		gameBg.setSize(gameBg.getPreferredSize());

		pause = new JLabel(new ImageIcon(GameResource.nullpause));
		pause.setSize(pause.getPreferredSize());

		north.add(gameScore);
		north.add(gameTime);
		north.add(gameBg);

		left.left.setSize(left.left.getPreferredSize());
		right.right.setSize(right.right.getPreferredSize());

		gameScreen.add(pause);
		gameScreen.add(north);
		gameScreen.add(left.left);
		gameScreen.add(right.right);

	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		GameScreen.score = score;
	}

	public static int increaseScore(int i) {
		if (score >= 9999)
			return score = 9999;
		else
			return score += i;
	}

	public static int decreaseScore(int i) {
		score -= i;
		if (score <= 0)
			score = 0;
		return score;
	}

	public static void reScore() {
		gameScore.setText((GameScreen.score) + "");
	}

}
