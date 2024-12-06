public class Main {
    public static void main(String[] args) {

        System.out.printf("\n1 - Soma de Números\nEntrada = %d\nSaída = %s\n", 5, addNumbers(5));

        System.out.printf("\n2 - Fatorial\nEntrada = %d\nSaída = %s\n", 5, factorial(5));

        System.out.printf("\n3  - Contagem de Dígitos\nEntrada = %d\nSaída = %s\n", 12345, digitCount(12345));

        System.out.printf("\n4 - Número primo\nEntrada = %d\nSaída = %s\n", 29, isPrime(29));

        System.out.printf("\n5  - Inversão de Dígitos\nEntrada = %d\nSaída = %s\n", 12345, inverseNumber(12345));

        System.out.printf("\n5  - Potência\nEntrada = %s\nSaída = %s\n", "2^3" , pow(2,3));

        System.out.printf("\n4 - Palindromo\nEntrada = %d\nSaída = %s\n", 2552, isPalindrome(2552));
    }

    /**
     * Calculates the sum of all integers from 1 to the given number and returns a string
     * representation of the sum along with the sequence of numbers added.
     * @param number The upper limit of the range (inclusive) for which the sum will be calculated.
     *               Must be a positive integer.
     * @return A string containing the total sum followed by the sequence of numbers added.
     *         For example, if the input is 5, the output will be "15 (1 + 2 + 3 + 4 + 5)".
     */
    public static String addNumbers (int number){
        // StringBuilder to construct the sequence of numbers being added
        StringBuilder addedNumbers = new StringBuilder();
        // Variable to store the cumulative sum
        int sum = 0;

        // Start the sequence representation with an opening parenthesis
        addedNumbers.append(" (");

        // Loop through all numbers from 1 to the given number
        for (int i = 1; i <= number; i++) {
            // Add the current number to the cumulative sum
            sum += i;
            // Append the current number to the sequence
            addedNumbers.append(i);
            // If it's not the last number, append " + " for formatting
            if(i != number)
                addedNumbers.append(" + ");
            // If it's the last number, close the sequence with a closing parenthesis
            else
                addedNumbers.append(")");
        }
        // Insert the total sum at the beginning of the string and return the result
        return addedNumbers.insert(0,sum).toString();
    }

    /**
     * Calculates the factorial of a given number and returns a string representation
     * of the factorial value along with the sequence of numbers multiplied.
     *
     * @param number The number for which the factorial will be calculated. Must be a non-negative integer.
     * @return A string containing the factorial value followed by the sequence of numbers multiplied.
     * For example, if the input is 5, the output will be "120 (5 * 4 * 3 * 2 * 1)".
     */
    public static String factorial(int number){
        // StringBuilder to construct the sequence of numbers being multiplied
        StringBuilder factorialStr = new StringBuilder();
        // Variable to store the cumulative factorial result
        int factorial = 1;
        // Variable to iterate through the numbers from the input down to 1
        int i = number;

        // Start the sequence representation with an opening parenthesis
        factorialStr.append(" (");

        // Loop through all numbers from the input down to 1
        while (i > 0) {
            // Multiply the current number to the cumulative factorial
            factorial *= i;

            // Append the current number to the sequence
            factorialStr.append(i);

            // If it's not the last number, append " * " for formatting
            if (i != 1)
                factorialStr.append(" * ");
                // If it's the last number, close the sequence with a closing parenthesis
            else
                factorialStr.append(")");

            // Decrement the variable i to move to the next number
            i--;
        }
        // Insert the factorial at the beginning of the string and return the result
        return factorialStr.insert(0,factorial).toString();
    }

    /**
     * Counts the number of digits in a given positive integer.
     *
     * @param number The number for which the digit count will be calculated.
     *               Must be a positive integer.
     * @return The total number of digits in the given number.
     *         For example, if the input is 12345, the output will be 5.
     */
    public static int digitCount(int number) {

        // Variable to store the count of digits
        int count = 0;

        // Variable to assist in the calculation without modifying the original number
        int assistant = number;

        // Loop to divide the number by 10 until it becomes 0
        while (assistant > 0) {
            assistant = assistant / 10; // Remove the last digit
            count++; // Increment the digit count
        }

        // Return the total count of digits
        return count;
    }

    /**
     * Determines if a given number is a prime number.
     * <p>A prime number is a natural number greater than 1 that has no positive divisors
     *    other than 1 and itself. This method checks if the input number meets this condition.<p>
     *
     * @param number The number to check. Must be an integer.
     * @return {@code true} if the number is prime, {@code false} otherwise.
     *         - Returns {@code false} for numbers less than or equal to 1.
     *         - Returns {@code false} if the number has any divisors other than 1 and itself.
     *         - Returns {@code true} if the number is prime.
     */
    public static boolean isPrime(int number) {
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // Loop through potential divisors from 2 to the square root of the number
        for (int i = 2; i < Math.sqrt(number); i++) {
            // If the number is divisible by any i, it is not prime
            if (number % i == 0) {
                return false;
            }
        }

        // If no divisors were found, the number is prime
        return true;
    }

    /**
     * Reverses the digits of a given positive integer.
     *
     * @param number The number to be reversed. Must be a positive integer.
     * @return The number with its digits in reverse order.
     * For example, if the input is 12345, the output will be 54321.
     */
    public static int inverseNumber(int number) {
        // Calculate the total number of digits in the given number
        int digits = digitCount(number);

        // Variable to store the reversed number
        int result = 0;

        // Variable to assist in the calculation without modifying the original number
        int assistant = number;

        // Variable to store the current digit being processed
        int digit;

        // Loop through each digit of the number
        for (int i = 0; i < digits; i++) {
            // Extract the last digit of the number
            digit = assistant % 10;

            // Remove the last digit from the assistant variable
            assistant /= 10;

            // Add the digit to the result in its reversed position
            result += (int) (digit * Math.pow(10, digits - i - 1));
        }

        // Return the reversed number
        return result;
    }

    /**
     * Calculates the power of a given base raised to a specified exponent.
     *
     * @param base The base number to be raised to a power.
     * @param expoent The exponent to which the base is raised.
     *                It determines how many times the base is multiplied by itself.
     * @return The result of base^expoent (base raised to the power of expoent).
     */
    public static int pow(int base, int expoent){
        // Initialize to 1 to handle the case of expoent = 0 correctly.
        int pow = 1;

        for(int i = 0; i < expoent; i++){
            pow *= base;
        }
        return pow;
    }

    /**
     * Checks if a given number is a palindrome.
     *
     * @param number The number to be checked for being a palindrome.
     * @return {@code true} if the number is a palindrome, {@code false} otherwise.
     */
    public static boolean isPalindrome(int number) {
        return number == inverseNumber(number);
    }
}