import java.util.*;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private Queue<String> borrowQueue = new LinkedList<>();
    private Stack<String> returnHistory = new Stack<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n------ BOOK LIST ------");

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public Book searchBook(int id) {

        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }

        return null;
    }

    public void deleteBook(int id) {

        Book book = searchBook(id);

        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void borrowBook(int id, String student) {

        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isAvailable()) {
            book.borrowBook();
            borrowQueue.add(student);
            System.out.println(student + " borrowed the book.");
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook(int id) {

        Book book = searchBook(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            book.returnBook();
            returnHistory.push(book.getTitle());
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is already available.");
        }
    }

    public void showBorrowQueue() {

        System.out.println("\nBorrow Queue");

        for (String s : borrowQueue) {
            System.out.println(s);
        }
    }

    public void showReturnHistory() {

        System.out.println("\nReturn History");

        for (String s : returnHistory) {
            System.out.println(s);
        }
    }
}
