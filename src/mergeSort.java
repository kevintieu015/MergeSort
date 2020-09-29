import java.util.Arrays;
//Algorith is used from Intro to Algorithms 3rd ed. by CLRS
//This program will allow us to merge sort a given array
//then mergesort a user input array 

//mergeSort class begins here
public class mergeSort {

	// Merge method will take two sub arrays and combine them
	void merge(int array[], int left, int middle, int right) {
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Creating Temporary Arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// Replacing values into temporary arrays
		for (int i = 0; i < n1; ++i)
			L[i] = array[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[middle + 1 + j];

		int i = 0;
		int j = 0;
		int k = left;
		// This is where we begin to merge the two arrays
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		// If any values from left array exist they will store here
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		// If any values from right array exist they will store here
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	// Sorts the arrays and calls on merge method to merge
	void sort(int array[], int left, int right) {
		if (left < right) {

			// Find the middle point by dividing array
			int middle = (left + right) / 2;

			// Sort left half and right half
			sort(array, left, middle);
			sort(array, middle + 1, right);

			// calls upon merge method
			merge(array, left, middle, right);
		}
	}

	public static void main(String args[]) {

		int array[] = new int[5];
		
		//create a randomized array
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 1000);
		}

		System.out.println("Randomized Array:   " + Arrays.toString(array));

		mergeSort object = new mergeSort();
		object.sort(array, 0, array.length - 1);

		System.out.println("Merge Sorted Array: " + Arrays.toString(array));
	
	}
}