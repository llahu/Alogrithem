package www.algs4.ch02;

import java.util.Random;

public class SortCompare {//测试不同排序算法的用时
	public static double time(String alg,Double[] a){
		Stopwatch timer=new Stopwatch();//定义一个计时器
		if(alg.equals("Insertion")) 
			Insertion.sort(a);
		if(alg.equals("Selection"))
			Selection.sort(a);
		if(alg.equals("Shell"))
			Shell.sort(a);
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg,int N,int T){
		//使用alg算法将T个长度为N的数组进行排序
		double total=0.0;
		Double[] a=new Double[N];
		Random random=new Random(System.currentTimeMillis());
		for (int t = 0; t < T; t++) {//一共做了T次测试
			//进行一次测试（生成一个数组并进行排序）
			for(int i=0;i<N;i++){
				a[i]=random.nextDouble();
			}
			total+=time(alg,a);
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alg1=args[0];
		String alg2=args[1];
		int N=Integer.parseInt(args[2]);
		int T=Integer.parseInt(args[3]);
		double t1=timeRandomInput(alg1, N, T);//算法1的耗时
		double t2=timeRandomInput(alg2, N, T);//算法1的耗时
		System.out.printf("for %d random doubles\n %s is ",N,alg1);
		System.out.printf("%.1f times faster than %s\n",t2/t1,alg2);
		
	}

}
