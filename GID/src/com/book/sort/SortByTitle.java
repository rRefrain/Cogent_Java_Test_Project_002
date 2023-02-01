package com.book.sort;

import java.util.Comparator;

import com.book.Book;

/**
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class SortByTitle implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getTitle().compareTo(o2.getTitle());
	}

}
