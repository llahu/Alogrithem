package edu.princeton.cs.algs4;

import java.util.Iterator;

public class QueueByNode<Item> implements Iterable {
	private Node first;//指向最早添加的结点的连接
	private Node last;//指向最近添加的结点的连接
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void enqueue(Item item){
		//从队尾添加元素
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.next=null;
		if(isEmpty()) 
			first=last;
		else
			oldlast.next=last;
		N++;
	}
	public Item dequeue(){
		//从队列的队头删除元素
		Item item=first.item;
		first=first.next;
		if(isEmpty())
			last=null;
		N--;
		return item;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
