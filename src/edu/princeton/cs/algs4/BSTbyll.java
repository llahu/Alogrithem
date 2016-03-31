package edu.princeton.cs.algs4;

public class BSTbyll<Key extends Comparable<Key>,Value > {
	private class Node{  //定义结点类
		private Key key;
		private Value val;
		private Node left,right;
		private int N;
		public Node(Key key,Value val,int N){
			this.key=key;
			this.val=val;
			this.N=N;
		}
		
	}
	private Node root;//定义二叉查找树的根节点
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x==null) return 0;
		else return x.N;
	} 
	public Value get(Key key){
		return get(root,key);
	}
	public Value get(Node x,Key key){
		//在以x为根节点的子树中查找，并返回key所对应的值
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp>0) //在右子树中
			return get(x.right,key);
		else if(cmp<0)//在左子树中
			return get(x.left,key);
		else 
			return x.val;
		
	}
	public void put(Key key,Value val){
		root=put(root,key,val);
	}
	public Node put(Node x,Key key,Value val){
		//如果key键存在，则跟新它的值，否则将key与val作为
		//新的结点插入到子树中
		if(x==null) return new Node(key,val,1);
		int cmp=key.compareTo(x.key);
		if(cmp>0) //说明在右子树中
			x.right=put(x.right,key,val);
		else if(cmp<0)
			x.left=put(x.left,key,val);
		else
			x.val=val;
		x.N=size(x.left)+size(x.right)+1;//计算结点的个数
		return x;
		
	}
	public Key min(){
		return min(root).key;
	}
	public Node min(Node x){
		if(x.left==null) return x;//说明此时根节点就是最小的结点
		return min(x.left);//一直向左子树遍历
	}
	
	public Key floor(Key key){
		Node x=floor(root,key);
		if(x==null) return null;
		return x.key;
	}
	private Node floor(Node x,Key key){
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp==0) return x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
