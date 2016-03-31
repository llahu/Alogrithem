package www.algs4.ch02;

public class Merge {
    //实现一个自顶向下的归并排序
	private static Comparable[] aux;//归并需要的辅助数组
	public static void sort(Comparable[] a){
		aux=new Comparable[a.length];//一次性的分配内存空间
		sort(a,0,a.length);
	}
	private static void sort(Comparable[] a, int lo, int hi) {
		// TODO Auto-generated method stub
		//将数组a[lo,hi]进行排序
		if(hi<=lo) return;
		int mid=lo+(hi-lo)/2;//确定中间的索引
		sort(a,lo,mid);//对前半段进行排序
		sort(a,mid+1,hi);//对后半段进行排序
		merge(a,lo,mid,hi);//每次排完序之后要归并
	}
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		//这个实现的是原地归并排序
		// TODO Auto-generated method stub
		//进行数组的归并
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++){
			aux[i]=a[i];
		}
		for(int k=lo;k<=hi;k++){
			//这里有四个判断：
			/* 1、左半边用尽（取右半边的元素）
			 * 2、右半边用尽（取左半边的元素）
			 * 3、右半边的当前元素小于左半边的当前元素（取右半边的元素）
			 * 4、左半边的当前元素小于右半边的当前元素（取左半边的元素）
			 * */
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(less(aux[j],aux[i])) a[k]=aux[j++];//
			else  a[k]=aux[i++];
		}
	}
	public static boolean less(Comparable v, Comparable w) {
		// TODO Auto-generated method stub
		return v.compareTo(w)<0;
	}
}
