package com.ch01;

public class gcd {
	public static int g(int p,int q){
		if(q==0){
			return p;
		}
		int r=p%q;
		return g(q,r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(g(50,6));
	}

}
