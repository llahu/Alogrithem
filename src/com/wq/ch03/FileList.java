/*
 *这个例子主要是如何将一个目录中的所的文件全部的打印出来
 * 
 * */


package com.wq.ch03;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileList {
	public void list(File f){
		list(f,0);
	}
	public void list(File f,int depth){
		printName(f,depth);
		if(f.isDirectory()){//判断是否是目录
			File[] files=f.listFiles();//列出文件名
			for(File i: files){
				list(i,depth+1);//再次深入遍历
			}
		}
	}
	public void printName(File f, int depth) {
		// TODO Auto-generated method stub
		String name=f.getName();//获取文件名
		for (int i = 0; i < depth; i++) {
			System.out.print("   ");//产生缩进的效果，用来表示文件的目录级数
		}
		if(f.isDirectory()){//如果是个目录，则打印目录名
			System.out.println("Dir"+name);
		}
		else{
			System.out.println(f.getName()+""+f.length());//否则就是文件。打印文件名和长度
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileList L=new FileList();
		File f=new File("C:/");
		L.list(f);
		List<String> list=new ArrayList<String>();
		list.add("asdd");
		
	}

}
