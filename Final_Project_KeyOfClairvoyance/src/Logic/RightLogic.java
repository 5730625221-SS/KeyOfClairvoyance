package Logic;

import Render.RightRenderObj;
import UI.Four;
import UI.GameScreen;
import UI.GameWindow;
import UI.ModePanel;
import UI.One;
import UI.RightDrawer;
import UI.RightManager;
import UI.Start;
import UI.Three;
import UI.Two;

public class RightLogic {

	public static boolean[] next = { false, false, false, false };
	public static boolean clear = false;
	public static int time = 0;

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

		if (RightRenderObj.getInstance().getRenderableList().size() == 0) {
			time = 501;
		}

		time++;

		if (time > 500) {
			if (ModePanel.mode == 2) {
				LeftLogic.setSPAWN_DELAY(LeftLogic.getSPAWN_DELAY() - 2);
				Start.decreaseTime(1);
				GameScreen.gameTime.setText(Start.getTime() + "");
			}
			clear = true;
			GameScreen.decreaseScore(5);
			GameScreen.reScore();
			time = 0;
		}

		if (clear) {
			synchronized (RightRenderObj.getInstance().getRenderableList()) {
				for (int x = 0; x < RightRenderObj.getInstance().getRenderableList().size(); x += 0) {
					RightRenderObj.getInstance().getRenderableList().remove(x);
				}
			}
			for (int i = 0; i < 4; i++)
				next[i] = false;
			int PositionObj[] = RandomUtility.randomObj();

			RightRenderObj.getInstance().add(new One(PositionObj[0], PositionObj[1]));
			RightRenderObj.getInstance().add(new Two(PositionObj[2], PositionObj[3]));
			RightRenderObj.getInstance().add(new Three(PositionObj[4], PositionObj[5]));
			RightRenderObj.getInstance().add(new Four(PositionObj[6], PositionObj[7]));

			clear = false;
		}

		int i = RightRenderObj.getInstance().getRenderableList().size();

		int check = 99;

		for (int j = 0; j < i; j++) {
			if (((RightDrawer) RightRenderObj.getInstance().getRenderableList().get(j)).collideWith(RightManager.x,
					RightManager.y)) {
				check = j;
				RightManager.x = -1;
				RightManager.y = -1;
			}
		}

		if (check <= i) {
			if (RightRenderObj.getInstance().getRenderableList().get(check) instanceof One) {
				if (next[0] == false) {
					synchronized (RightRenderObj.getInstance().getRenderableList()) {
						RightRenderObj.getInstance().getRenderableList().remove(check);
					}
					next[0] = true;
					if (ModePanel.mode == 2) {
						Start.increaseTime(1);
						GameScreen.gameTime.setText(Start.getTime() + "");
					}
					GameScreen.increaseScore(1);
					GameScreen.reScore();
					i--;

				}
			} else if (RightRenderObj.getInstance().getRenderableList().get(check) instanceof Two) {
				if (next[0] == true) {
					synchronized (RightRenderObj.getInstance().getRenderableList()) {
						RightRenderObj.getInstance().getRenderableList().remove(check);
					}
					next[1] = true;
					if (ModePanel.mode == 2) {
						Start.increaseTime(1);
						GameScreen.gameTime.setText(Start.getTime() + "");
					}
					GameScreen.increaseScore(1);
					GameScreen.reScore();
					i--;

				} else {
					GameScreen.decreaseScore(1);
					GameScreen.reScore();
				}
			} else if (RightRenderObj.getInstance().getRenderableList().get(check) instanceof Three) {
				if (next[1] == true) {
					synchronized (RightRenderObj.getInstance().getRenderableList()) {
						RightRenderObj.getInstance().getRenderableList().remove(check);
					}
					next[2] = true;
					if (ModePanel.mode == 2) {
						Start.increaseTime(1);
						GameScreen.gameTime.setText(Start.getTime() + "");
					}
					GameScreen.increaseScore(1);
					GameScreen.reScore();
					i--;
				} else {
					GameScreen.decreaseScore(1);
					GameScreen.reScore();
				}
			} else if (RightRenderObj.getInstance().getRenderableList().get(check) instanceof Four) {
				if (next[2] == true) {
					synchronized (RightRenderObj.getInstance().getRenderableList()) {
						RightRenderObj.getInstance().getRenderableList().remove(check);
					}

					next[3] = true;
					if (ModePanel.mode == 2) {
						Start.increaseTime(5);
						GameScreen.gameTime.setText(Start.getTime() + "");
					}
					GameScreen.increaseScore(5);
					GameScreen.reScore();
					i--;
				} else {
					GameScreen.decreaseScore(1);
					GameScreen.reScore();
				}
			}

		}
		if (i == -100) {
			synchronized (RightRenderObj.getInstance().getRenderableList()) {
				for (int x = 0; x < RightRenderObj.getInstance().getRenderableList().size(); x += 0) {
					RightRenderObj.getInstance().getRenderableList().remove(x);
				}
			}
		}
	}

}
