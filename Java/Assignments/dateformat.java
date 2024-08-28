package assignment5_1q.dateformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class dateformat {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			// Prompt the user to enter date and time
			System.out.print("Enter date and time (dd/mm/yyyy hh:mm:ss): ");
			String inputDateTime = scanner.nextLine();

			// Parse the input string into LocalDateTime
			LocalDateTime dateTime = LocalDateTime.parse(inputDateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

			// Convert to different formats
			String ddMMYYYY = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String mmDDYYYY = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			String YYYYMMDD = dateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			String hhMMSS = dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String hhMMSSa = dateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
			String hhMM = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));

			// Print the converted formats
			System.out.println("Date formats:");
			System.out.println("dd/mm/yyyy: " + ddMMYYYY);
			System.out.println("mm/dd/yyyy: " + mmDDYYYY);
			System.out.println("yyyy/mm/dd: " + YYYYMMDD);

			System.out.println("\nTime formats:");
			System.out.println("hh:mm:ss: " + hhMMSS);
			System.out.println("hh:mm:ss a: " + hhMMSSa);
			System.out.println("hh:mm: " + hhMM);
		}
    }
}

 

