package cn.com.leadfar.xml.test;

public class Test {
	
	public  static  void main(String[] args){
		//intTobIG(60);
		//System.out.println((int)'A');
		//toBin2(15);
		System.out.println("123".subSequence(1, 2));
	
	}
	public static   void intTobIG(int num){
		while(num!=0){
			int temp=num&15;
			if(temp>9){
				temp=(char)temp-10+'A';
			}
			System.out.println((char)temp);
			num=num>>>4;
		}
	}
	
	public  static  void toBin(int num){
		int[] cc=new int[16];
		int pos=cc.length;
		while(num!=0){
			int temp=num%2;
			cc[--pos]=temp;
			System.out.println(temp);
			num=num/2;
		}
		for(int x=pos;x<cc.length;x++){
			System.out.println(cc[x]);
		}
	}
	
	public  static  void  toBin2(int num){
		char[] c={'0','1'};
		char[] cc=new char[32];
		int pos=cc.length;
		while(num!=0){
			int temp=num&1;
			cc[--pos]=c[temp];
			num=num>>>1;
		}
		for(int x=pos;x<cc.length;x++){
			System.out.println(cc[x]);
		}
	}
}
