package Render;

// Main Panel...

import java.applet.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Resource {

	public static BufferedImage img;
	public static BufferedImage img2;
	public static BufferedImage img3;
	public static BufferedImage img4;
	public static BufferedImage img5;
	public static BufferedImage img6;
	public static BufferedImage img7;
	public static BufferedImage img8;
	public static BufferedImage img9;
	public static BufferedImage img10;
	public static BufferedImage img11;
	public static BufferedImage img12;
	public static BufferedImage img13;
	public static BufferedImage img14;
	public static BufferedImage bg;
	public static BufferedImage tri;
	public static BufferedImage nullimage;
	public static AudioClip clip;
	public static AudioClip clip2;
	public static AudioClip soundbg;
	public static AudioClip exit;

	static {
		try {

			ClassLoader loader = Resource.class.getClassLoader();
			img = ImageIO.read(loader.getResource("res/img/startgame.png"));
			img2 = ImageIO.read(loader.getResource("res/img/startgame2.png"));
			img3 = ImageIO.read(loader.getResource("res/img/highscore.png"));
			img4 = ImageIO.read(loader.getResource("res/img/highscore2.png"));
			img5 = ImageIO.read(loader.getResource("res/img/info.png"));
			img6 = ImageIO.read(loader.getResource("res/img/info2.png"));
			img7 = ImageIO.read(loader.getResource("res/img/setting.png"));
			img8 = ImageIO.read(loader.getResource("res/img/setting2.png"));
			img9 = ImageIO.read(loader.getResource("res/img/howtoplay.png"));
			img10 = ImageIO.read(loader.getResource("res/img/howtoplay2.png"));
			img11 = ImageIO.read(loader.getResource("res/img/sound.png"));
			img12 = ImageIO.read(loader.getResource("res/img/sound2.png"));
			img13 = ImageIO.read(loader.getResource("res/img/mute.png"));
			img14 = ImageIO.read(loader.getResource("res/img/mute2.png"));
			tri = ImageIO.read(loader.getResource("res/img/test.png"));
			nullimage = ImageIO.read(loader.getResource("res/img/nullimage.png"));
			bg = ImageIO.read(loader.getResource("res/img/bg.png"));
			clip = Applet.newAudioClip(loader.getResource("res/sound/click.wav").toURI().toURL());
			clip2 = Applet.newAudioClip(loader.getResource("res/sound/click2.wav").toURI().toURL());
			soundbg = Applet.newAudioClip(loader.getResource("res/sound/soundbg.wav").toURI().toURL());
			exit = Applet.newAudioClip(loader.getResource("res/sound/exit.wav").toURI().toURL());

		} catch (IOException e) {
			System.out.println("IMG NOT FOUND");
		} catch (URISyntaxException e) {
			System.out.println("SOUND NOT FOUND");
		}
	}

}
