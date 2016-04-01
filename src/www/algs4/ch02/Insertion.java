package www.algs4.ch02;

public class Insertion {

	public static void sort(Comparable[] a){
		/*主要实现具体的排序算法*/
		//插入排序，按照a[]的升序排列
		int N=a.length;
		for(int i=1;i<N;i++){//从索引为1的元素开始
			//a[i]插入到a[i-1],a[i-2]...之中
			for(int j=i;j>=1&&less(a[j],a[j-1]);j--){//判断的条件是当前的值是否比前面的索引值要小
				exch(a,j,j-1);//交换元素值
			}
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
		Integer[] a={12,23,45,6,7,8,2,24};
		show(a);
		sort(a);
		show(a);
//		Character[] c={'q','e','f'};
//		char[] chars="cgjhdfjadlmgyuiesccdf".toCharArray();
//		Character[] c=new Character[chars.length];
//		for (int i = 0; i < chars.length; i++) {
//			c[i]=chars[i];
//		}
//		show(c);
//		if(!isSorted(c))
//	     	sort(c);		
//		show(c);
	}
}
