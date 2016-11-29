package Logic;

import java.util.Random;

public class RandomUtility {

	public static int random(int s, int e) {
		return (new Random()).nextInt(e - s) + s;
	}

	public static int[] randomObj() {
		int obj[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int z = 0; z < 8; z += 2) {

			obj[z] = (int) (Math.random() * 380);
			obj[z + 1] = (int) (Math.random() * 480);

			for (int zz = 0; zz < z; zz += 2) {
				if (obj[z] >= obj[zz] && obj[z] <= obj[zz] + 100 && obj[z + 1] >= obj[zz + 1]
						&& obj[z + 1] <= obj[zz + 1] + 100) {
					z -= 2;
					break;
				} else if (obj[z] + 100 >= obj[zz] && obj[z] + 100 <= obj[zz] + 100 && obj[z + 1] >= obj[zz + 1]
						&& obj[z + 1] <= obj[zz + 1] + 100) {
					z -= 2;
					break;
				} else if (obj[z] >= obj[zz] && obj[z] <= obj[zz] + 100 && obj[z + 1] + 100 >= obj[zz + 1]
						&& obj[z + 1] + 100 <= obj[zz + 1] + 100) {
					z -= 2;
					break;
				} else if (obj[z] + 100 >= obj[zz] && obj[z] + 100 <= obj[zz] + 100 && obj[z + 1] + 100 >= obj[zz + 1]
						&& obj[z + 1] + 100 <= obj[zz + 1] + 100) {
					z -= 2;
					break;
				}
			}
		}
		return obj;
	}

}
