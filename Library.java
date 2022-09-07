import java.util.ArrayList;
import java.util.List;

public class Library {
    // instance variable
	String streetAddress;
	List<Book> bookList = new ArrayList<Book>();
	List<String> titleList = new ArrayList<String>();
	
	//library constructor
	public Library(String address) {
		streetAddress = address;
	}
	
	//prints library address
	public void printAddress() {
		System.out.println(streetAddress);
	}
	
	//prints hours (static because it's void and doesn't use variables, and is referenced in main).
	public static void printOpeningHours() {
		System.out.print("Libraries are open daily from 9am to 5pm.");
	}
	
	//adds a book to the library's list
	public void addBook(Book book) {
		Book book1 = book;
		bookList.add(book1);
		titleList.add(book1.title);
	}
	
	//prints all non-borrowed books in the library
	public void printAvailableBooks() {
		if (bookList.isEmpty() == true) {
			System.out.print("No book in catalog ");
		}
		else {
			for (int i = 0; i < bookList.size(); ++i) {
				if (bookList.get(i).borrowed == false) {
					System.out.println(bookList.get(i).title);
				}
				else {}//do nothing
			}
		}
	}
	
	//Borrows book if available, otherwise states borrow/catalog status
	public void borrowBook(String coolTitle) {
		
		int count = 0;//only increments if book is in catalog
		
		for (int i = 0; i < bookList.size(); ++i) {
			if ((bookList.get(i).title.equalsIgnoreCase(coolTitle) == true) && (bookList.get(i).isBorrowed() == false)) {
				System.out.printf("You successfully borrowed %s\n", coolTitle);
				bookList.get(i).borrowed();
				count++;
			}
			else if ((bookList.get(i).title.equalsIgnoreCase(coolTitle) == true) && (bookList.get(i).isBorrowed() == true)) {
				System.out.println("Sorry, this book is already borrowed.");
			}
		}//end of for loop
		
		//if book is not found in catalog after a full search
		if ((count > 0) /*&& titleList.contains(coolTitle) == false*/) {
			System.out.println("Sorry, this book is not in our catalog. ");
		}
	}
	
	//Returns book if borrowed
	public void returnBook(String awesomeTitle) {
		if (bookList.isEmpty() == true) {
			System.out.print("We don't own any books. Try returning to a different library");
		}
		else {
			for (int i = 0; i < bookList.size(); ++i) {
				if ((bookList.get(i).borrowed == true) && (bookList.get(i).title.equals(awesomeTitle))) {
					System.out.printf("You successfully returned %s\n", awesomeTitle);
					bookList.get(i).returned();
				}
				else {}//do nothing
			}
		}
	}
	
	//main method
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
