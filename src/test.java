import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test {

	//计算代码	
	
	public  void writeTXT(String content){
		String path = "C:\\Users\\cendler\\eclipse-workspace\\Myapp";
		String title = "Answer";
		try {
	        // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
	        /* 写入Txt文件 */
	        File writename = new File(path);// 相对路径，如果没有则要建立一个新的output。txt文件
	        if(!writename.exists()){
	            writename.mkdirs();
	        }
	        writename = new File(path+"\\"+title+".txt");// 相对路径，如果没有则要建立一个新的output。txt文件
	        writename.createNewFile(); // 创建新文件
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
	        out.write(content); // \r\n即为换行
	        out.flush(); // 把缓存区内容压入文件
	        out.close(); // 最后记得关闭文件

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
public double testOperation(String s){

		//Scanner sc = new Scanner(System.in);

		//为了方便测试，没有用Scanner，用的话应该String s = sc.next();就能从控制台输入内容

		//String s ="10-2*2/2+4+3*4/4+1";

		//将加号替换成减号，不能用减号替换加号，因为正则表达式的原因，这里就不多赘述

		String s1 =s.replace("+","-");

		//分割字符然后放进数组

		String[] str = s1.split("-");

		//这里初始化加减结果

		double total1=0;

		//这里是查看切割后的结果，我们来看下结果：[10, 2*2/2, 4, 3*4/4, 1]，截取出来就是这个样子。

		//System.out.println(Arrays.toString(str));

		//然后我们来操作数组，把里面的乘除结果算出来，先遍历数组

		for(String str1:str){

			//System.out.print(str1);

			//判断是否含有乘或除

			if(str1.contains("*")||str1.contains("/")){

				//乘除结果

				double total = 0;

				//将有乘或除的字符串遍历

				for(int i =0;i<str1.length();){

					//截取字符串的变化长度

					int count =1;

					//遍历后面的每一个字符

					a:for(int j =i+1;j<str1.length();j++){

						//截取字符

						char c =str1.charAt(j);

						//判断是否是乘或除

						if(c=='*'||c=='/'){

							break a;

						}else{

							count++;

						}

					}

					

					//将数字截取出来

					String s2 =str1.substring(i,i+count);

					//转为小数

					double d = Double.parseDouble(s2);

					if(i==0){

						//将第一个数变为初始值

						total = d;

					}else{

						char c1 = str1.charAt(i-1);

						//判断数字前面的是乘或是除，然后分别乘除

						if(c1=='*'){

							total*=d;

						}else if(c1=='/'){

							total/=d;

						}

					}

					//最后将计数器的累加条件改变

					i+=count+1;

				}

			//	System.out.println(total);

				//将结果替换到原来的字符串里

				s= s.replace(str1, total+"");

			//	System.out.println(s);

			}

		}

		//进行加减运算

	//	System.out.println(s);

		for(int i =0;i<s.length();i++){

			int count =1;

			a:for(int j=i+1;j<s.length();j++){

				char c = s.charAt(j);

				if(c=='+'||c=='-'){

					break a;

				}else{

					count++;

				}

			}

			String s3= s.substring(i,i+count);

		//	System.out.println(s3);

			double d2 = Double.parseDouble(s3);

			if(i==0){

				total1 = d2;

			}else{

				char c = s.charAt(i-1);

				if(c=='+'){

					total1+=d2;

				}else if(c=='-'){

					total1-=d2;

				}

			}

			i+=count;

		}

		System.out.println("="+total1);

		return total1;

	}


	
	
	private String[] results;
	private static int range;
	private static int sum;
	public String[] getResults() {
		return results;
	}
	public void setResults(String[] results) {
		this.results = results;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public static void main(String[] args) {
		/*
		test t = new test();
		t.writeTXT("wocai");
		*/
		
//		range = 10;
//		sum = 4;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter the number range:");
		
		
		range=sc.nextInt();
		System.out.println("please enter the sum of calculations:");
		sum = sc.nextInt();
		
		sc.close();
		
		test t = new test();
	//	t.testOperation("1+2*3-2/1");
		String cals;
		for(int i = 0;i<sum;i++) {
			
			cals = t.calculations();
			System.out.print(cals);
			t.writeTXT(i + "、" + t.testOperation(cals)+"");;
			
		}
		/*
	     */
	     
	}
	/**
	 * 在calculations里用一个for循环调用拼接
	 * @return
	 */
	public int randomSymbol() {
		int operator = new Random().nextInt(4);
		return operator;
		//0-3 :+-*/
		/*
		switch(operator){
		    case 0 :
		       return "+";
		    case 1 :
		       //语句
		    	return "-";
		    //你可以有任意数量的case语句
		    case 2:
		    	return "*";
		    
		}
		return "/";
	
*/	}
	
	public String calculations() {
		Random r = new Random();
		// 1 2 3 
		
		//符号个数
		int numbersOfCal =  r.nextInt(3)+1;
		//运算数个数
		int numbers = numbersOfCal + 1 ;
		
		String cal="";
		
		int symbol;
		
		for(int  i =0;i < numbersOfCal;i++) {
			//符号 0 1 2 3
			symbol = randomSymbol();
			switch(symbol){
			    case 0 :
			    	cal = cal +  r.nextInt(range+1) +   "+" + r.nextInt(range+1)  ;
			    	break;
			    case 1 :
			    	cal = cal +  r.nextInt(range+1) +   "-" + r.nextInt(range+1)  ;
			    	break;
			    	//语句
			    //你可以有任意数量的case语句
			    case 2:
			    	cal = cal +  r.nextInt(range+1) +   "*" + r.nextInt(range+1)  ;
			    	break;
			    case 3:
			    	cal = cal +  r.nextInt(range+1) +   "/" + r.nextInt(range+1)  ;
			    	break;
			}
		}
		
		
		
		//根据符号生成数字(分数的个数则再根据随机数判断个数)
		
		//分数个数 0 1 2 3 4 
		
		//int sumOfFraction = r.nextInt(numbersOfCal+2);

		//String cal = "";
		//先求出要 计算的数字来
		/*
		//分数
		for(int i = 0;i<sumOfFraction;i++) {
			int a = r.nextInt(range);
			int b = r.nextInt(range);
		}
		*/
		/*
		int []numbers = new int[numbersOfCal+1];
		for(int i =0;i<numbersOfCal+1;i++) {
			numbers[i] = r.nextInt(range+1);
		}
		
		for(int i = 0;i<numbersOfCal;i++) {
			int symbol = randomSymbol();
			switch(symbol){
			    case 0 :
			    	cal = cal + "+" + numbers[i];
			    case 1 :
			       //语句
			    //你可以有任意数量的case语句
			    case 2:
		    
			    case 3:
			    	
			}
		}
		
		*/
		return cal;
	}
}
