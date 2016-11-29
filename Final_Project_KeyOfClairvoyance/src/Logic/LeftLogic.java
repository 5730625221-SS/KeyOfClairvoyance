package Logic;

import java.util.ArrayList;

import Render.InputUtility;
import Render.LeftRenderObj;
import Render.GameResource;
import UI.GameScreen;
import UI.GameWindow;
import UI.Key;
import UI.ModePanel;
import UI.Start;

public class LeftLogic {

	private static LeftLogic instance = new LeftLogic();;

	protected ArrayList<Key> keys = new ArrayList<>();
	private static int SPAWN_DELAY = 60;

	private int spawnDelayCounter = 0;

	public static LeftLogic getInstance() {
		return instance;
	}

	public void logicUpdate() {
		synchronized (GameWindow.x) {
			if (GameWindow.stop == true) {
				try {
					GameWindow.x.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			if (InputUtility.getKeyTriggered(GameResource.key[i]) && GameResource.keyNo[i] == 0) {
				if (ModePanel.mode == 2) {
					Start.decreaseTime(3);
					GameScreen.gameTime.setText(Start.getTime() + "");
				}
				GameScreen.decreaseScore(2);
				GameScreen.reScore();
				InputUtility.setKeyTriggered(GameResource.key[i], false);
				InputUtility.setKeyPressed(GameResource.key[i], false);
			}
		}
		for (int i = 0; i < keys.size(); i++) {
			Key key = keys.get(i);

			if (InputUtility.getKeyTriggered(GameResource.key[key.i])) {
				key.destroyed = true;
				if (ModePanel.mode == 2) {
					Start.increaseTime(2);
					GameScreen.gameTime.setText(Start.getTime() + "");
				}
				GameScreen.increaseScore(2);
				GameScreen.reScore();
				synchronized (LeftRenderObj.getInstance().getRenderableList()) {
					LeftRenderObj.getInstance().getRenderableList().remove(key);
				}
				keys.remove(i);
				GameResource.keyNo[key.i]--;
				InputUtility.setKeyTriggered(GameResource.key[key.i], false);
				InputUtility.setKeyPressed(GameResource.key[key.i], false);
				continue;
			}

			if (!key.isDestroyed()) {
				key.update();
			} else {
				synchronized (LeftRenderObj.getInstance().getRenderableList()) {
					LeftRenderObj.getInstance().getRenderableList().remove(key);
				}
				keys.remove(i);
				GameResource.keyNo[key.i]--;
				GameScreen.decreaseScore(1);
				GameScreen.reScore();
				if (ModePanel.mode == 2) {
					Start.decreaseTime(1);
					GameScreen.gameTime.setText(Start.getTime() + "");
				}
			}
		}

		spawnDelayCounter++;

		if (spawnDelayCounter >= SPAWN_DELAY)

		{
			Key ap = new Key();
			keys.add(ap);
			LeftRenderObj.getInstance().add(ap);
			spawnDelayCounter = 0;
		}
	}

	public void clearKey() {
		for (int i = 0; i < keys.size(); i++) {
			keys.remove(i);
		}

		for (int x = 0; x < LeftRenderObj.getInstance().getRenderableList().size(); x += 0) {
			LeftRenderObj.getInstance().getRenderableList().remove(x);
		}

		for (int i = 0; i < 4; i++) {
			GameResource.keyNo[i] = 0;
		}
	}

	public static int getSPAWN_DELAY() {
		return SPAWN_DELAY;
	}

	public static void setSPAWN_DELAY(int delay) {
		if (delay <= 20)
			delay = 20;
		SPAWN_DELAY = delay;
	}

}
