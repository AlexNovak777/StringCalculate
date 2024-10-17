import java.util.Scanner;

public class StringCalculate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        String result = processInput(input);
        System.out.println(result);
        scanner.close();
    }

    private static String processInput(String input) {
        if (input.contains("+")) {
            return handleAddition(input);
        } else if (input.contains("-")) {
            return handleSubtraction(input);
        } else if (input.contains("*")) {
            return handleMultiplication(input);
        } else if (input.contains("/")) {
            return handleDivision(input);
        }
        return "Неверный формат ввода.";
    }

    private static String handleAddition(String input) {
        String[] parts = input.split("\\+");
        if (parts.length == 2) {
            String firstString = removeQuotes(parts[0].trim());
            String secondString = removeQuotes(parts[1].trim());
            String result = firstString + secondString;

            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }

            return "\"" + result + "\"";
        }
        return "Неверный формат ввода.";
    }

    private static String handleSubtraction(String input) {
        String[] parts = input.split(" - ");
        if (parts.length == 2) {
            String firstString = removeQuotes(parts[0].trim());
            String secondString = removeQuotes(parts[1].trim());
            return subtractStrings(firstString, secondString);
        }
        return "Неверный формат ввода.";
    }

    private static String handleMultiplication(String input) {
        String[] parts = input.split(" \\* ");
        if (parts.length == 2) {
            String firstString = removeQuotes(parts[0].trim());
            int multiplier = Integer.parseInt(removeQuotes(parts[1].trim()));
            return multiplyString(firstString, multiplier);
        }
        return "Неверный формат ввода.";
    }

    private static String handleDivision(String input) {
        String[] parts = input.split(" / ");
        if (parts.length == 2) {
            String firstString = removeQuotes(parts[0].trim());
            int divisor = Integer.parseInt(removeQuotes(parts[1].trim()));
            return divideString(firstString, divisor);
        }
        return "Неверный формат ввода.";
    }

    private static String subtractStrings(String a, String b) {
        if (a.contains(b)) {
            int index = a.indexOf(b);
            String result = a.substring(0, index);
            return "\"" + result + "\"";
        }
        return "\"" + a + "\"";
    }

    private static String multiplyString(String str, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }

        String finalResult = result.toString();

        if (finalResult.length() > 40) {
            return "\"" + finalResult.substring(0, 40) + "...\"";
        }

        return "\"" + finalResult + "\"";
    }

    private static String divideString(String str, int parts) {
        int partLength = str.length() / parts;
        String result = str.substring(0, Math.min(partLength, str.length()));
        return "\"" + result + "\"";
    }
    
    private static String removeQuotes(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }
}
