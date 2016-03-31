package com.wq.ch03;

public class BinaryNode<AnyType> {
	AnyType element;
	BinaryNode left;
	BinaryNode right;
	
	BinaryNode(AnyType theElement){
		this(theElement,null,null);
	}
	BinaryNode(AnyType theElement,BinaryNode<AnyType> lf,BinaryNode<AnyType> rt){
		element=theElement;
		left=lf;
		right=rt;
	}
}
