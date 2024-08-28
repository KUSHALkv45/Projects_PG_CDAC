package assigment_9;

public class ass4 {
	
	    public static void main(String[] args) {
	        try {
	            // Attempting division by zero
	            int result = 10 / 0;
	            System.out.println("Result: " + result);
	        } catch (ArithmeticException e) {
	            // Catching arithmetic exceptions
	            System.out.println("ArithmeticException occurred: " + e.getMessage());
	        } catch (NullPointerException e) {
	            // Catching null pointer exceptions
	            System.out.println("NullPointerException occurred: " + e.getMessage());
	        } catch (Exception e) {
	            // Catching all other exceptions
	            System.out.println("Exception occurred: " + e.getMessage());
	        }
	    }
	}

