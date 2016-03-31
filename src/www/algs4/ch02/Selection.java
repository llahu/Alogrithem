package www.algs4.ch02;

public class Selection {

	public static void sort(Comparable[] a){
		/*主要实现具体的排序算法*/
		//选择排序法
		int N=a.length;//数组的长度
		for(int i=0;i<N;i++){
			//将a[i]和a[i+1...N]中最小的元素进行交换
			int min=i;		//最小元素的索引
			for(int j=i+1;j<N;j++){
				if(less(a[j],a[min])){//a[j]的值确实小
					min=j;
				}
			}
			exch(a,i,min);//交换是在外循环中实现的
		}
	}
	private static boolean less(Comparable v,Comparable w){//判断v和w的大小
		return v.compareTo(w)<=0;
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
//		Integer[] a={12,23,45,6,7,8,2,24};
//		show(a);
//		sort(a);
//		show(a);
//		Character[] c={'q','e','f'};
		char[] chars="cgjhdfjadlmgyuiesccdf".toCharArray();
		Character[] c=new Character[chars.length];
		for (int i = 0; i < chars.length; i++) {
			c[i]=chars[i];
		}
		show(c);
		if(!isSorted(c))
	     	sort(c);		
		show(c);
	}
}
