import java.util.Scanner;

class Main {
    public static String calc(String input) throws Exception {
        input = input.trim();
        String[] parts = input.split("\\s");

        if (parts.length != 3) {
            throw new Exception("Invalid input format.");
        }

        String leftOperand = parts[0];
        String operator = parts[1];
        String rightOperand = parts[2];

        boolean leftIsRoman = isRoman(leftOperand);
        boolean rightIsRoman = isRoman(rightOperand);

        if (leftIsRoman != rightIsRoman) {
            throw new Exception("Cannot mix Roman and Arabic numerals.");
        }

        int leftValue = leftIsRoman ? RomanNumerals.toInt(leftOperand) : Integer.parseInt(leftOperand);
        int rightValue = rightIsRoman ? RomanNumerals.toInt(rightOperand) : Integer.parseInt(rightOperand);

        if (leftValue < 1 || leftValue > 10 || rightValue < 1 || rightValue > 10) {
            throw new Exception("Numbers should be between 1 and 10.");
        }

        int result;
        switch (operator) {
            case "+":
                result = leftValue + rightValue;
                break;
            case "-":
                result = leftValue - rightValue;
                if (leftIsRoman && result <= 0) {
                    throw new Exception("Result is non-positive in Roman numerals.");
                }
                break;
            case "*":
                result = leftValue * rightValue;
                break;
            case "/":
                result = leftValue / rightValue;
                break;
            default:
                throw new Exception("Invalid operator.");
        }

        return leftIsRoman ? RomanNumerals.toString(result) : Integer.toString(result);
    }

    private static boolean isRoman(String operand) {
        return operand.matches("^[IVXLCDM]+$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            System.out.println(Main.calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}