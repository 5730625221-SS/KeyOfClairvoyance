
package UI;

import java.awt.event.*;

import javax.swing.*;

import Render.Resource;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	public static boolean clickMute = false;

	public MainPanel() {
		setLayout(null);
		Resource.soundbg.loop();

		JLabel nullimage1 = new JLabel(new ImageIcon(Resource.nullimage));
		nullimage1.setSize(nullimage1.getPreferredSize());
		nullimage1.setLocation(310, 420);

		JLabel nullimage2 = new JLabel(new ImageIcon(Resource.nullimage));
		nullimage2.setSize(nullimage2.getPreferredSize());
		nullimage2.setLocation(450, 510);

		JLabel background = new JLabel(new ImageIcon(Resource.bg));
		background.setSize(background.getPreferredSize());

		JLabel startgame = new JLabel(new ImageIcon(Resource.img));
		startgame.setSize(startgame.getPreferredSize());
		startgame.setLocation(380, 420);
		startgame.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				startgame.setIcon(new ImageIcon(Resource.img2));
				nullimage1.setIcon(new ImageIcon(Resource.tri));
				Resource.clip.play();
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				startgame.setIcon(new ImageIcon(Resource.img));
				nullimage1.setIcon(new ImageIcon(Resource.nullimage));
			}

			public void mouseClicked(MouseEvent e) {
				nullimage1.setIcon(new ImageIcon(Resource.nullimage));
				startgame.setIcon(new ImageIcon(Resource.nullimage));
				ModePanel.draw = true;
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
			}

		});

		JLabel hightscore = new JLabel(new ImageIcon(Resource.img3));
		hightscore.setSize(hightscore.getPreferredSize());
		hightscore.setLocation(520, 520);
		hightscore.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				hightscore.setIcon(new ImageIcon(Resource.img4));
				nullimage2.setIcon(new ImageIcon(Resource.tri));
				Resource.clip.play();
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				hightscore.setIcon(new ImageIcon(Resource.img3));
				nullimage2.setIcon(new ImageIcon(Resource.nullimage));
			}

			public void mouseClicked(MouseEvent e) {
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				HighScorePanel.draw = true;
			}

		});

		JLabel info = new JLabel(new ImageIcon(Resource.img5));
		info.setSize(info.getPreferredSize());
		info.setLocation(870, 640);
		info.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				info.setIcon(new ImageIcon(Resource.img6));
				Resource.clip2.play();
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				info.setIcon(new ImageIcon(Resource.img5));
			}

			public void mouseClicked(MouseEvent e) {
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				InfoPanel.draw = true;
			}

		});

		JLabel setting = new JLabel(new ImageIcon(Resource.img7));
		setting.setSize(setting.getPreferredSize());
		setting.setLocation(800, 640);
		setting.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setting.setIcon(new ImageIcon(Resource.img8));
				Resource.clip2.play();
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				setting.setIcon(new ImageIcon(Resource.img7));
			}

			public void mouseClicked(MouseEvent e) {
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				SettingPanel.draw = true;
			}

		});

		JLabel howtoplay = new JLabel(new ImageIcon(Resource.img9));
		howtoplay.setSize(howtoplay.getPreferredSize());
		howtoplay.setLocation(730, 640);
		howtoplay.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				howtoplay.setIcon(new ImageIcon(Resource.img10));
				Resource.clip2.play();
				repaint();
			}

			public void mouseExited(MouseEvent e) {
				howtoplay.setIcon(new ImageIcon(Resource.img9));
			}

			public void mouseClicked(MouseEvent e) {
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				ControlPanel.controlcards.next(ControlPanel.controlPanel);
				HowToPlayPanel.draw = true;
			}

		});

		JLabel sound = new JLabel(new ImageIcon(Resource.img11));
		sound.setSize(sound.getPreferredSize());
		sound.setLocation(660, 640);

		sound.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if (!clickMute)
					sound.setIcon(new ImageIcon(Resource.img12));
				else
					sound.setIcon(new ImageIcon(Resource.img14));
				Resource.clip2.play();
			}

			public void mouseExited(MouseEvent e) {
				if (!clickMute)
					sound.setIcon(new ImageIcon(Resource.img11));
				else
					sound.setIcon(new ImageIcon(Resource.img13));
			}

			public void mouseClicked(MouseEvent e) {
				if (!clickMute) {
					sound.setIcon(new ImageIcon(Resource.img14));
					Resource.soundbg.stop();
					clickMute = true;
				} else {
					sound.setIcon(new ImageIcon(Resource.img12));
					Resource.soundbg.loop();
					clickMute = false;
				}
			}

		});

		add(startgame);
		add(hightscore);
		add(info);
		add(setting);
		add(howtoplay);
		add(sound);
		add(nullimage1);
		add(nullimage2);
		add(background);
	}
	
}
