package edu.princeton.cs.algs4;

import java.util.Iterator;

public class StackByNode<Item> implements Iterable<Item> {
	private Node first;//栈顶
	private int N; //元素数量
	private  class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first==null;  //或者N==0
	}
	public int size(){
		return N;
	}
	public void push(Item item){
		//向栈顶添加元素
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;  //元素的数量加1
	}
	public Item pop(){
		//从栈顶删除元素
		Item item=first.item;
		first=first.next;
		N--;  //元素的数量减1
		return item;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current=first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item=current.item;
			current=current.next;
			return item;
		}
		
	}
}
