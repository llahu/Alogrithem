package com.wq.ch05;

import java.util.LinkedList;
import java.util.List;

public class SeperateChainingHashTable<AnyType> {
	private static final int DEFAULT_TABLE_SIZE=101;//表示数组的大小
	private List<AnyType>[] theLists;//定义一个链表数组
	private int currentSize;
	 
	public SeperateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
    public SeperateChainingHashTable(int size){
		theLists=new LinkedList[nextPrime(size)];//初始化一个链表数组对象
		for(int i=0;i<theLists.length;i++){
			theLists[i]=new LinkedList<AnyType>();//对每一个数组的元素实例化一个链表
		}
	}
    
    public void insert(AnyType x){
    	List<AnyType> whichList=theLists[myhash(x)];
    	if(!whichList.contains(x)){
    		whichList.add(x);
    		
    		if(++currentSize>theLists.length){//如果链表数组的大小不够大了，则需要重新计算hash值
    			rehash();
    		}
    	}
    }
    public void remove(AnyType x){
    	List<AnyType> whichList=theLists[myhash(x)];//myhash(x)返回哈希值，并根据hash值来确定在链表数组中的位置
    	if(!whichList.contains(x)){
    		whichList.remove(x);
    		currentSize--;
    	}
    }
 
    public boolean contains(AnyType x){
    	//myhash()返回的值是某个hash值。whichList对应着theLists数组这个值的位置
    	List<AnyType> whichList=theLists[myhash(x)];
    	
    	return whichList.contains(x);//调用List接口的contains方法。
    }    
    
    public void makeEmpty(){
    	for(int i=0;i<theLists.length;i++){
    		theLists[i].clear();
    	}
    	currentSize=0;
    }
    
    private void rehash(){//在哈希方法
    	
    }
    
    //用来计算hash值的方法
    private int myhash(AnyType x){
    	int hashVal=x.hashCode();//获取哈希码
    	hashVal%=theLists.length;
    	if(hashVal<0)
    		hashVal+=theLists.length;
		return hashVal;
    	
    }
    
    /**
     * Internal method to find a prime number at least as large as n.
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime(int n){//查找最大的素数
    	  if( n % 2 == 0 )
              n++;
          for( ; !isPrime( n ); n += 2 )
              ;
          return n;
    }
    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime(int n){//判断是否是素数

        if( n == 2 || n == 3 )
            return true;
        if( n == 1 || n % 2 == 0 )
            return false;
        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;
        return true;
    	
    }
}
