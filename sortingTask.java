package data_final;

import java.util.Random;

public class sortingTask {

	public static void main(String[] args) {

		long mergeTimeArray[] = new long[6];
		long selectionTimeArray[] = new long[6];
		long start;
		long finish;
		long result;

		int sortedSmall[] = new int[100000];
		int sortedLarg[] = new int[1000000];
		fillSortedArray(sortedSmall);
		fillSortedArray(sortedLarg);

		// using the merge sort
		start = System.currentTimeMillis();
		mergeSort(sortedSmall, 0, sortedSmall.length - 1);
		finish = System.currentTimeMillis();
		result = finish - start;
		mergeTimeArray[0] = result;

		start = System.currentTimeMillis();
		mergeSort(sortedLarg, 0, sortedLarg.length - 1);
		finish = System.currentTimeMillis();
		result = finish - start;
		mergeTimeArray[1] = result;

		// using the selection sort
		start = System.currentTimeMillis();
		selection(sortedSmall);
		finish = System.currentTimeMillis();
		result = finish - start;
		selectionTimeArray[0] = result;

		start = System.currentTimeMillis();
		selection(sortedLarg);
		finish = System.currentTimeMillis();
		result = finish - start;
		selectionTimeArray[1] = result;

		// -------------------------------------------

		int randomSmall[] = new int[100000];
		int randomLarg[] = new int[1000000];
		fillRandomArray(randomSmall);
		fillRandomArray(randomLarg);

		// using the merge sort
		start = System.currentTimeMillis();
		mergeSort(randomSmall, 0, randomSmall.length - 1);
		finish = System.currentTimeMillis();
		result = finish - start;
		mergeTimeArray[2] = result;

		start = System.currentTimeMillis();
		mergeSort(randomLarg, 0, randomLarg.length - 1);
		finish = System.currentTimeMillis();
		result = finish - start;
		mergeTimeArray[3] = result;

		// using the selection sort
		start = System.currentTimeMillis();
		selection(randomSmall);
		finish = System.currentTimeMillis();
		result = finish - start;
		selectionTimeArray[2] = result;

		start = System.currentTimeMillis();
		selection(randomLarg);
		finish = System.currentTimeMillis();
		result = finish - start;
		selectionTimeArray[3] = result;

		// --------------------------------------------

		int reverselySmall[] = new int[100000];
		int reverselyLarg[] = new int[1000000];
		fillReverselySortedArray(reverselySmall);
		fillReverselySortedArray(reverselyLarg);

		// using the merge sort
		start = System.currentTimeMillis();
		mergeSort(reverselySmall, 0, reverselySmall.length - 1);
		finish = System.currentTimeMillis();
		result = finish - start;
		mergeTimeArray[4] = result;

		start = System.currentTimeMillis();
		mergeSort(reverselyLarg, 0, reverselyLarg.length - 1);
		finish = System.currentTimeMillis();
		result = finish - start;
		mergeTimeArray[5] = result;

		// using the selection sort
		start = System.currentTimeMillis();
		selection(reverselySmall);
		finish = System.currentTimeMillis();
		result = finish - start;
		selectionTimeArray[4] = result;

		start = System.currentTimeMillis();
		selection(reverselyLarg);
		finish = System.currentTimeMillis();
		result = finish - start;
		selectionTimeArray[5] = result;

		for (int i = 0; i < mergeTimeArray.length; i++) {
			System.out.println(mergeTimeArray[i]);

		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < selectionTimeArray.length; i++) {
			System.out.println(selectionTimeArray[i]);

		}
	}

	public static void mergeSort(int a[], int f, int l) {
		if (f == l) {
			return;// L1
		}
		int mid = (f + l) / 2;
		mergeSort(a, f, mid);// L2
		mergeSort(a, mid + 1, l);// L3
		merge(a, f, mid, l); // Call to merge function//L4
	}

	public static void merge(int[] array, int first, int mid, int last) {
		int[] result = new int[last - first + 1];
		int i = first;
		int j = mid + 1;
		int k = 0;

		while (i <= mid || j <= last) {
			if (i > mid) {
				result[k] = array[j++];
			} else if (j > last) {
				result[k] = array[i++];
			} else if (array[i] <= array[j]) {
				result[k] = array[i++];
			} else {
				result[k] = array[j++];
			}
			k++;
		}

		// copying the elements from result back to the original array
		for (int index = 0; index < result.length; index++) {
			array[first + index] = result[index];
		}

	}

	public static void selection(int array[]) {
		int size = array.length;// array size

		for (int i = 0; i < size / 2; i++) {// loop from i=0 to size/2 because we sort two elements each iteration
			int min = i;
			int max = i;
			for (int j = i + 1; j < size - i; j++) {// loop on the array to find the min & max
				if (array[j] < array[min]) {
					min = j;
				} else if (array[j] > array[max]) {
					max = j;
				}
			}
			if (min != i) {// swapping the min if so
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
			if (max != size - i - 1) {// swapping the max if so
				int temp = array[max];
				array[max] = array[size - i - 1];
				array[size - i - 1] = temp;
			}
		}
	}

	// Method to fill arrays with sorted values
	public static void fillSortedArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
	}

	// Method to fill arrays with random values
	public static void fillRandomArray(int[] array) {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}
	}

	// Method to fill arrays with reversely sorted values
	public static void fillReverselySortedArray(int[] array) {
		int value = array.length;
		for (int i = 0; i < array.length; i++) {
			array[i] = value--;
		}
	}

}
