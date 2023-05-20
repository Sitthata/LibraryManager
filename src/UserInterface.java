import java.util.Scanner;

public class UserInterface {

    private final LibraryManager libraryManager;
    private final Scanner sc;

    public UserInterface(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Find Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.next();
                    System.out.print("Enter author: ");
                    String author = sc.next();
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    libraryManager.addBook(new Book(title, author, year));
                }
                case 2 -> {
                    System.out.println("All Books:");
                    libraryManager.getAllBooks().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter title: ");
                    String findTitle = sc.next();
                    Book book = libraryManager.findBook(findTitle);
                    System.out.println(book != null ? book : "Book not found");
                }
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
