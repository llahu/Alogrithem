package www.algs4.ch02;

public class Shell {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a){
		/*主要实现具体的排序算法*/
		//希尔排序法
		int N=a.length;
		int h=1;//h为子数组的距离
		while(h<N/3){//选择合适的子数组距离
			h=h*3+1;    //h=1,4,13,40,121,.....
		}
		while(h>=1){
			//对子数组使用插入排序
			for(int i=h;i<N;i++){
				//将a[i]插入到是a[i-h],a[i-h*2],a[i-h*3]....之中
				for(int j=i;j>=h&&less(a[j], a[j-h]);j-=h){
					exch(a,j,j-h);
				}
			}
			h=h/3;//记得缩小子数组的距离
		}
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
