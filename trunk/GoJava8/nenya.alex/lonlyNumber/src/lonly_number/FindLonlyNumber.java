package lonly_number;

import java.util.Arrays;

public class FindLonlyNumber {

	public int findLonly(int[] mas) throws EmptyArrayException {
		if (mas != null) {
			if (mas.length != 0) {
				Arrays.sort(mas);

				if (mas[0] != mas[1]) {
					return mas[0];
				}
				if (mas[mas.length - 2] != mas[mas.length - 1]) {
					return mas[mas.length - 1];
				}
				for (int i = 1; i < mas.length - 1; i++) {
					if (mas[i] != mas[i - 1] && mas[i] != mas[i + 1]) {
						return mas[i];
					}
				}

			}else{
				throw new EmptyArrayException();
			}
		} else {
			throw new NullPointerException();
		}
		return 0;

		
	}
}
