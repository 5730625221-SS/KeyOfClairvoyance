package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Render.GameResource;
import Render.Resource;

public class StoryPanel {

	public static JPanel storyPanel = new JPanel();
	// Game Runnable...
	private static RightThread rightThread;
	private static LeftThread leftThread;
	// Time Runnable...
	private static Start start = new Start();
	// Game Thread
	public static Thread right;
	public static Thread left;

	public static boolean draw = false;

	public StoryPanel() {

		storyPanel.setLayout(null);
		storyPanel.setBackground(Color.BLACK);
		JLabel startLabel = new JLabel(">>> Let's Play Game  <<<");
		startLabel.setForeground(Color.RED);
		startLabel.setFont(GameResource.storyFont);
		startLabel.setSize(startLabel.getPreferredSize());
		startLabel.setLocation(180, 300);
		startLabel.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				if (!draw) {
					Resource.clip.play();
					startLabel.setLocation(60, 290);
					startLabel.setFont(new Font("PL-Edit", Font.BOLD, 70));
					startLabel.setSize(startLabel.getPreferredSize());
					storyPanel.repaint();
					storyPanel.validate();
				}

			}

			public void mouseExited(MouseEvent e) {
				startLabel.setLocation(180, 300);
				startLabel.setFont(new Font("PL-Edit", Font.BOLD, 50));
				startLabel.setSize(startLabel.getPreferredSize());
				storyPanel.repaint();
				storyPanel.validate();
			}

			public void mouseClicked(MouseEvent e) {
				FirstPanel.maincards.next(FirstPanel.firstPanel);
				FirstPanel.check = true;
				rightThread = new RightThread();
				leftThread = new LeftThread();
				right = new Thread(rightThread);
				left = new Thread(leftThread);
				right.start();
				left.start();
				new Thread(start).start();
				GameResource.gameBg.loop();
			}
		});
		storyPanel.add(startLabel);
	}

}
