/* 
     1. Write a Java Program to find GCD of two given numbers. 
     2. Write a java program to LCM of TWO given number. 
     3. Write a Java Program to print all the Prime Factorsof the Given Number. 
     4. Check whether the Given Numberis a Palindrome or NOT. 
     5. Write a Java Program to check whether the Given Number is Prime Number or NOT. 
     6. Write a Java Program to check whether the given number is Armstrong Numberor NOT. 
     7. Write a Java Program to check whether the given number is Perfect Numberor NOT. 
     8.  Write a Java Program to check whether the given numbers are Amicable Numbersor NOT.
     9. Write a Java Program to check whether the given number is Ramanujam's Numberor NOT.
     10. Write a Java Program check whether the given number is Automorphic Numberor NOT.
    
     */

import java.util.Scanner;

public class first {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n------ Number Operations Menu ------");
            System.out.println("1. Find GCD of two numbers");
            System.out.println("2. Find LCM of two numbers");
            System.out.println("3. Print all prime factors of a number");
            System.out.println("4. Check if a number is a Palindrome");
            System.out.println("5. Check if a number is Prime");
            System.out.println("6. Check if a number is an Armstrong Number");
            System.out.println("7. Check if a number is a Perfect Number");
            System.out.println("8. Check if two numbers are Amicable");
            System.out.println("9. Check if a number is a Ramanujan Number");
            System.out.println("10. Check if a number is an Automorphic Number");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" Enter ur Two Numbers");
                    int a = s.nextInt();
                    int b = s.nextInt();
                    int result =  GCD(a,b);
                    System.out.println(result);
                    break;
                case 2:
                    LCM();
                    break;
                case 3:
                    PRIME_FACTORS();
                    break;
                case 4:
                    CHECKPALINDROME();
                    break;
                case 5:
                    CHECK_PRIME();
                    break;
                case 6:
                    CHECK_ARMSTRONG();
                    break;
                case 7:
                    CHECK_PERFECT();
                    break;
                case 8:
                    AMICABLE();
                    break;
                case 9:
                    CHECK_RAMANAJUN();
                    break;
                case 10:
                    AUTOMORPHIC();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
         
    }

    private static void AUTOMORPHIC() {
        System.out.println("ENTER UR  NUMBER");
        int a = s.nextInt();
        if ((a % 10) == (((int) Math.pow(a, 2)) % 10)) {
            System.out.println(" It is AUTOMORPHIC NUMBER");
        } else {
            System.out.println(" It is  NOT A AUTOMORPHIC NUMBER");
        }
    }

    private static void CHECK_RAMANAJUN() {
        System.out.println("ENTER UR  NUMBER");
        int a = s.nextInt();
        int counter = 0;

        int n = a / 3;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 2; j <= n; j++) {
                int answer = (int) (Math.pow(i, 3) + Math.pow(j, 3));
                if (answer == a) {
                    counter++;
                }
            }
        }
        if (counter > 1) {
            System.out.println(" It is a Ramanujan Number ");
        } else {
            System.out.println(" It is not  a Ramanujan Number ");
        }
    }

    private static void AMICABLE() {
        System.out.println("ENTER UR TWO NUMBERS");
        int a = s.nextInt();
        int b = s.nextInt();
        if (helper(a) == b && helper(b) == a) {
            System.out.println(" ur two numbers are AMICABLE");
        } else {
            System.out.println(" ur two numbers are  not AMICABLE");
        }
    }

    static int helper(int a) {
        int[] factors = new int[a];
        int counter = 1;
        factors[0] = 1;

        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                int factor = a / i;
                boolean b = true;
                for (int j = 0; j < counter; j++) {
                    if (factor == factors[j]) {
                        b = false;
                        break;
                    } else {
                        continue;
                    }
                }
                if (b) {
                    factors[counter++] = i;
                    factors[counter++] = factor;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        int answer = 0;
        for (int k = 0; k <= counter; k++) {
            answer += factors[k];
        }
        return answer;
    }

    private static void CHECK_PERFECT() {
        System.out.println("ENTER THE NUMBER");
        int a = s.nextInt();

        int[] factors = new int[a];
        int counter = 1;
        factors[0] = 1;

        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                int factor = a / i;
                boolean b = true;
                for (int j = 0; j < counter; j++) {
                    if (factor == factors[j]) {
                        b = false;
                        break;
                    } else {
                        continue;
                    }
                }
                if (b) {
                    factors[counter++] = i;
                    factors[counter++] = factor;
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        int answer = 0;
        for (int k = 0; k <= counter; k++) {
            answer += factors[k];
        }
        if (a == answer) {
            System.out.println(" It is a PERFECT Number");
        } else {
            System.out.println(" It is not a PERFECT Number");
        }
    }

    private static void CHECK_ARMSTRONG() {
        System.out.println("ENTER THE NUMBER");
        int a = s.nextInt();
        int b = a;
        int answer = 0;
        while (a != 0) {
            int rem = a % 10;
            answer += (int) (Math.pow(rem, 3));
            a = a / 10;
        }
        if (b == answer) {
            System.out.println("It is a Armstrong Number");
        } else {
            System.out.println("It is not a Armstrong Number");
        }
    }

    private static void CHECK_PRIME() {
        System.out.println("ENTER THE NUMBER");
        int a = s.nextInt();
        if (a == 2) {
            System.out.println("it is a prime");
            return;
        }
        if (a == 0 || a == 1) {
            System.out.println("it is not a prime");
            return;
        }

        int b = (int) Math.sqrt(a);
        boolean B = true;
        for (int i = 2; i <= b; i += 2) {
            if (a % i == 0) {
                B = false;
                break;
            } else {
                continue;
            }
        }
        if (B) {
            System.out.println("it is a prime");
        } else {
            System.out.println("it is not a prime");
        }
    }


    private static void CHECKPALINDROME() {
       
            System.out.println("ENTER THE STRING");
            String S = s.next(); 
            boolean b = true;
            int length = S.length();
            for (int i = 0; i < length / 2; i++) {
                if (S.charAt(i) != S.charAt(length - 1 - i)) 
                {
                    b = false;
                    break;
                }
            }
   
            if (b) {
                System.out.println("It is a Palindrome");
            } else {
                System.out.println("It is not a Palindrome");
            }
        }
    
    

    private static void PRIME_FACTORS() {
        System.out.println("ENTER THE NUMBER");
        int a = s.nextInt();
        
        int[] arr = new int[a];
        int counter = 0;
        for (int i = 2; i <= a; i ++) {
            if (a % i == 0) 
            {
                arr[counter++] = i;

                while (a % i == 0) {
                    a /= i;
                }
            } 
            else
             {
                continue;
             }
        }
        if (counter == 0) {
            System.out.println(a + " and " + 1 + " are the only factors and is prime");
        } else {
            for (int j = 0; j < counter; j++) {
                System.out.println(arr[j]);
            }
        }
    }

    private static void LCM() {
        System.out.println("ENTER UR TWO NUMBERS");
        int a = s.nextInt();
        int b = s.nextInt();
        int gcd = GCD(a, b);
        int lcm = (a / gcd) * (b / gcd) * gcd;
        System.out.println(lcm);
    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}
