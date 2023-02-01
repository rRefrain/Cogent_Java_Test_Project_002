package com.lang;

/**
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class JavaLang implements Language, Runnable {
	/** Flag to check whether or not this thread will yield() */
	private boolean favorite = false;

	/** 
	 * Method to set the favorite flag
	 * @param favorite the flag to override the current flag
	 */
	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	@Override
	public void showMessage() {
		System.out.println("Java Program is running");
	}

	@Override
	public void run() {
		if (!favorite) {
			Thread.yield();
		}
		showMessage();
	}

}
