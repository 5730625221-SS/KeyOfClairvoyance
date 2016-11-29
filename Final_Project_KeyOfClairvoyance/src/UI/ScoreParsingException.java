package UI;

@SuppressWarnings("serial")
public class ScoreParsingException extends Exception {

	private int errorType;

	public ScoreParsingException(int errorType) {
		this.errorType = errorType;
	}

	@Override
	public String getMessage() {
		if (errorType == 0)
			return "No record score.";
		else
			return "Wrong record format.";
	}

}
