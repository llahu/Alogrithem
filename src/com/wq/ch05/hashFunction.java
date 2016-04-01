package com.wq.ch05;

public class hashFunction {
	//a sample hash function
	public static int hash1(String key,int tableSize){
		int hashVal=0;
		for(int i=0;i<key.length();i++){
			hashVal+=key.charAt(i);//将字符串中的ascii值依次相加
		}
		return hashVal;
	}
	//another one 
	public static int hash2(String key,int tableSize){
		//只计算前三位，依次在对应位上乘以27、27的平方和27的立方，然后在相加
		return (key.charAt(0)+key.charAt(1)*27+key.charAt(2)*27*27)%tableSize;
	}
	//this is a good one function
	public static int hash3(String key,int tableSize){
		//根据Hornor法则计算一个函数多项式。
		//即X0*37^0+X1*37^1+X2*37^2+X3*37^3+..........依次类推
		int hashVal=0;
		for(int i=0;i<key.length();i++){
			hashVal=hashVal*37+key.charAt(i);
		}
		//判断hashVal是否为负
		if(hashVal<0)
			hashVal=tableSize+hashVal;
		return hashVal;
	}
}
