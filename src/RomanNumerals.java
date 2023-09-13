class RomanNumerals {
    private static final String[] NUMERALS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] VALUES = {1, 4, 5, 9, 10, 40, 50, 90, 100};

    public static int toInt(String roman) {
        int result = 0;
        int i = NUMERALS.length - 1;
        int pos = 0;

        while (roman.length() > 0 && i >= 0) {
            if (roman.startsWith(NUMERALS[i])) {
                result += VALUES[i];
                roman = roman.substring(NUMERALS[i].length());
            } else {
                i--;
            }
        }

        if (roman.length() > 0) {
            throw new IllegalArgumentException("Invalid Roman numeral.");
        }

        return result;
    }

    public static String toString(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Roman numerals can only represent positive numbers.");
        }

        StringBuilder result = new StringBuilder();
        int i = VALUES.length - 1;
        while (number > 0) {
            if (number >= VALUES[i]) {
                result.append(NUMERALS[i]);
                number -= VALUES[i];
            } else {
                i--;
            }
        }
        return result.toString();
    }
}
