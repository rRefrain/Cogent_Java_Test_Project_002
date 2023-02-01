package com.lang;

import com.helper.CustomReader;

/**
 * Main Class for Question#2
 * 
 * @author michaelmiranda
 * @date Feb 1 2023
 */
public class Driver {
	/**
	 * Main Class
	 * 
	 * @see getValidAnswer();
	 * @see isJavaYourFavorite();
	 */
	public static void main(String[] args) {
		JavaLang codingInJava 	= new JavaLang();
		CLang 	 codingInC 		= new CLang();
		Thread 	 runningInJava 	= new Thread(codingInJava);
		Thread 	 runningInC 	= new Thread(codingInC);

		if (isJavaYourFavorite(getValidAnswer())) {
			codingInJava.setFavorite(true);
		} else {
			codingInC.setFavorite(true);
		}

		runningInJava.start();
		runningInC.start();

	}

	/**
	 * Helper method to get user input "java" or "c"
	 * @return a String of user input
	 */
	private static String getValidAnswer() {
		String answer = "";
		while (!answer.equals("java") && !answer.equals("c")) {
			answer = CustomReader.read("Enter \"C\" or \"Java\"")
					.trim().toLowerCase();
		}
		return answer;
	}

	/**
	 * Helper method to find out if a user likes Java or not
	 * 
	 * @param answer the answer to check if the user likes Java or not
	 * @return if the user likes java or not
	 */
	private static Boolean isJavaYourFavorite(String answer) {
		if (answer.equals("java")) {
			return true;
		} else {
			return false;
		}
	}
}
