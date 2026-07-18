import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Borrow Queue");
            System.out.println("8. Return History");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Title: ");
                    String title = input.nextLine();

                    System.out.print("Author: ");
                    String author = input.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    Book b = library.searchBook(input.nextInt());

                    if (b != null)
                        System.out.println(b);
                    else
                        System.out.println("Book not found.");
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    library.deleteBook(input.nextInt());
                    break;

                case 5:
                    System.out.print("Book ID: ");
                    int bid = input.nextInt();
                    input.nextLine();

                    System.out.print("Student Name: ");
                    String name = input.nextLine();

                    library.borrowBook(bid, name);
                    break;

                case 6:
                    System.out.print("Book ID: ");
                    library.returnBook(input.nextInt());
                    break;

                case 7:
                    library.showBorrowQueue();
                    break;

                case 8:
                    library.showReturnHistory();
                    break;

                case 9:
                    System.out.println("Thank You.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}