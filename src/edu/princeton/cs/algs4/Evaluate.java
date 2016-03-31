package edu.princeton.cs.algs4;

public class Evaluate {
//Dijlstra的双栈算术表达式求值算法
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> ops=new Stack<String>();//运算符栈
		Stack<Double> vals=new Stack<Double>();//运算数栈
		while(!StdIn.isEmpty()){//除非表达式结束
			//读取字符，如果是运算符则压入栈中
			String s=StdIn.readString();
			if(s.equals("("))   ;
			else if(s.equals("+")) ops.push(s);
			else if(s.equals("-")) ops.push(s);
			else if(s.equals("*")) ops.push(s);
			else if(s.equals("/")) ops.push(s);
			else if(s.equals("sqrt")) ops.push(s);
			else if(s.equals(")")) {
				String op=ops.pop();//遇到）就弹出运算符
				double v=vals.pop();//弹出操作数
				if(op.equals("+")) v=v+vals.pop();
				else if(op.equals("-")) v=vals.pop()-v;
				else if(op.equals("*")) v=vals.pop()*v;
				else if(op.equals("/")) v=vals.pop()/v;
				else if(op.equals("sqrt")) v=Math.sqrt(v);
				vals.push(v);
			}
			else{
				vals.push(Double.parseDouble(s));
			}
		}
		StdOut.println(vals.pop());
	}

}
