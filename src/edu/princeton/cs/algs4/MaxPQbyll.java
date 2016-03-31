package edu.princeton.cs.algs4;

public class MaxPQbyll<Key extends Comparable<Key>> {
	private Key[] pq;//基于堆的完全二叉树
	private int N=0;//注意我们是从pq[1]开始存储的，pq[0]先不使用
	public MaxPQbyll(int maxN){
		pq=(Key[])new Comparable[maxN+1];//定义数组的大小，注意要加1
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N]=v;//在数组的末尾添加元素
		swim(N);//开始上浮元素
	}
	public void swim(int k){
		while(k>1&&less(k,k/2)){//表示添加的元素比它的父节点的值要大
			exch(k,k/2);
			k=k/2;
		}
	}
	public Key delMax(){
		Key max=pq[1];//第一个元素肯定是最大的
		exch(1,N--);//将第一个元素和最后一个元素交换
		pq[N+1]=null;//此时再将最后一个元素设为null
		sink(1);//开始进行下沉操作
		return max;
	}
	public void sink(int k){
		
		while(k*2<=N){
			int j=k*2;
			if(j<N&&less(j,j+1)) j++;//判断左右结点的大小
			if(less(k,j)){//如果父节点小于子节点
				exch(k,j);
				k=j;
			}
		}
	}
	public boolean less(int i,int j){
		return pq[i].compareTo(pq[j])>0;
	}
	public void exch(int i,int j){
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
}
