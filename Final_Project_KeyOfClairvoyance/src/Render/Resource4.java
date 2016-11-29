package Render;

//Setting Panel...

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Resource4 {

	public static BufferedImage bg;
	public static BufferedImage img;
	public static BufferedImage img2;
	public static AudioClip clip;

	static {
		try {
			ClassLoader loader = Resource4.class.getClassLoader();
			img = ImageIO.read(loader.getResource("res/img/normalsize.png"));
			img2 = ImageIO.read(loader.getResource("res/img/normalsize2.png"));
			bg = ImageIO.read(loader.getResource("res/img/settingbg.png"));
			clip = Applet.newAudioClip(loader.getResource("res/sound/click3.wav").toURI().toURL());
		} catch (IOException e) {
			System.out.println("IMG NOT FOUND");
		} catch (URISyntaxException e) {
			System.out.println("SOUND NOT FOUND");
		}
	}

}
