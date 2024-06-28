import java.util.Scanner;

public class Caluker {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = scanner.nextLine();
        System.out.println(calc(expression));
    }

    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = input.split("[\\-+*/]");
        if ((!(input).contains("+")) && (!(input).contains("-")) && (!(input).contains("*")) &&  (!(input).contains("/")))
            throw new Exception("Неверная математическая операция");

        if (operands.length != 2) throw new Exception("Должно быть два числа");

        oper = detectSymbol(input);
        if (oper == null) throw new Exception("");

        if (Roman.Rom(operands[0]) && Roman.Rom(operands[1])) {
            num1 = Roman.DofromRomToArabic(operands[0]);
            num2 = Roman.DofromRomToArabic(operands[1]);
            isRoman = true;
        }
        else if (!Roman.Rom(operands[0]) && !Roman.Rom(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Оба числа должны быть либо арабскими либо римскими");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabic = counting(num1, num2, oper);
        if (isRoman) {
            if (arabic <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman.fromArabicToRoman(arabic);
        } else {
            result = String.valueOf(arabic);
        }
        return result;
    }

    static String detectSymbol(String express) {
        if (express.contains("+")) return "+";
        else if (express.contains("-")) return "-";
        else if (express.contains("*")) return "*";
        else if (express.contains("/")) return "/";
        else return null;
    }

    static int counting(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

}

class Roman {
    static String[] romArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean Rom(String val) {
        for (int i = 0; i < romArray.length; i++) {
            if (val.equals(romArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int DofromRomToArabic(String roman) {
        for (int i = 0; i < romArray.length; i++) {
            if (roman.equals(romArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String fromArabicToRoman(int arabiс) {
        return romArray[arabiс];
    }

}