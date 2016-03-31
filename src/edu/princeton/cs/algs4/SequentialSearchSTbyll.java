package edu.princeton.cs.algs4;

import java.util.Iterator;

public class SequentialSearchSTbyll <Key,Value> implements Iterable<Key>{
	
	private class Node{
		//链表结点的定义
		Key key;
		Value value;
		Node next;
		public Node(Key key,Value value,Node next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
	}
	private Node first;//定义链表的首结点
	public Value get(Key key){
		//查找给定的键，返回对应的值
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x)){
				return x.value;
			}
		}
		return null;
	}
	public void put(Key key,Value val){
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x)){
				//表示命中
				x.value=val;
				return;//退出程序
			}
		}
		//如果没有命中
		first=new Node(key,val,first);//新建一个结点
	}
	public int size(){
		int i=0;
		for(Node x=first;x!=null;x=x.next){
			 i++;
			}
		return i;
	}
	public void delete(Key key){
		for(Node x=first;x!=null;x=x.next){
			if(key.equals(x)){
				put(key,null);
			}
		}
	}
	
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
