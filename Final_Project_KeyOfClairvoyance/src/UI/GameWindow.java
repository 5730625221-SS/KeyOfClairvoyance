package UI;

import javax.swing.*;

import Render.InputUtility;
import Render.GameResource;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	public JPanel scence;
	// Synchronized Object...
	public static Object x = "";
	public static boolean stop = false;

	public GameWindow(JPanel scence) {
		super("Key of Clairvoyance");
		getContentPane().setPreferredSize(new Dimension(960, 720));
		setLocation(450, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.scence = scence;
		getContentPane().add(this.scence);
		pack();
		requestFocus();
		setFocusable(true);
		addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				InputUtility.setKeyPressed(e.getKeyCode(), false);
				InputUtility.setKeyTriggered(e.getKeyCode(), false);
			}

			public void keyPressed(KeyEvent e) {
				if (InputUtility.getKeyPressed(e.getKeyCode()) == false) {
					InputUtility.setKeyTriggered(e.getKeyCode(), true);
					if (FirstPanel.check) {
						if ((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_W
								|| e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D) && stop == false)
							GameResource.keyPress.play();
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							if (stop == false) {
								stop = true;
								GameScreen.pause.setIcon(new ImageIcon(GameResource.pause));
								GameResource.gameBg.stop();
							} else
								synchronized (x) {
									x.notifyAll();
									stop = false;
									GameScreen.pause.setIcon(new ImageIcon(GameResource.nullpause));
									GameResource.gameBg.play();
								}
						}
					}
				} else
					InputUtility.setKeyTriggered(e.getKeyCode(), false);
				InputUtility.setKeyPressed(e.getKeyCode(), true);
			}
		});
		setVisible(true);
	}

}
