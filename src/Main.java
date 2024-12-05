public class Main {
    public static void main(String[] args) {
        int inputNumber = 5;
        System.out.printf("\n1 - Soma de Números\nEntrada = %d\nSaída = %s", inputNumber, addNumbers(inputNumber));

        System.out.printf("\n2 - Fatorial\nEntrada = %d\nSaída = %s", inputNumber, factorial(inputNumber));
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
}