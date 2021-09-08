package gb.spring.client;

import gb.spring.service.Cart;
import gb.spring.service.source.Command;

import java.util.Locale;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);

    public void run(Cart cart) {
        while (true) {
            System.out.println("Input command: ");
            String input = scanner.nextLine().trim().toUpperCase(Locale.ROOT);

            if (isValid(input)) {
                if (input.equalsIgnoreCase(Command.ADD.name())) {
                    cart.addProduct(getInteger(), getInteger());
                }
                if (input.equalsIgnoreCase(Command.CLEAR.name())) {
                    cart.clear();
                }
                if (input.equalsIgnoreCase(Command.REMOVE.name())) {
                    cart.remove(getInteger(), getInteger());
                }
                if (input.equalsIgnoreCase(Command.SHOW.name())) {
                    cart.getAll();
                }
                if (input.equalsIgnoreCase(Command.HELP.name())) {
                    for (int i = 0; i < Command.values().length; i++) {
                        System.out.println("[ " + Command.values()[i].name() + " ]"
                                + " - " + Command.values()[i].getClarification());
                    }
                }
                if (input.equalsIgnoreCase(Command.EXIT.name())) {
                    scanner.close();
                    break;
                }
            } else {
                System.out.println("Input [HELP] for show all commands.");
            }
        }
    }


    private int getInteger() {
        while (true) {
            System.out.println("Input ID/amount: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.err.println("Input Integer number please! Your choice: " + scanner.next());
            }
        }
    }

    public boolean isValid(String str) {
        for (int i = 0; i < Command.values().length; i++) {
            if (str.equalsIgnoreCase(Command.values()[i].name())) {
                return true;
            }
        }
        return false;
    }
}