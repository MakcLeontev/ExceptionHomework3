import controller.UserController;
import view.ViewUser;


public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        ViewUser viewUser = new ViewUser(userController);
        viewUser.run();
    }
}