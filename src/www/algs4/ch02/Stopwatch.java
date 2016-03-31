package www.algs4.ch02;

public class Stopwatch {//一个表示计时器的抽象数据类型
	private final long start;

	public Stopwatch() {//创建一个计时器
		start=System.currentTimeMillis();//获取当前的系统时间
	}
	public double elapsedTime(){//返回经历的时间
		long now=System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}
