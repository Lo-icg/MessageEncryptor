package jav.builder;

public class CaesarCipher extends CaesarCipherUtility {

    private CaesarCipher() {

        var running = true;

        while (running) {

            var message = returnStr("Enter a message to encrypt: ");

            System.out.println();

            var key = returnInt("Enter shift key(1-26): ");

            System.out.println();

            System.out.println(encrypt(message, key) + "\n");

            var option = returnChar("Press (enter) to encrypt another message or (q) to exit program: ");

            if (option == 'q') {
                closeScanner();
                break;
            }

            System.out.println();

        }

    }

    public static void launch() {
        new CaesarCipher();
    }

}
