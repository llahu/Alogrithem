package www.algs4.ch02;

public class MergeBU {
	//自底向上的归并排序
	private static Comparable[] aux;//归并所需要的辅助数组。
	public static void sort(Comparable[] a){
		//一共要进行lgN次的两两归并
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz+=sz){//sz子数组的大小
			for(int lo=0;lo<N-sz;lo+=sz+sz){//lo是子数组的索引
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
			
		}
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		// TODO Auto-generated method stub
		int i=lo,j=mid+1;
		for (int k = lo; k <= hi; k++) {
			aux[k]=a[k];
		}
		for (int k = 0; k <=hi ; k++) {
			if(i>mid)  a[k]=aux[j++];
			else if(j>hi)  a[k]=aux[i++];
			else if(less(aux[j],aux[i]))  a[k]=aux[j++];
			else   a[k]=aux[i++];
		}
	}
	public static boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w)<0;
	}
}
