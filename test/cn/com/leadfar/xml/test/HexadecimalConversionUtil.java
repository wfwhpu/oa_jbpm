package cn.com.leadfar.xml.test;

public class HexadecimalConversionUtil {
	
	public  static  void main(String[] args){
		//二进制
		String b=Integer.toBinaryString(60);
		//十六进制
		String h=Integer.toHexString(60);
		//八进制
		String o=Integer.toOctalString(60);
	
		System.out.println("b====="+b);
		System.out.println("h====="+h);
		System.out.println("o====="+o);

	}
	
	//转换为二进制
	public static  String toBin(int num,int offset,int pos){
		return trans(num,offset,pos);
	}
	//转换为十六进制
	public static String toHex(int num,int offset,int pos){
		return trans(num,offset,pos);
		
	}
	//转换为八进制
	public static  String toOct(int num,int offset,int pos){
		return trans(num,offset,pos);
	}
	public static  String trans(int num, int offset, int pos) {
		if(num==0){
			return "0";
		}
		char[] cc = new char[32];
		int index = cc.length;
		char[] arr = new char[] {
				'0', '1', '2', '3',
				'4', '5', '6', '7', 
				'8','9', 'A', 'B', 
				'C', 'D', 'E', 'F' 
				};
		while(num!=0){
			int temp=num&offset;
			cc[--index]=arr[temp];
			num=num>>>pos;
		}
		return new String(cc,index,cc.length-index);
	}
}
