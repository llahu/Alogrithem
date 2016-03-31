package com.wq.ch03;

public class BinarySearchTree<T extends Comparable<? super T>> {
	//内嵌一个二叉节点的内部类
	private static class BinaryNode<T>{
		T element;
		BinaryNode<T> left;//左子树
		BinaryNode<T> right;//右子树
		
		BinaryNode(T theElement){//含参构造器来初始化节点
			this(theElement,null,null);
		}
		BinaryNode(T theElement,BinaryNode<T> lf,BinaryNode<T> rt)
		{
			element=theElement;
			left=lf;
			right=rt;
		}
	}
	private BinaryNode<T> root;//定义根节点
	
	public BinarySearchTree() {//二叉树类的构造器
		// TODO Auto-generated constructor stub
		root=null;
	}
	public void makeEmpty(){//清空二叉查找树类
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public boolean contains(T x){//从根节点开始查询，是否包含x值
		return contains(x,root);
	}
	public boolean contains(T x, BinaryNode<T> t) {//从t节点开始查询
		//某个树是否包含值为x的节点。
		// TODO Auto-generated method stub
		if(t==null)
			return false;
		int compareResult=x.compareTo(t.element);//比较x值与节点值的大小
		if(compareResult<0)//小于在左树
			return contains(x,t.left);
		else if(compareResult >0)//大于在右树
			return contains(x,t.right);
		else//相等则表示正好匹配
			return true; //Match
	}
	public T find( T x )
    {
        return elementAt( find( x, root ) );
    }
    private BinaryNode<T> find( T x, BinaryNode<T> t )
    ///从t节点开始查询某个树是否包含值为x的节点。如果匹配了就
    //返回这个节点对象。这里用到了递归，直到将树中所有的节点
    //遍历完为止。
    {
        if( t == null )
            return null;
        if( x.compareTo( t.element ) < 0 )
            return find( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            return find( x, t.right );
        else
            return t;    // Match
    }
	private T elementAt(BinaryNode<T> t) {
		// 返回对应节点的数值
		return t == null ? null : t.element;
	}
	

	
	public T findMin(){//找出最小的值
		if(isEmpty())
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return findMin(root).element;
	}
	public BinaryNode<T> findMin(BinaryNode<T> t) {
		//找出最小值的结点位置，最小值只会出现在左节点处
		// TODO Auto-generated method stub
		if (t==null)
			return null;
		else if(t.left==null)
			return  t;
		return findMin(t.left);
	}
	
	public T findMax(){//找出最大的值
		if(isEmpty())
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return findMax(root).element;
	}

	public BinaryNode<T> findMax(BinaryNode<T> t) {
		//找出最大值的结点位置，最大值只会出现在右节点处
		// TODO Auto-generated method stub
//		if (t==null)
//			return null;
//		else if(t.right==null)
//			return  t;
//		return findMin(t.right);
		if(t!=null){//这里不使用递归，改为使用循环
			while(t.right!=null){
				t=t.right;
			}
		}
		return t;
	}
	 public void insert( T x )
     {
         root = insert( x, root );
     }

   	private BinaryNode<T> insert(T x,BinaryNode<T> t){//t引用的是根节点
   		if(t==null){
   			return new BinaryNode<T>(x, null, null);
   		}
   		int compareResult=x.compareTo(t.element);//比较与节点元素的大小
   		if(compareResult<0){//如果值比该节点的值小，就放在左子树
   			t.left=insert(x,t.left);
   		}else if (compareResult>0){//如果值比该节点的值大，就放在右子树
   			t.right=insert(x,t.right);
   		}
   		else{//相等就什么也不做
   			;//什么都不做
   		}
		return t;
   		
   	}
   	
    public void remove( T x )
    {
        root = remove( x, root );
    }
   	private BinaryNode<T> remove(T x,BinaryNode<T> t){
   		if(t==null)
   			return t ;//表示没有找到Item。所以什么也不做
   		int compareResult =x.compareTo(t.element);//将与节点的值做比较
   		if(compareResult<0){
   			t.left=remove(x,t.left);//开始向左树遍历
   		}
   		else if(compareResult>0){
   			t.right=remove(x,t.right);//向右树遍历
   		}
   		else if(t.left!=null && t.right!=null){//有两个子节点的情况
   			t.element=findMin(t.right).element;
   			t.right=remove(t.element,t.right);
   		}
   		else{
   			t=(t.left!=null) ? t.left:t.right;//只有一个子节点的情况
   		}
		return t;
   		
   	}
   	
   	public void printTree(){
   		if(isEmpty()){
   			System.out.println("Empty Tree");
   		}
   		else{
   			printTree(root);//打印节点的信息
   		}
   	}
	private void printTree(BinaryNode<T> t) {
		// 打印树是先从左树开始遍历的。这里又使用了递归的操作
		if(t!=null){
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	



    // Test program
public static void main( String [ ] args )
{
    BinarySearchTree t = new BinarySearchTree( );
    final int NUMS = 4000;
    final int GAP  =   37;

    System.out.println( "Checking... (no more output means success)" );

    for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
        t.insert( new Integer( i ) );

    for( int i = 1; i < NUMS; i+= 2 )
        t.remove( new Integer( i ) );

   // if( NUMS < 40 )
        t.printTree( );
    if( ((Integer)(t.findMin( ))).intValue( ) != 2 ||
        ((Integer)(t.findMax( ))).intValue( ) != NUMS - 2 )
        System.out.println( "FindMin or FindMax error!" );

    for( int i = 2; i < NUMS; i+=2 )
         if( ((Integer)(t.find( new Integer( i ) ))).intValue( ) != i )
             System.out.println( "Find error1!" );

    for( int i = 1; i < NUMS; i+=2 )
    {
        if( t.find( new Integer( i ) ) != null )
            System.out.println( "Find error2!" );
    }
}
}
