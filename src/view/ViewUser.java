package view;

import controller.UserController;
import myexception.WrongDataException;

import java.util.Scanner;

public class ViewUser {
    UserController userController = new UserController();

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;
        while (true) {
            try {
                String command = prompt("Введите команду: CREATE, EXIT ");
                com = Commands.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown command");
                continue;
            }
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    try {
                        String line = prompt("Введите следующие данные в произвольном порядке, разделенные пробелом:\n" +
                                "Фамилия Имя Отчество датарождения(дд.мм.гггг) номертелефона пол(f/m): ");
                        userController.createRecord(line);
                    } catch (WrongDataException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case READ:

                    break;
                case LIST:


                case UPDATE:

            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
