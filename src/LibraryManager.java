import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    public static final String FILE_NAME = "library.bin";

    public void addBook(Book book) {
        List<Book> books = getAllBooks();
        books.add(book);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (file.exists() && file.length() != 0) {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                Object obj = ois.readObject();
                if (obj instanceof List) {
                    books = (List<Book>) obj;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public Book findBook(String title) {
        List<Book> books = getAllBooks();
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
