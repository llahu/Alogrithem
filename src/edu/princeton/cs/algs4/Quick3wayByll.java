package edu.princeton.cs.algs4;

public class Quick3wayByll {
	private static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int lt=lo,i=lo+1,rt=hi;
		Comparable v=a[lo];//切分元素
		while(i<=rt){
			int cmp=a[i].compareTo(v);//将元素与切分元素进行比较
			if(cmp<0) exch(a,lt++,i++);
			else if(cmp>0) exch(a,i,rt--);
			else i++;
		}
		sort(a,lo,lt-1);
		sort(a,rt+1,hi);
		
		while(current<=end){//解决荷兰旗的问题。
			if(a[current]<a[begin]){
				int temp=a[current];
				a[current]=a[begin];
				a[begin]=temp;
				current++;
				begin++;
			}
			else if(a[current]>a[end]){
				exch(a,current,end);
				end--;
			}
			else{
				current++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
