package org.khaliuss.coinflipper.dialog;

import java.util.Scanner;

public class IntegerMinMaxDialog implements Dialog<Integer> {

    private final String title;
    private final String error;
    private final int min;
    private final int max;

    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        this.title = title;
        this.error = error;
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer input() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(title);
            String input = scanner.nextLine();

            if (isInteger(input)) {
                int result = Integer.parseInt(input);
                if (result >= min && result <= max){
                    return result;
                }
            }
            System.out.println(error);
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
