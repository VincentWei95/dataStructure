package com.example.stack;

public class Main {

	/**
	 * 有效的括号序列：
	 *
	 * 给你一个括号序列，里面包含小括号，中括号和大括号。你要判断这个括号序列是否有效。
	 * 有效的括号序列要求，每个左括号都必须有一个同类的右括号与它正确配对。另外，空字符串认为是有效的括号序列
	 *
	 * 比如说，给你的序列是：
	 *
	 * ()[]{}
	 *
	 * 小括号/中括号/大括号的左右括号都能正确配对，因此这是一个有效的括号序列
	 *
	 * 再比如说给你的序列是：
	 *
	 * ([)]
	 *
	 * 这里面虽然正好有一对小括号和一对中括号，但它们的顺序不对，括号间无法正确配对，因此这不是一个有效的括号序列
	 *
	 * 再比如给你的序列是：
	 *
	 * [()]
	 *
	 * 则是一个有效的括号序列
	 */
	public static void main(String[] args) {
		Main main = new Main();
		System.out.println(main.isValid("()[]{}"));
		System.out.println(main.isValid("([)]"));
	}

	private boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) return false;

				char top = stack.pop();
				if (top == '(' && c != ')') return false;
				if (top == '[' && c != ']') return false;
				if (top == '{' && c != '}') return false;
			}
		}
		return stack.isEmpty();
	}
}
