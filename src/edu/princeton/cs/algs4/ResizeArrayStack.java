package edu.princeton.cs.algs4;

import java.util.Iterator;

//能够动态的调整数组大小实现的下压栈
public class ResizeArrayStack<Item> implements Iterable<Item> {
	private Item[] a=(Item[])new Object[1];//栈元素
	private int N=0;      //元素的数量
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	private void resize(int max){
		//将栈移动到一个大小为max的新数组中
		Item[] temp=(Item[])new Object[max];
		for (int i = 0; i <	N; i++) {
			temp[i]=a[i];
		}
		a=temp;//指向新数组的引用
	}
	public void push(Item item){
		//添加元素到栈顶
		if(N==a.length)
			resize(2*a.length);
		a[N++]=item;
	}
	public Item pop(){
		Item item=a[--N];
		a[N]=null;//避免对象的游离
		if(N>0&&N==a.length/4){
			resize(a.length/2);
		}
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverArrayIterator();
	}
	private class ReverArrayIterator implements Iterator<Item>{
		private int i=N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}
		public void remove(){
			
			
			
		}
		
	}
}
