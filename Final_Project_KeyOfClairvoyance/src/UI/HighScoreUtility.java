package UI;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class HighScoreUtility {

	public static class HighScoreRecord implements Comparable<HighScoreRecord> {
		private String name = "";
		private int score = 0;

		public HighScoreRecord(String name, int score) {
			this.name = name;
			this.score = score;
		}

		public HighScoreRecord(String record) throws ScoreParsingException {
			int indexS = record.lastIndexOf(" ");
			if (indexS == -1)
				throw new ScoreParsingException(1);
			else if (indexS == 0) {
				name = "";
			} else
				name = record.substring(0, indexS);
			try {
				score = Integer.parseInt(record.substring(indexS + 1));
			} catch (Exception e) {
				throw new ScoreParsingException(0);
			}
		}

		private String getRecord() {
			return name.trim() + " " + score;
		}

		private static String[] defaultRecord() {
			return new String[] { "Mr.A 500", "Mr.B 400", "Mr.C 300", "Mr.D 200", "Mr.E 100" };
		}

		@Override
		public int compareTo(HighScoreRecord o) {
			if (this.score < o.score)
				return 1;
			else if (this.score > o.score)
				return -1;
			else
				return 0;
		}

	}

	private static HighScoreRecord[] highScoreRecord = null;

	private static String readFileName = "highscore";

	/*
	 * Display player's score and record if the player rank is 10 or higher.
	 */

	public static void recordHighScore(int score) {
		if (!loadHighScore() || highScoreRecord == null) {
			JOptionPane.showMessageDialog(null, "Error loading highscore record", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int index = highScoreRecord.length;
		for (int i = 0; i < highScoreRecord.length; i++) {
			if (score > highScoreRecord[i].score) {
				index = i;
				break;
			}
		}
		if (index >= highScoreRecord.length) {
			String yourScore = "Game over\nYour score is " + score;
			JOptionPane.showMessageDialog(null, yourScore, "Gameover", JOptionPane.INFORMATION_MESSAGE);
		} else {
			for (int i = highScoreRecord.length - 1; i >= index + 1; i--) {
				highScoreRecord[i] = highScoreRecord[i - 1];
			}

			String yourRank = "Congratulation, you are ranked " + (index + 1) + "\nPlease enter your name";
			String playerName = JOptionPane.showInputDialog(null, yourRank, "High score",
					JOptionPane.INFORMATION_MESSAGE);

			try {
				highScoreRecord[index] = new HighScoreRecord(playerName + " " + score);
			} catch (ScoreParsingException e) {
				e.printStackTrace();
			}

			try {

				BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
				String writeRecord = "";
				for (int i = 0; i < highScoreRecord.length; i++) {
					writeRecord += highScoreRecord[i].getRecord() + "\n";
				}
				out.write(getXORed(writeRecord));
				out.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error saving high score record", "Error",
						JOptionPane.ERROR_MESSAGE);
				highScoreRecord = null;
				return;
			}
		}
	}

	public static String displayTop5(int rank) {
		if (!loadHighScore() || highScoreRecord == null) {
			JOptionPane.showMessageDialog(null, "Error loading highscore record", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		String msg = (rank + 1) + ". " + highScoreRecord[rank].getRecord() + " pts.";
		return msg;
	}

	private static boolean loadHighScore() {
		File f = new File(readFileName);
		// If no high score, create default
		if (!f.exists()) {
			if (!createDefaultScoreFile())
				return false;
		}
		// Read high score -- if fail: delete the file, create default one and
		// read it again
		if (!readAndParseScoreFile(f)) {
			f.delete();
			if (!createDefaultScoreFile())
				return false;
			return readAndParseScoreFile(f);
		}
		return true;

	}

	private static boolean readAndParseScoreFile(File f) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			// String line;
			highScoreRecord = new HighScoreRecord[5];
			String str = "";
			int c;
			while ((c = in.read()) != -1) {
				str += (char) c;
			}
			in.close();
			String[] records = getXORed(str).split("\n");
			for (int i = 0; i < highScoreRecord.length; i++) {
				try {
					highScoreRecord[i] = new HighScoreRecord(records[i]);
				} catch (ScoreParsingException e) {
					System.err.println("Error parsing line " + (i + 1) + ", " + e.getMessage());
					highScoreRecord[i] = new HighScoreRecord("ERROR_RECORD", 0);
				}
			}
			Arrays.sort(highScoreRecord);
			return true;
		} catch (Exception e) {
			highScoreRecord = null;
		}
		return false;
	}

	private static boolean createDefaultScoreFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
			String str = "";
			for (String s : HighScoreRecord.defaultRecord()) {
				str += s + "\n";
			}
			str = str.trim();
			out.write(getXORed(str));
			out.close();
			return true;
		} catch (IOException e1) {
			highScoreRecord = null;
			return false;
		}
	}

	private static final byte[] key = "RmAAq2b5d8fjgu9dhher".getBytes();

	// This method does both encryption and decryption

	private static String getXORed(String in) {
		byte[] inData = in.getBytes();
		int j = 0;
		for (int i = 0; i < inData.length; i++) {
			if (j >= key.length)
				j = 0;
			inData[i] = (byte) (inData[i] ^ key[j]);
			j++;
		}

		return new String(inData);

	}

	public static void setReadFileName(String name) {
		readFileName = name;
	}

}
