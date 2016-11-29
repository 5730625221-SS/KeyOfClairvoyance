package Render;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class GameResource {

	public static BufferedImage c1;
	public static BufferedImage c2;
	public static BufferedImage c3;
	public static BufferedImage c4;
	public static BufferedImage c[] = new BufferedImage[4];
	public static BufferedImage bg;
	public static BufferedImage bg2;
	public static BufferedImage nbg;
	public static BufferedImage pause;
	public static BufferedImage nullpause;
	public static BufferedImage img01;
	public static BufferedImage img02;
	public static BufferedImage img03;
	public static BufferedImage img04;
	public static AudioClip keyPress;
	public static AudioClip circleClick;
	public static AudioClip gameBg;
	public static int[] key = { KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_W };
	public static int[] keyNo = { 0, 0, 0, 0 };
	public static Font defaultFont = new Font("PL-EDIT", Font.BOLD + Font.ITALIC, 60);
	public static Font highscoreFont = new Font("PL-EDIT", Font.PLAIN, 50);
	public static Font storyFont = new Font("PL-EDIT", Font.BOLD, 50);

	static {
		try {
			ClassLoader loader = GameResource.class.getClassLoader();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			c1 = ImageIO.read(loader.getResource("res/img/keyA.png"));
			c2 = ImageIO.read(loader.getResource("res/img/keyS.png"));
			c3 = ImageIO.read(loader.getResource("res/img/keyD.png"));
			c4 = ImageIO.read(loader.getResource("res/img/keyW.png"));
			img01 = ImageIO.read(loader.getResource("res/img/number1.png"));
			img02 = ImageIO.read(loader.getResource("res/img/number2.png"));
			img03 = ImageIO.read(loader.getResource("res/img/number3.png"));
			img04 = ImageIO.read(loader.getResource("res/img/number4.png"));
			c4 = ImageIO.read(loader.getResource("res/img/keyW.png"));
			c4 = ImageIO.read(loader.getResource("res/img/keyW.png"));
			bg = ImageIO.read(loader.getResource("res/img/leftbg.png"));
			nbg = ImageIO.read(loader.getResource("res/img/playerstatus.png"));
			bg2 = ImageIO.read(loader.getResource("res/img/rightbg.png"));
			pause = ImageIO.read(loader.getResource("res/img/pause.png"));
			nullpause = ImageIO.read(loader.getResource("res/img/nullpause.png"));
			keyPress = Applet.newAudioClip(loader.getResource("res/sound/keypress.wav").toURI().toURL());
			circleClick = Applet.newAudioClip(loader.getResource("res/sound/circleclick.wav").toURI().toURL());
			gameBg = Applet.newAudioClip(loader.getResource("res/sound/gamebg.wav").toURI().toURL());
			c[0] = c1;
			c[1] = c2;
			c[2] = c3;
			c[3] = c4;
			String fileName = "res/font/PL-EDIT.ttf";
			InputStream in = loader.getResourceAsStream(fileName);
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, in));
		} catch (IOException e) {
			System.out.println("IMG NOT FOUND");
		} catch (URISyntaxException e) {
			System.out.println("SOUND NOT FOUND");
		} catch (FontFormatException e) {
			System.out.println("FONT NOT FOUND");
		}
	}

}
