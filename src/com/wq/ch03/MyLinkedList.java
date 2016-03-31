package com.wq.ch03;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	private int theSize;
	private int modCount=0;//表示从构造以来对链表的操作次数
	private Node<T> beginMarker;//定义头节点
	private Node<T> endMarker;//定义尾节点
	
	//定义内部Node结点类
	private static class Node<T>{
		
		 public T data;//为节点存储的数据
		 public Node<T> prev;//指向前一个节点的链
		 public Node<T> next;//指向后一个节点链
		 public Node(T d,Node<T> p,Node<T> n){//Node类的构造器
			 data=d;
			 prev=p;
			 next=n;
		 }
	 }
	 
	 public MyLinkedList(){ //定义一个无参构造器
		 clear();
	 }

	public void clear() {
		// TODO Auto-generated method stub
		beginMarker=new Node<T>(null, null, null);//初始化头结点
		endMarker=new Node<T>(null,beginMarker,null);//初始化尾节点
		beginMarker.next=endMarker;//将两个节点连接在一起，此时的链表称之为空链表，所以theSize才会等于0
		theSize=0;
		modCount++;//执行一次操作就加1
	}
	
	//返回节点的个数
	public int size(){
		return theSize;
	} 
	
	public boolean isEmpty(){
		return size()==0;
	}
	public boolean add(T x){
		add(size(),x);
		return true;
	}

	public void add(int idx, T x) {
		// TODO Auto-generated method stub
		addBefore(getNode(idx),x);
		
	}
	//获取当前索引的节点对象的data元素值
	public T get(int idx){
		return getNode(idx).data;
	}
	
	//设置当前索引的节点对象的data元素值
	public T set(T x,int idx){
		Node<T> p=getNode(idx);
		T oldVal=p.data;
		p.data=x;
		return oldVal;
	}
	//删除某个索引的节点，首先要先获得这个索引的节点对象。
	public T remove(int idx){
		return remove(getNode(idx));
	}
	
	//在某一个节点前面添加一个节点
	private void addBefore(Node<T> p, T x) {
		// TODO Auto-generated method stub
		Node<T> newNode=new Node<T>(x, p.prev, p);//在p节点前面添加一个新节点来存储x元素
		newNode.prev.next=newNode;
		p.prev=newNode;
		theSize++;//添加一个节点，所以要加1
		modCount++;
	}
	
	//删除指定的节点p，返回p节点存储的元素值
	private T remove(Node<T> p){
		p.prev.next=p.next;
		p.next.prev=p.prev;
		theSize--;
		modCount++;
		return p.data;

	}
	//是否包含某个值
	private boolean contains(int data){
		Node p=beginMarker;
		for(int i=0;i<size();i++){
			if((int)p.data!=data){
				p=p.next;
			}else{
				return true;
			}
		}
		return false;	
	}
	
	//获取当前索引的节点的对象
	private Node<T> getNode(int idx) {
		// TODO Auto-generated method stub
		Node<T> p;
		if(idx<0 || idx>size())//首先判断索引的合理性
			throw new IndexOutOfBoundsException();
		//使用了折半的方法来遍历链表
		if(idx<size()/2){
			p=beginMarker.next;
			for (int i = 0; i < idx; i++) {
				p=p.next;
			}
		}
		else{
			p=endMarker;
			for(int i=size();i>idx;i--){
				p=p.prev;
			}
		}
		return p;//返回节点的对象
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
