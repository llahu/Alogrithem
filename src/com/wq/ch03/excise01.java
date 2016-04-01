package com.wq.ch03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class excise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s=new HashSet<Integer>();
		s.add(2);
	}
	
	public static<AnyType> void printLots(List<AnyType> L,List<Integer> P){
		Iterator<AnyType> iterL=L.iterator();
		Iterator<Integer> iterP=P.iterator();
		
		AnyType iL=null;
		Integer iP=null;
		int start=0;
		
		while(iterL.hasNext() && iterP.hasNext()){
			iP=iterP.next();   //确定P list中是否还有元素
		}
		while(start<iP && iterL.hasNext()){
			iL=iterL.next();
		}
		System.out.println(iL);
	}

}
