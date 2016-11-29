package UI;

import java.awt.CardLayout;

import javax.swing.*;

public class ControlPanel {

	// controlLayout...
	static CardLayout controlcards = new CardLayout();
	// Control Deck...
	public static JPanel controlPanel = new JPanel();

	public ControlPanel() {
		controlPanel.setLayout(controlcards);
		MainPanel mainPanel = new MainPanel(); // main
		ModePanel modePanel = new ModePanel(); // mode
		SettingPanel settingPanel = new SettingPanel(); // setting
		HighScorePanel highScorePanel = new HighScorePanel(); // high score
		InfoPanel infoPanel = new InfoPanel(); // info
		HowToPlayPanel howToPlayPanel = new HowToPlayPanel(); // how to

		controlPanel.add(mainPanel);
		controlPanel.add(modePanel);
		controlPanel.add(settingPanel);
		controlPanel.add(highScorePanel);
		controlPanel.add(infoPanel);
		controlPanel.add(howToPlayPanel);
	}

}
