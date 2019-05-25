package com.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
//		Stack stack = new Stack(10);
//		stack.push(20);
//		stack.push(40);
//		stack.push(60);
//		stack.push(80);
//		
//		while (!stack.isEmpty()) {
//			System.out.println(stack.pop());
//		}
		
//		String input = null;
//		String output = null;
//		while (true) {
//			System.out.print("Enter a string: ");
//			System.out.flush();
//			input = getString();
//			if (input.equals("")) 
//				break;
//			
//			ReverseObj reverseObj = new ReverseObj(input);
//			output = reverseObj.reverse();
//			System.out.println("Reversed: " + output);
//		}
		
		String input = null;
		while (true) {
			System.out.print("Enter a bracket: ");
			System.out.flush();
			input = getString();
			if (input.equals(""))
				break;
			
			BracketCheck check = new BracketCheck(input);
			check.check();
		}
	}
	
	private static String getString() {
		String s = null;
		try {
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(reader);
			s = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

}
