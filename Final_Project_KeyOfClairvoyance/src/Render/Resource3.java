package Render;

//HighScore Panel...

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Resource3 {

	public static BufferedImage bg;
	public static BufferedImage img;
	public static BufferedImage img2;
	public static BufferedImage img3;
	public static BufferedImage img4;
	public static BufferedImage img5;
	public static BufferedImage img6;
	public static BufferedImage img7;
	public static BufferedImage img8;
	public static AudioClip clip;
	public static AudioClip clip2;

	static {
		try {
			ClassLoader loader = Resource3.class.getClassLoader();
			img = ImageIO.read(loader.getResource("res/img/exit.png"));
			img2 = ImageIO.read(loader.getResource("res/img/exit2.png"));
			img3 = ImageIO.read(loader.getResource("res/img/single.png"));
			img4 = ImageIO.read(loader.getResource("res/img/single2.png"));
			img5 = ImageIO.read(loader.getResource("res/img/single3.png"));
			img6 = ImageIO.read(loader.getResource("res/img/endless.png"));
			img7 = ImageIO.read(loader.getResource("res/img/endless2.png"));
			img8 = ImageIO.read(loader.getResource("res/img/endless3.png"));
			bg = ImageIO.read(loader.getResource("res/img/highscorebg.png"));
			clip = Applet.newAudioClip(loader.getResource("res/sound/click3.wav").toURI().toURL());
			clip2 = Applet.newAudioClip(loader.getResource("res/sound/click5.wav").toURI().toURL());
		} catch (IOException e) {
			System.out.println("IMG NOT FOUND");
		} catch (URISyntaxException e) {
			System.out.println("SOUND NOT FOUND");
		}
	}

}
