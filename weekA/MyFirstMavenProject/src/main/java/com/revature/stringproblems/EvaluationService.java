package com.revature.stringproblems;

import java.util.Arrays;

public class EvaluationService {
	
	public static void main(String[] args) {
		System.out.println(acronym("      Portable    Network  Graphics"));
		System.out.println(getScrabbleScore("Cabbage"));
		System.out.println(cleanPhoneNumber("1 (634) 554 - 4928"));
		
		System.out.println(cheekyStringLength("hello!"));

	}
	
	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public static String acronym(String phrase) {
		String out = "";
		for(String word : phrase.trim().split(" ")) {
			if(word.length()>0) {
				out = out + word.charAt(0);
			}
		}
		
		return out.toUpperCase();
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public static int getScrabbleScore(String string) {
		int out = 0;
		
		for(String character : string.toUpperCase().split("")) {
			switch(character.charAt(0)) {
			case 'A':
			case 'E':
			case 'I':
				out += 1;
				break;
			case 'D':
			case 'G':
			case 'C':
				out += 3;
				break;
			}
		}
		
		return out;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public static String cleanPhoneNumber(String string) {
		String cleanNumber = "";
		
		String[] validDigits = {"0","1","2","3","4","5","6","7","8","9"};
		Arrays.sort(validDigits);
		
		for(String character : string.split("")) {
			if (Arrays.binarySearch(validDigits, character) >= 0) {
				cleanNumber = cleanNumber + character;
			}
		}
		
		if(cleanNumber.length() == 11) {
			return cleanNumber.substring(1);
		} else {
			return cleanNumber;
		}
	}
	
	public static int cheekyStringLength(String str) {
		int length = 0;
		while(true) {
			try {
				str.charAt(length);
				length++;
			} catch (Exception e) {
				break;
			}
		}
		return length;
	}

}
