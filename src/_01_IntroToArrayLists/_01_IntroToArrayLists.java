package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> s = new ArrayList<String>();
		//2. Add five Strings to your list
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
		System.out.println("\n");
		//4. Print all the Strings using a for-each loop
		for(String a : s) {
			System.out.println(a);
		}
		System.out.println("\n");
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i < s.size(); i++) {
			if(i%2 == 1) {
				System.out.println(s.get(i));
			}
		}
		System.out.println("\n");
		//6. Print all the Strings in reverse order.
		for(int i = s.size(); i > 0; i--) {
			System.out.println(s.get(i-1));
		}
		System.out.println("\n");
		//7. Print only the Strings that have the letter 'e' in them.
		for(String a : s) {
			if(a.contains("e")) {
				System.out.println(a);
			}
		}
	}
}
