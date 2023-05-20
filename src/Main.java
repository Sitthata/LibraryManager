import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        LibraryManager libraryManager = new LibraryManager();
        UserInterface userInterface = new UserInterface(libraryManager);
        userInterface.run();

    }
}