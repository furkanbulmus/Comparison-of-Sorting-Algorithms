import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String selection = "";

		while (!selection.equals("Q")) {
		    System.out.println("Please choose the action you would like to take:");
		    System.out.println("A: Testing of sorting algorithms");
		    System.out.println("B: Times of sorting algorithms");
		    System.out.println("Q: Quit");

		    selection = scanner.nextLine().toUpperCase();
		    System.out.println("");
		    

		    if (selection.equals("A")) {
		        testing();
		        System.out.println("");
		    } else if (selection.equals("B")) {
		        sortTimes();
		        System.out.println("");
		    } else if (selection.equals("Q")) {
		        System.out.println("Exiting the program.");
		    } else {
		        System.out.println("Invalid selection. Please choose again.");
		    }
		}

	}

	public static void testing() {
		SortingClass sort = new SortingClass();

		int[] arr_1 = { 5, 19, 2, 13, 4, 62, 7, 10, 32, 140, 1250, 1 };
		int[] arr_2 = { 3, 24, 16, 74, 195, 58, 14, 6, 240, 1, 12, 7 };
		int[] arr_3 = { 12, 1450, 765, 8, 42, 56, 17, 4, 22, 39, 360, 18 };
		int[] arr_4 = { 36, 1, 250, 92, 67, 6, 35, 5, 42, 78, 11, 9 };
		int[] arr_5 = { 1, 9, 22, 10, 38, 6, 72, 170, 3, 1600, 16, 40 };

		System.out.print("Before sorting: ");
		printArray(arr_1);
		System.out.print("After sorting with merge sort with 2 parts: ");
		sort.merge_sort_2_parts(arr_1, 0, arr_1.length - 1);
		printArray(arr_1);

		System.out.println("");
		System.out.print("Before sorting: ");
		printArray(arr_2);
		System.out.print("After sorting with merge sort with 3 parts: ");
		sort.merge_sort_3_parts(arr_2, 0, arr_2.length - 1);
		printArray(arr_2);

		System.out.println("");
		System.out.print("Before sorting: ");
		printArray(arr_3);
		System.out.print("After sorting with quick sort with pivot is first element: ");
		sort.quick_sort_pivot_first(arr_3, 0, arr_3.length - 1);
		printArray(arr_3);

		System.out.println("");
		System.out.print("Before sorting: ");
		printArray(arr_4);
		System.out.print("After sorting with quick sort with pivot is a random element: ");
		sort.quick_sort_pivot_random(arr_4, 0, arr_4.length - 1);
		printArray(arr_4);

		System.out.println("");
		System.out.print("Before sorting: ");
		printArray(arr_5);
		System.out.print("After sorting with quick sort with pivot is the mid of first - mid - last element: ");
		sort.quick_sort_pivot_mid(arr_5, 0, arr_5.length - 1);
		printArray(arr_5);
		System.out.println("");

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println("");
	}

	public static void sortTimes() {
		SortingClass sort = new SortingClass();
		Random random = new Random();

		int[] arr_eq_1000 = new int[1000];
		int[] arr_eq_10000 = new int[10000];
		int[] arr_eq_100000 = new int[100000];
		int[] arr_rnd_1000 = new int[1000];
		int[] arr_rnd_10000 = new int[10000];
		int[] arr_rnd_100000 = new int[100000];
		int[] arr_inc_1000 = new int[1000];
		int[] arr_inc_10000 = new int[10000];
		int[] arr_inc_100000 = new int[100000];
		int[] arr_dec_1000 = new int[1000];
		int[] arr_dec_10000 = new int[10000];
		int[] arr_dec_100000 = new int[100000];

		for (int i = 0; i < 1000; i++)
			arr_eq_1000[i] = 2;
		for (int i = 0; i < 10000; i++)
			arr_eq_10000[i] = 2;
		for (int i = 0; i < 100000; i++)
			arr_eq_100000[i] = 2;
		for (int i = 0; i < 1000; i++) {
			int rnd = random.nextInt();
			arr_rnd_1000[i] = rnd;
		}
		for (int i = 0; i < 10000; i++) {
			int rnd = random.nextInt();
			arr_rnd_10000[i] = rnd;
		}
		for (int i = 0; i < 100000; i++) {
			int rnd = random.nextInt();
			arr_rnd_100000[i] = rnd;
		}

		int n = 1;

		for (int i = 0; i < 1000; i++)
			arr_inc_1000[i] = n++;

		n = 1;

		for (int i = 0; i < 10000; i++)
			arr_inc_10000[i] = n++;

		n = 1;

		for (int i = 0; i < 100000; i++)
			arr_inc_100000[i] = n++;

		n = 1000;

		for (int i = 0; i < 1000; i++)
			arr_dec_1000[i] = n--;

		n = 10000;

		for (int i = 0; i < 10000; i++)
			arr_dec_10000[i] = n--;

		n = 100000;

		for (int i = 0; i < 100000; i++)
			arr_dec_100000[i] = n--;

		long start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_eq_1000, 0, arr_eq_1000.length - 1);
		long end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 1.000 equal numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_eq_10000, 0, arr_eq_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 10.000 equal numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_2_parts(arr_eq_100000, 0, arr_eq_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out
				.println("Merge sort time with 2 parts for 100.000 equal numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_rnd_1000, 0, arr_rnd_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 1.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_rnd_10000, 0, arr_rnd_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 10.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_2_parts(arr_rnd_100000, 0, arr_rnd_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out
				.println("Merge sort time with 2 parts for 100.000 random numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_inc_1000, 0, arr_inc_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 1.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_inc_10000, 0, arr_inc_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 10.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_2_parts(arr_inc_100000, 0, arr_inc_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Merge sort time with 2 parts for 100.000 increasing numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_dec_1000, 0, arr_dec_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 1.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_2_parts(arr_dec_10000, 0, arr_dec_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 2 parts for 10.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_2_parts(arr_dec_100000, 0, arr_dec_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Merge sort time with 2 parts for 100.000 decreasing numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_eq_1000, 0, arr_eq_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("");
		System.out.println("Merge sort time with 3 parts for 1.000 equal numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_eq_10000, 0, arr_eq_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 10.000 equal numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_3_parts(arr_eq_100000, 0, arr_eq_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out
				.println("Merge sort time with 3 parts for 100.000 equal numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_rnd_1000, 0, arr_rnd_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 1.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_rnd_10000, 0, arr_rnd_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 10.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_3_parts(arr_rnd_100000, 0, arr_rnd_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out
				.println("Merge sort time with 3 parts for 100.000 random numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_inc_1000, 0, arr_inc_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 1.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_inc_10000, 0, arr_inc_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 10.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_3_parts(arr_inc_100000, 0, arr_inc_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Merge sort time with 3 parts for 100.000 increasing numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_dec_1000, 0, arr_dec_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 1.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.merge_sort_3_parts(arr_dec_10000, 0, arr_dec_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Merge sort time with 3 parts for 10.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.merge_sort_3_parts(arr_dec_100000, 0, arr_dec_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Merge sort time with 3 parts for 100.000 decreasing numbers: " + (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_first(arr_eq_1000, 0, arr_eq_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("");
		System.out.println("Quick sort time with the pivot is first element for 1.000 equal numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_eq_10000, 0, arr_eq_10000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 10.000 equal numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_eq_100000, 0, arr_eq_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 100.000 equal numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_first(arr_rnd_1000, 0, arr_rnd_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is first element for 1.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_rnd_10000, 0, arr_rnd_10000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 10.000 random numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_rnd_100000, 0, arr_rnd_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 100.000 random numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_first(arr_inc_1000, 0, arr_inc_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is first element for 1.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_inc_10000, 0, arr_inc_10000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 10.000 increasing numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_inc_100000, 0, arr_inc_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 100.000 increasing numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_first(arr_dec_1000, 0, arr_dec_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is first element for 1.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_dec_10000, 0, arr_dec_10000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 10.000 decreasing numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_first(arr_dec_100000, 0, arr_dec_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is first element for 100.000 decreasing numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_eq_1000, 0, arr_eq_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("");
		System.out.println("Quick sort time with the pivot is a random element for 1.000 equal numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_random(arr_eq_10000, 0, arr_eq_10000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is a random element for 10.000 equal numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_random(arr_eq_100000, 0, arr_eq_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is a random element for 100.000 equal numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_rnd_1000, 0, arr_rnd_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is a random element for 1.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_rnd_10000, 0, arr_rnd_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is a random element for 10.000 random numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_random(arr_rnd_100000, 0, arr_rnd_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is a random element for 100.000 random numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_inc_1000, 0, arr_inc_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is a random element for 1.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_inc_10000, 0, arr_inc_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is a random element for 10.000 increasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_random(arr_inc_100000, 0, arr_inc_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is a random element for 100.000 increasing numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_dec_1000, 0, arr_dec_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is a random element for 1.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_random(arr_dec_10000, 0, arr_dec_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println("Quick sort time with the pivot is a random element for 10.000 decreasing numbers: "
				+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_random(arr_dec_100000, 0, arr_dec_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println("Quick sort time with the pivot is a random element for 100.000 decreasing numbers: "
				+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_eq_1000, 0, arr_eq_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println("");
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 1.000 equal numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_mid(arr_eq_10000, 0, arr_eq_10000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 10.000 equal numbers: "
						+ (end_time - start_time) + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_mid(arr_eq_100000, 0, arr_eq_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 100.000 equal numbers: "
						+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_rnd_1000, 0, arr_rnd_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 1.000 random numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_rnd_10000, 0, arr_rnd_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 10.000 random numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 10.0) / 10.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_mid(arr_rnd_100000, 0, arr_rnd_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 100.000 random numbers: "
						+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_inc_1000, 0, arr_inc_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 1.000 increasing numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_inc_10000, 0, arr_inc_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 10.000 increasing numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_mid(arr_inc_100000, 0, arr_inc_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 100.000 increasing numbers: "
						+ (end_time - start_time) + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_dec_1000, 0, arr_dec_1000.length - 1);
		end_time = System.nanoTime();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 1.000 decreasing numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.nanoTime();
		sort.quick_sort_pivot_mid(arr_dec_10000, 0, arr_dec_10000.length - 1);
		end_time = System.nanoTime();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 10.000 decreasing numbers: "
						+ Math.round(((end_time - start_time) / 1000000.0) * 100.0) / 100.0 + " ms");

		start_time = System.currentTimeMillis();
		sort.quick_sort_pivot_mid(arr_dec_100000, 0, arr_dec_100000.length - 1);
		end_time = System.currentTimeMillis();
		System.out.println(
				"Quick sort time with the pivot is the mid of first - mid - last element for 100.000 decreasing numbers: "
						+ (end_time - start_time) + " ms");

	}

}
