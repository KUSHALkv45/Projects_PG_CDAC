package assigment_9;

public class ass3 {
	
	    public static void main(String[] args) {
	        try {
	            // Creating an array with size 3
	            int[] array = {1, 2, 3};

	            // Accessing an index out of bounds (index 3)
	            int value = array[3];
	            System.out.println("Value at index 3: " + value);
	        } catch (ArrayIndexOutOfBoundsException e) {
	            // Catching and handling the ArrayIndexOutOfBoundsException
	            System.out.println("An ArrayIndexOutOfBoundsException occurred: " + e.getMessage());
	        }
	    }
	}


