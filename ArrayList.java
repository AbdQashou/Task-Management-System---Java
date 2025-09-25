package data_final;

public class ArrayList {

	private int array[];
	private int end;
	private int size;

	// constructor
	public ArrayList() {

		size = 10;
		array = new int[size];
		end = -1;
	}

	public int getSize() {
		return size;
	}

	// methods
	boolean isEmpty() {
		if (end == -1) {
			return true;
		} else {
			return false;
		}
	}

	void insert(int value) {
		// by making the array able to be bigger

		// is full function(((((((
		if (end >= size - 1) {
			size *= 2;
			int[] array1 = new int[size];

			for (int i = 0; i < array.length; i++) {
				array1[i] = array[i];
			}
			array = array1;
		}
		// )))))))))

		end++;
		array[end] = value;
	}

	int count() {

		return end + 1;
	}

	int readAt(int index) {

		return array[index];
	}

	void modify(int index, int value) {
		array[index] = value;
	}

	void remove() {
		end--;
	}

	void clear() {
		end = -1;
	}

	// Shifting
	void removeAt(int index) {

		for (int i = index; i < end; i++) {
			array[i] = array[i + 1];
		}
		end--;

	}

	public void insertAt(int index, int value) {
		// is full function(((((((
		if (end >= size - 1) {
			size *= 2;
			int[] array1 = new int[size];

			for (int i = 0; i < array.length; i++) {
				array1[i] = array[i];
			}
			array = array1;
		}
		// )))))))))

		end++;
		for (int i = end; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = value;
	}

	public void printCurrentText() {

		for (int i = 0; i < array.length; i++) {

			System.out.print(array[i]);

		}
	}
}
