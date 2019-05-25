package com.example.stack;

/*
 * ·Ö¸ô·û¼ì²é
 */
public class BracketCheck {

	private String input;
	
	public BracketCheck(String input) {
		this.input = input;
	}
	
	public void check() {
		int maxSize = input.length();
		StackX stack = new StackX(maxSize);
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (!stack.isEmpty()) {
					int chx = stack.pop();
					if ((chx != '{' && ch == '}')
							|| (chx != '[' && ch == ']')
							|| (chx != '(' && ch == ')')) {
						System.out.println("Error: " + ch + " at " + i);
					} 
				} else {
					System.out.println("Error: " + ch + " at " + i);
				}
				break;
			default:
				break;
			}
		}
		
		if (!stack.isEmpty()) {
			System.out.println("Error: missing right delimiter");
		}
	}
	
}
