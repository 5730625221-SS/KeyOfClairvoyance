package Render;

//Mode Panel...

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource2 {

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

	static {
		try {
			ClassLoader loader = Resource2.class.getClassLoader();
			img = ImageIO.read(loader.getResource("res/img/exit.png"));
			img2 = ImageIO.read(loader.getResource("res/img/exit2.png"));
			img3 = ImageIO.read(loader.getResource("res/img/singlepane.png"));
			img4 = ImageIO.read(loader.getResource("res/img/singlepane2.png"));
			img5 = ImageIO.read(loader.getResource("res/img/endlesspane.png"));
			img6 = ImageIO.read(loader.getResource("res/img/endlesspane2.png"));
			bg = ImageIO.read(loader.getResource("res/img/modebg.png"));
			clip = Applet.newAudioClip(loader.getResource("res/sound/click3.wav").toURI().toURL());
		} catch (Exception e) {
			System.out.println("FILE NOT FOUND");
		}
	}

}
