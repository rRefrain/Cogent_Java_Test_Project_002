package com.book;

import java.util.ArrayList;
import java.util.Collections;

import com.book.exception.InvalidBookException;
import com.book.sort.SortByAuthor;
import com.book.sort.SortByID;
import com.book.sort.SortByTitle;
import com.helper.CustomReader;

/**
 * Has-A Book class with a Compositional Relationship 
 * of a collection of Book class
 * 
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class BookStore {
	/** Collection of Book objects */
	private final ArrayList<Book> books = new ArrayList<>();

	/**
	 * Method to read the userChoice then redirects them to further 
	 * The appropriate command
	 * 
	 * @param userChoice the user choice to redirect menu
	 */
	public void accept(int userChoice) {
		switch (userChoice) {
			case 1:
				addBook();
				break;
			case 2: 
				searchByTitle();
				break;
			case 3: 
				searchByAuthor();
				break;
			case 4:
				displayAll();
				break;
			case 5:
				displaySortByTitle();
				break;
			case 6:
				displaySortByAuthor();
				break;
		}
	}
	
/** Collection Modification Methods */

	/**
	 * Method to add a new book to books
	 * @see Book
	 */
	private void addBook() {
		try {
			books.add(new Book());
		} catch (InvalidBookException e) {
			System.out.println(e.getMessage());
		}
		
	}

/** Search by Title Methods */
	
	/**
	 * Method to Iterate over books and return the book if found
	 * matching the title
	 * 
	 * @see Book#getTitle()
	 * @param title the book String to search for 
	 * @return the Book with a matching title or null if not found
	 */
	private Book scanTitle(String title) {
		for (Book b: books) {
			if(b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}
	
	/** 
	 * Method to find and print a book from books 
	 * searching by the books's title
	 * 
	 * @see scanTitle(String) 
	 * @see Book#display()
	 * */
	private void searchByTitle(String title) {
		Book found = scanTitle(title.trim().toLowerCase());
		if (found != null) {
			found.display();
		} else {
			System.out.println("Could not find a book with title:" + title);
		}
	}
	
	/** 
	 * Method to find and print a book from books 
	 * searching by the book's title
	 * via user input 
	 * 
	 * @see com.helper.CustomReader#read(String) 
	 * @see searchByTitle(String)
	 * */
	private void searchByTitle() {
		searchByTitle(CustomReader.read("Enter the Title:"));
	}

/** Search by Author Methods */

	/**
	 * Method to Iterate over books and return the book if found
	 * matching the author
	 * 
	 * @see Book#getAuthor()
	 * @param author the book String to search for 
	 * @return the Book with a matching author or null if not found
	 */
	private Book scanAuthor(String author) {
		for (Book b: books) {
			if(b.getAuthor().equals(author)) {
				return b;
			}
		}
		return null;
	}
	
	/** 
	 * Method to find and print a book from books 
	 * searching by the books's author
	 * 
	 * @see scanAuthor(String) 
	 * @see Book#display()
	 * */
	private void searchByAuthor(String author) {
		Book found = scanAuthor(author.trim().toLowerCase());
		if (found != null) {
			found.display();
		} else {
			System.out.println("Could not find a book with title:" + author);
		}
	}

	/** 
	 * Method to find and print a book from books 
	 * searching by the book's author
	 * via user input 
	 * 
	 * @see com.helper.CustomReader#read(String) 
	 * @see searchByAuthor(String)
	 * */
	private void searchByAuthor() {
		searchByAuthor(CustomReader.read("Enter the Author:"));
	}

/** Collection Display Methods */
	
	/**
	 * Method to Display All the books sorted by the
	 * BookID
	 * 
	 * @see Book#display()
	 * @see com.book.sort.SortByID
	 */
	private void displayAll() {
		Collections.sort(books, new SortByID());
		for (Book b: books) {
			b.display();
		}
	}

	/**
	 * Method to Display All the books sorted by the 
	 * Book's Title
	 * 
	 * @see Book#display()
	 * @see com.book.sort.SortByTitle
	 */
	private void displaySortByTitle() {
		Collections.sort(books, new SortByTitle());
		for (Book b: books) {
			b.display();
		}
	}

	/**
	 * Method to Display All the books sorted by the 
	 * Book's Author
	 * 
	 * @see Book#display()
	 * @see com.book.sort.SortByAuthor
	 */
	private void displaySortByAuthor() {
		Collections.sort(books, new SortByAuthor());
		for (Book b: books) {
			b.display();
		}
	}

}
