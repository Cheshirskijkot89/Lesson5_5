package chizhenko;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int n;
		int count;
		int min;
		int max;
		int constMin;
		int constMax;
		int now;
		int before;
		int rows;
		int delta;

		int[][] myArray;
		Scanner sc = new Scanner(System.in);

		System.out.println("¬ведите размер массива");

		n = sc.nextInt();

		sc.close();

		count = (int) n / 2;

		myArray = new int[n][n];

		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray[i].length; j++) {
				myArray[i][j] = j + 1;
			}

			System.out.println(Arrays.toString(myArray[i]));
		}

		System.out.println();

		for (int x = 1; x <= 3; x++) {

			constMax = n - 1;
			constMin = 0;
			max = n - 1;
			min = 0;
			before = 0;
			rows = n - 1;
			delta = 0;

			for (int i = 1; i <= count; i++) {

				for (int j = 1; j <= rows; j = j + 1) {

					for (int k = 1; k <= 5; k++) {

						if (k == 1) {
							before = myArray[constMin][min];
						} else if (k == 2) {
							now = myArray[min][constMax];
							myArray[min][constMax] = before;
							before = now;
						} else if (k == 3) {
							now = myArray[constMax][max];
							myArray[constMax][max] = before;
							before = now;
						} else if (k == 4) {
							now = myArray[max][constMin];
							myArray[max][constMin] = before;
							before = now;
						} else if (k == 5) {
							// now = myArray[max][constMin];
							myArray[constMin][min] = before;
							// before = now;
						}

					}

					max = max - 1;
					min = min + 1;
				}

				rows = rows - 2;
				delta = delta + 1;
				min = 0 + delta;
				constMin = 0 + delta;
				max = n - 1 - delta;
				constMax = n - 1 - delta;
			}
			
			if (x==1) {
				System.out.println("90 degrees");
			} else if (x==2) {
				System.out.println("180 degrees");
			} else if (x==3) {
				System.out.println("270 degrees");
			}
			
			for (int i = 0; i < myArray.length; i++) {
				System.out.println(Arrays.toString(myArray[i]));
			}
			
			System.out.println();

		}

	}

}
