package com.wq.ch03;

public class MyArrayList<T> implements Iterable<T> {
	private static final int DEFAULT_CAPACITY=10;
	private int theSize;
	private T[] theItems;
	
	//定义构造函数
	public MyArrayList(){
		clear();
	}

	public void clear() {
		// TODO Auto-generated method stub
		theSize=0;
		ensureCapacity(DEFAULT_CAPACITY);//设置容量的大小
		
	}

	public void ensureCapacity(int defaultCapacity) {
		// TODO Auto-generated method stub
		if(defaultCapacity <theSize){
			return;
		}
		T[] old=theItems;
		theItems=(T[])new Object[defaultCapacity];
		for(int i=0;i<size();i++){
			theItems[i]=old[i];
		}
	}

	public int size() {//返回大小
		// TODO Auto-generated method stub
		return theSize;
	}
	public boolean isEmpty(){//判断是否为空
		return theSize==0;
	}
	public void trimToSize(){
		ensureCapacity(theSize);//删除多余的空间给内存
	}
	
	public T get(int idx){
		if(idx<0 || idx>=size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	
	public T set(int idx,T newVal){//set返回的是索引之前的值
		if(idx<0 || idx>=size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		T old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	public boolean add(T x){
		add(size(),x);
		return true;
	}

	public void add(int idx, T x) {
		// TODO Auto-generated method stub
		if(theItems.length==size()){//容量需要扩容了
			ensureCapacity(size()*2+1);
		}
		for(int i=theSize;i>idx;i--){
			theItems[i]=theItems[i-1];
		}
		theItems[idx]=x;
		theSize++;//没添加一个变量，记得给元素个数加1
	}
	public T remove(int idx){
		T removedItem=theItems[idx];
		for (int i = idx; i < size()-1; i++) {
			theItems[i]=theItems[i+1];
		}
		theSize--;
		return removedItem;
	}
	public java.util.Iterator<T> iterator(){
		return new ArrayListIterator();
	}
	private class ArrayListIterator implements java.util.Iterator<T>{
		private int current=0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<size();
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext())//判断是否还有元素存在
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}
		public void remove(){
			MyArrayList.this.remove(--current);//直接删除当前迭代对象的某个迭代值
		}
	}
}
