import java.util.Scanner;

public class StringCalculate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        String result = inputV(input);
        System.out.println(result);
        scanner.close();
    }


    private static boolean proverkaOtDo(int number) {
        return number >= 1 && number <= 10;
    }

    private static String inputV(String input) {

        if (input.contains("+")) {
            return handleAddition(input);
        } else if (input.contains("-")) {
            return handleS(input);
        } else if (input.contains("*")) {
            return handleM(input);
        } else if (input.contains("/")) {
            return handleD(input);
        }
        return "Неверный формат ввода.";
    }

    private static String handleAddition(String input) {

        String[] parts = input.split("\\+");
        if (parts.length == 2) {
            String firstString = removeQ(parts[0].trim());
            String secondString = removeQ(parts[1].trim());

            String result = firstString + secondString;

            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }

            return "\"" + result + "\"";
        }
        return "Неверный формат ввода.";
    }

    private static String handleS(String input) {
        String[] parts = input.split(" - ");
        if (parts.length == 2) {
            String firstString = removeQ(parts[0].trim());
            String secondString = removeQ(parts[1].trim());
            return subStrings(firstString, secondString);
        }
        return "Неверный формат ввода.";
    }

    private static String handleM(String input) {
        String[] parts = input.split(" \\* ");
        if (parts.length == 2) {
            String firstString = removeQ(parts[0].trim());
            int multiplier = Integer.parseInt(removeQ(parts[1].trim()));

            if (!proverkaOtDo(multiplier)) {
                return "Числа должны быть от 1 до 10 включительно.";
            }

            return mulString(firstString, multiplier);
        }
        return "Неверный формат ввода.";
    }

    private static String handleD(String input) {
        String[] parts = input.split(" / ");
        if (parts.length == 2) {
            String firstString = removeQ(parts[0].trim());
            int divisor = Integer.parseInt(removeQ(parts[1].trim()));

            if (!proverkaOtDo(divisor)) {
                return "Числа должны быть от 1 до 10 включительно.";
            }

            return divString(firstString, divisor);
        }
        return "Неверный формат ввода.";
    }

    private static String subStrings(String a, String b) {
        if (a.contains(b)) {
            int index = a.indexOf(b);
            String result = a.substring(0, index);
            return "\"" + result + "\"";
        }
        return "\"" + a + "\"";
    }

    private static String mulString(String str, int times) {
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

    private static String divString(String str, int parts) {
        int partLength = str.length() / parts;
        String result = str.substring(0, Math.min(partLength, str.length()));
        return "\"" + result + "\"";
    }

    private static String removeQ(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }
}
