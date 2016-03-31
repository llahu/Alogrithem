package www.algs4.ch02;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way {
	private static void sort(Comparable[] a){
		sort(a,0,a.length-1);
	}
	private static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int lt=lo,i=lt+1,gt=hi;
		Comparable v=a[lo];
		while(i<=gt){
			int cmp=a[i].compareTo(v);
			if(cmp<0) exch(a,lt++,i++);
			else if(cmp>0) exch(a,i,gt--);
			else
				i++;
		}//现在a[lo...lt]<v=a[lt...gt]<a[gt+1...hi]
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	private static void exch(Object[] a, int i, int j) {
		// TODO Auto-generated method stub
		Object temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	char[] chars="cgjhdfjadlmgyuiesccdf".toCharArray();
		Character[] a=new Character[chars.length];
		//show(a);
		for (int i = 0; i < chars.length; i++) {
			a[i]=chars[i];
			System.out.print(a[i]+" ");
		}
		System.out.println();
        Quick3way.sort(a);
        show(a);

        // shuffle
   
	}
	private static void show(Character[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
