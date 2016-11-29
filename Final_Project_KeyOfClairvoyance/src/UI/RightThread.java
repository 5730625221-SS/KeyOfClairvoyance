package UI;

import Logic.RightLogic;

public class RightThread implements Runnable {

	public RightLogic logic = new RightLogic();

	@Override
	public void run() {
		RightManager.run(logic);
	}

}
