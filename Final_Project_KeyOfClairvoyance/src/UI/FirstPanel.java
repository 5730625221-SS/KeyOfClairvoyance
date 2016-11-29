package UI;

import java.awt.CardLayout;

import javax.swing.*;

public class FirstPanel {

	// Main Deck...
	public static JPanel firstPanel = new JPanel();
	// Card...
	public static ControlPanel controlPanel = new ControlPanel();
	public static StoryPanel storyPanel = new StoryPanel();
	public static GameScreen gameScreen = new GameScreen();
	// Main Layout...
	public static CardLayout maincards = new CardLayout();
	public static boolean check = false;

	public FirstPanel() {

		firstPanel.setLayout(maincards);

		firstPanel.add(ControlPanel.controlPanel);
		firstPanel.add(StoryPanel.storyPanel);
		firstPanel.add(GameScreen.gameScreen);
	}

}
