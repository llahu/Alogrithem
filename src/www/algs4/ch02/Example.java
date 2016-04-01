package www.algs4.ch02;

public class Example {
	public static void sort(Comparable[] a){
		/*主要实现具体的排序算法*/
	}
	private static boolean less(Comparable v,Comparable w){//判断v和w的大小
		return v.compareTo(w)<0;
	}
	//
	private static void exch(Comparable[] a,int i,int j){
		//将指定数组的指定索引位置i,j上的元素进行互换
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable[] a){//打印数组
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	private static boolean isSorted(Comparable[] a){
		for (int i = 1; i < a.length; i++) {
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
