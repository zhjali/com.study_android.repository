package homeWork3m3.demo01;

interface A {
	void hello();
}

public class Test03 {
        int a;
        int b;
        int c;
        
        public int ini(){
//        	System.out.println("function");
        	return 12;
        }
        //构造代码块先于构造函数运行，对全部对象进行统一的操作，构造函数对特例。
        {
        	int d = 10;
        	System.out.println(d);
        	b = 45;
           System.out.println("nihao");
        	c = ini();
        }
        
        //静态代码块先于main函数执行
        static{
//            System.out.println("static");
        }
        public Test03(){
        	System.out.println(b);
        	System.out.println(a);
        	a = 3;
        	System.out.println(b);
        	System.out.println(c);
        }

	public static void main(String[] args) {
			Test03 t = new Test03();
	}
}
