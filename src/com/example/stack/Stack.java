package com.example.stack;

import com.example.array.DynamicArray;

/**
 * 栈，先进后出，只能在栈顶进行插入和删除操作
 */
public class Stack<E> {
	private DynamicArray<E> array;

	public Stack(int capacity) {
		array = new DynamicArray<>(capacity);
	}

	public Stack() {
		array = new DynamicArray<>();
	}

	public void push(E e) {
		array.addLast(e);
	}

	public E pop() {
		return array.removeLast();
	}

	// 查看栈顶的元素
	public E peek() {
		return array.getLast();
	}

	public int getSize() {
		return array.getSize();
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

	public int getCapacity() {
		return array.getCapacity();
	}

	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("Stack: ");
		res.append('[');
		for(int i = 0 ; i < array.getSize() ; i ++){
			res.append(array.get(i));
			if(i != array.getSize() - 1)
				res.append(", ");
		}
		res.append("] top");
		return res.toString();
	}
}
