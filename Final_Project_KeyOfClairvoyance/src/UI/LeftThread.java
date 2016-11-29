package UI;

import Logic.LeftLogic;

public class LeftThread implements Runnable {
	public LeftLogic logic = new LeftLogic();

	@Override
	public void run() {
		LeftManager.run(logic);
	}
}
