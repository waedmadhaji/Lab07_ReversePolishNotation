package scanner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.List;

public class Scanner {

    String input;

    public Scanner(String input) {
        this.input = input;
    }

    public String[] getToken() {
        if (input == null || input.isEmpty()) {
            return new String[0]; // return an empty array if input is null or empty
        }

        List<String> tokens = new ArrayList<>();
        int length = input.length();
        int i = 0;

        while (i < length) {
            char currentChar = input.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                // Skip whitespace
                i++;
            } else if (Character.isDigit(currentChar)) {
                // Handle numbers (including multi-digit numbers)
                StringBuilder number = new StringBuilder();
                while (i < length && Character.isDigit(input.charAt(i))) {
                    number.append(input.charAt(i));
                    i++;
                }
                tokens.add(number.toString());
            } else if (isOperator(currentChar) || isParenthesis(currentChar)) {
                // Handle operators and parentheses
                tokens.add(Character.toString(currentChar));
                i++;
            } else {
                // Handle invalid characters (optional)
                throw new IllegalArgumentException("Invalid character encountered: " + currentChar);
            }
        }

        return tokens.toArray(new String[0]);
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner("3 + 5 * ( 10 - 4 )");
        String[] tokens = scanner.getToken();
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}

