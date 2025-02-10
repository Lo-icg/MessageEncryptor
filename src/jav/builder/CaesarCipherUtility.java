package jav.builder;

import java.util.Scanner;

class CaesarCipherUtility {

    private final String lettersUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lettersLower = lettersUpper.toLowerCase();

    private final int size = lettersUpper.length(); // alphabet size

    private char[] letter_U = lettersUpper.toCharArray();
    private char[] letter_L = lettersLower.toCharArray();

    protected int key;
    protected Scanner read = new Scanner(System.in);

    protected void closeScanner() {
        read.close();
    }

    protected String returnStr(String label) {
        System.out.print(label);
        return read.nextLine();
    }

    protected int returnInt(String label) {
        System.out.print(label);
        do {
            try {
                var r = read.nextInt();
                read.nextLine();

                if (r < 1 || r > 26) {
                    System.out.print("Invalid input. Please enter a number (between 1 and 26): ");
                } else {
                    return r;
                }

            } catch (Exception e) {
                read.nextLine();
                System.out.print("Invalid input. Please enter a number: ");
            }
        } while (true);
    }

    protected String encrypt(String message, int key) {

        String cipherTextUpper = lettersUpper.substring(key) + lettersUpper.substring(0, key);
        String cipherTextLower = lettersLower.substring(key) + lettersLower.substring(0, key);

        // to array
        char[] cipher_U = cipherTextUpper.toCharArray();
        char[] cipher_L = cipherTextLower.toCharArray();

        char[] text = message.toCharArray(); // to array message to encrypt
        StringBuilder messageEncrypted = new StringBuilder(); // encrypted message to return

        for (char c : text) {

            var found = false;

            for (int i = 0; i < size; i++) {
                if (c == letter_U[i]) {
                    messageEncrypted.append(cipher_U[i]);
                    found = true;
                    break;
                } else if (c == letter_L[i]) {
                    messageEncrypted.append(cipher_L[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                messageEncrypted.append(c);
            }
        }

        var output = "| " + messageEncrypted.toString() + " |";
        var border = "-".repeat(output.length());

        return "ENCRYPTED:\n" + border + "\n" + output + "\n" + border;
    }

    protected char returnChar(String label) {
        var c = returnStr(label);

        do {

            if (c.equals("")) {
                return 'y';
            }

            if (c.equals("q")) {
                return 'q';
            }

            c = returnStr("Invalid option, try again: ");
        } while (true);
    }
}
