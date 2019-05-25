package com.example.stack;

/*
 * µ¥´ÊÄæÐò 
 */
public class ReverseObj {
	
	private String input;
	private String output;
	
	public ReverseObj(String input) {
		this.input = input;
	}
	
	public String reverse() {
		int maxSize = input.length();
		StackX stack = new StackX(maxSize);
		
		for (int i = 0; i < input.length(); i++) {
			char in = input.charAt(i);
			stack.push(in);
		}
		
		output = "";
		while (!stack.isEmpty()) {
			output += stack.pop();
		}
		
		return output;
	}

}
