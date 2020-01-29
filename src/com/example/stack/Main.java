package com.example.stack;

public class Main {

	/**
	 * ��Ч���������У�
	 *
	 * ����һ���������У��������С���ţ������źʹ����š���Ҫ�ж�������������Ƿ���Ч��
	 * ��Ч����������Ҫ��ÿ�������Ŷ�������һ��ͬ���������������ȷ��ԡ����⣬���ַ�����Ϊ����Ч����������
	 *
	 * ����˵������������ǣ�
	 *
	 * ()[]{}
	 *
	 * С����/������/�����ŵ��������Ŷ�����ȷ��ԣ��������һ����Ч����������
	 *
	 * �ٱ���˵����������ǣ�
	 *
	 * ([)]
	 *
	 * ��������Ȼ������һ��С���ź�һ�������ţ������ǵ�˳�򲻶ԣ����ż��޷���ȷ��ԣ�����ⲻ��һ����Ч����������
	 *
	 * �ٱ������������ǣ�
	 *
	 * [()]
	 *
	 * ����һ����Ч����������
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
