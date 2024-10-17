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
        // Проверяем наличие операторов
        if (input.contains(" + ")) {
            return handleAddition(input);
        } else if (input.contains(" - ")) {
            return handleSubtraction(input);
        } else if (input.contains(" * ")) {
            return handleMultiplication(input);
        } else if (input.contains(" / ")) {
            return handleDivision(input);
        }
        return "Неверный формат ввода. Ожидалось: \"строка\" оператор \"строка\" или \"строка\" оператор число.";
    }

    private static String handleAddition(String input) {
        String[] parts = input.split(" \\+ ");
        if (parts.length == 2) {
            String firstString = removeQuotes(parts[0].trim());
            String secondString = removeQuotes(parts[1].trim());
            return "\"" + firstString + secondString + "\"";
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
            return "\"" + result + "\""; // Возвращаем результат в кавычках
        }
        return "\"" + a + "\""; // Если строка b не содержится в a, возвращаем a как есть
    }

    private static String multiplyString(String str, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return "\"" + result.toString() + "\""; // Возвращаем результат в кавычках
    }

    private static String divideString(String str, int parts) {
        int partLength = str.length() / parts;
        String result = str.substring(0, Math.min(partLength, str.length()));
        return "\"" + result + "\""; // Возвращаем результат в кавычках
    }

    private static String removeQuotes(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }
}
