package com.bookutil;

import com.book.BookStore;
import com.helper.CustomReader;

/**
 * Main Class for Question#1
 * 
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class BookUtil {
	/**
	 * @see com.book.BookStore#accept(int)
	 * @see com.helper.CustomReader#readInt(String)
	 * @see com.helper.CustomReader#close()
	 * @param args unused
	 */
	public static void main(String[] args) {
		final String display = "\nWelcome to the BookStore!\n" +
								"Press 1 to add a new Book\n" +
								"Press 2 to find a book by Title\n" +
								"Press 3 to find a book by Author\n" +
								"Press 4 to display all books sorted by bookID\n" + 
								"Press 5 to display all books sorted by title\n" + 
								"Press 6 to display all books sorted by author\n" +
								"Press 7 to Exit";

		try {
			BookStore bookStore = new BookStore();
			int method = 0;
			while(method != 7) {
				System.out.println(display);
				bookStore.accept(CustomReader.readInt("Enter Your Choice: "));
			}
		} finally {
			CustomReader.close();
		}
		
	}
}
