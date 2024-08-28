package assigment_9;

public class asss2 {

	    public static void main(String[] args) {
	        try {
	            // Testing the checkEvenNumber method
	            checkEvenNumber(5);
	        } catch (OddNumberException e) {
	            System.out.println("An exception occurred: " + e.getMessage());
	        }
	    }

	    // Method to check if the number is even or odd
	    public static void checkEvenNumber(int number) throws OddNumberException {
	        if (number % 2 != 0) {
	            // If number is odd, throw an OddNumberException
	            throw new OddNumberException("Number is odd: " + number);
	        } else {
	            System.out.println("Number is even: " + number);
	        }
	    }
	}

	// Custom exception class for odd numbers
	@SuppressWarnings("serial")
	class OddNumberException extends Exception {
	    public OddNumberException(String message) {
	        super(message);
	    }
	}

