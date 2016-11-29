package Render;

public class InputUtility {

	private static boolean[] keyPressed = new boolean[256];
	private static boolean[] keyTriggered = new boolean[256];

	public static boolean getKeyPressed(int key) {
		if (key >= 0 && key < 256)
			return keyPressed[key];
		else
			return false;
	}

	public static void setKeyPressed(int key, boolean pressed) {
		if (key >= 0 && key < 256)
			keyPressed[key] = pressed;
		else
			return;
	}

	public static boolean getKeyTriggered(int key) {
		if (key >= 0 && key < 256)
			return keyTriggered[key];
		else
			return false;
	}

	public static void setKeyTriggered(int key, boolean pressed) {
		if (key >= 0 && key < 256)
			keyTriggered[key] = pressed;
		else
			return;
	}

}
