package com.book;

import com.book.exception.InvalidBookException;
import com.helper.CustomReader;

/**
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class Book {
	/** Identifier of a book starting with 'B' and 4 Characters long */
	private String bookID;
	
	/** Title of the book */
	private String title;
	
	/** Author of the book */
	private String author;
	
	/** 
	 * Category of the book which must be 
	 * \"science\" \"fiction\" \"technology\" or \"others\"
	 * */
	private String category;
	
	/** Price of the book */
	private float price;

/** Object Creation Methods */
	
	/***
	 * Default Constructor 
	 * that will create a validate data then 
	 * create a book
	 * 
	 * @see ValidateBookID(String)
	 * @see ValidateCategory(String)
	 * @see ValidatePrice(float)
	 * @see Book(String, String, String, String, float)
	 * @throws InvalidBookException if book parameters are not met
	 */
	public Book(String bookID, String title, 
			String author, String category, float price) throws InvalidBookException {
		super();
		ValidateBookID(bookID.trim());
		ValidateCategory(category.trim().toLowerCase());
		ValidatePrice(price);
		
		this.bookID = bookID.trim();
		this.title = title.trim().toLowerCase();
		this.author = author.trim().toLowerCase();
		this.category = category.trim().toLowerCase();
		this.price = price;
	}
	
	/***
	 * Default Constructor that will create a Book
	 * with user inputs
	 * 
	 * @see com.helper.CustomReader#read(String)
	 * @see com.helper.CustomReader#readFloat(String) 
	 * @see Book(String, String, String, String, float)
	 * @throws InvalidBookException if book parameters are not met
	 */
	public Book() throws InvalidBookException {
		this(CustomReader.read("Enter the BookID: "),
				CustomReader.read("Enter the Title: "),
				CustomReader.read("Enter the Author: "),
				CustomReader.read("Enter the Category: "),
				CustomReader.readFloat("Enter the Price: ")
			);
	}
	
/** Setter Getter Methods */

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		ValidateBookID(bookID);
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		ValidateCategory(category);
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		ValidatePrice(price);
		this.price = price;
	}

/** Validation Methods */

	/**
	 * Class to check if the bookID
	 * start with ‘B’ and must be of length 4 characters
	 * 
	 * @param bookID the field to validate
	 * @throws InvalidBookException if book parameters are not met
	 */
	private void ValidateBookID(String bookID) throws InvalidBookException{
		if (bookID == null || bookID.length() != 4 || bookID.charAt(0) != 'B') {
			throw new InvalidBookException(
					"bookID must start with ‘B’ and must be of length 4 characters");
		}
	}

	/**
	 * Class to check if the category
	 * is "science" "fiction" "technology" or "others"
	 * 
	 * @param category the field to validate
	 * @throws InvalidBookException if book parameters are not met
	 */
	private void ValidateCategory(String category) throws InvalidBookException{
		if (!category.equals("science") &&
				!category.equals("fiction") &&
				!category.equals("technology") &&
				!category.equals("others")) {
			throw new InvalidBookException(
					"Category must be \"science\" \"fiction\" \"technology\" or \"others\"! ");
		}
	}

	/**
	 * Class to check if the price
	 * is postive
	 * 
	 * @param price the field to validate
	 * @throws InvalidBookException if book parameters are not met
	 */
	private void ValidatePrice(float price) throws InvalidBookException{
		if (price < 0) {
			throw new InvalidBookException(
					"Price cannot be negative");
		}
	}

/** To String and Display Methods */

	/** Class to print out this objects toString() */
	public void display() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Title is: " + title + "\tBookID: =" + bookID + "\nBy: " + author + "\nUnderneath: " + category
				+ "\nPrice:" + price + "\n";
	}

}
