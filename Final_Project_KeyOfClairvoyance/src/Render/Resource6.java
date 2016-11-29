package Render;

//HowToPlay Panel...

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class Resource6 {

	public static BufferedImage bg;
	public static BufferedImage img;
	public static BufferedImage img2;
	public static BufferedImage img3;
	public static BufferedImage img4;
	public static BufferedImage htp1;
	public static BufferedImage htp2;
	public static BufferedImage htp3;
	public static BufferedImage htp4;
	public static BufferedImage htp5;
	public static BufferedImage htp6;
	public static BufferedImage htp7;
	public static BufferedImage htp8;
	public static BufferedImage htp9;
	public static BufferedImage[] im = new BufferedImage[9];
	public static AudioClip clip;
	public static AudioClip clip2;

	static {
		try {
			ClassLoader loader = Resource6.class.getClassLoader();
			img = ImageIO.read(loader.getResource("res/img/normalsize.png"));
			img2 = ImageIO.read(loader.getResource("res/img/normalsize2.png"));
			img3 = ImageIO.read(loader.getResource("res/img/previous.png"));
			img4 = ImageIO.read(loader.getResource("res/img/next.png"));
			htp1 = ImageIO.read(loader.getResource("res/img/htp1.png"));
			htp2 = ImageIO.read(loader.getResource("res/img/htp2.png"));
			htp3 = ImageIO.read(loader.getResource("res/img/htp3.png"));
			htp4 = ImageIO.read(loader.getResource("res/img/htp4.png"));
			htp5 = ImageIO.read(loader.getResource("res/img/htp5.png"));
			htp6 = ImageIO.read(loader.getResource("res/img/htp6.png"));
			htp7 = ImageIO.read(loader.getResource("res/img/htp7.png"));
			htp8 = ImageIO.read(loader.getResource("res/img/htp8.png"));
			htp9 = ImageIO.read(loader.getResource("res/img/htp9.png"));
			bg = ImageIO.read(loader.getResource("res/img/howtoplaybg.png"));
			clip = Applet.newAudioClip(loader.getResource("res/sound/click3.wav").toURI().toURL());
			clip2 = Applet.newAudioClip(loader.getResource("res/sound/click4.wav").toURI().toURL());
			im[0] = htp1;
			im[1] = htp2;
			im[2] = htp3;
			im[3] = htp4;
			im[4] = htp5;
			im[5] = htp6;
			im[6] = htp7;
			im[7] = htp8;
			im[8] = htp9;
		} catch (IOException e) {
			System.out.println("IMG NOT FOUND");
		} catch (URISyntaxException e) {
			System.out.println("SOUND NOT FOUND");
		}
	}

}
