import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test {

	//�������	
	
	public  void writeTXT(String content){
		String path = "C:\\Users\\cendler\\eclipse-workspace\\Myapp";
		String title = "Answer";
		try {
	        // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
	        /* д��Txt�ļ� */
	        File writename = new File(path);// ���·�������û����Ҫ����һ���µ�output��txt�ļ�
	        if(!writename.exists()){
	            writename.mkdirs();
	        }
	        writename = new File(path+"\\"+title+".txt");// ���·�������û����Ҫ����һ���µ�output��txt�ļ�
	        writename.createNewFile(); // �������ļ�
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
	        out.write(content); // \r\n��Ϊ����
	        out.flush(); // �ѻ���������ѹ���ļ�
	        out.close(); // ���ǵùر��ļ�

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
public double testOperation(String s){

		//Scanner sc = new Scanner(System.in);

		//Ϊ�˷�����ԣ�û����Scanner���õĻ�Ӧ��String s = sc.next();���ܴӿ���̨��������

		//String s ="10-2*2/2+4+3*4/4+1";

		//���Ӻ��滻�ɼ��ţ������ü����滻�Ӻţ���Ϊ������ʽ��ԭ������Ͳ���׸��

		String s1 =s.replace("+","-");

		//�ָ��ַ�Ȼ��Ž�����

		String[] str = s1.split("-");

		//�����ʼ���Ӽ����

		double total1=0;

		//�����ǲ鿴�и��Ľ�������������½����[10, 2*2/2, 4, 3*4/4, 1]����ȡ��������������ӡ�

		//System.out.println(Arrays.toString(str));

		//Ȼ���������������飬������ĳ˳������������ȱ�������

		for(String str1:str){

			//System.out.print(str1);

			//�ж��Ƿ��г˻��

			if(str1.contains("*")||str1.contains("/")){

				//�˳����

				double total = 0;

				//���г˻�����ַ�������

				for(int i =0;i<str1.length();){

					//��ȡ�ַ����ı仯����

					int count =1;

					//���������ÿһ���ַ�

					a:for(int j =i+1;j<str1.length();j++){

						//��ȡ�ַ�

						char c =str1.charAt(j);

						//�ж��Ƿ��ǳ˻��

						if(c=='*'||c=='/'){

							break a;

						}else{

							count++;

						}

					}

					

					//�����ֽ�ȡ����

					String s2 =str1.substring(i,i+count);

					//תΪС��

					double d = Double.parseDouble(s2);

					if(i==0){

						//����һ������Ϊ��ʼֵ

						total = d;

					}else{

						char c1 = str1.charAt(i-1);

						//�ж�����ǰ����ǳ˻��ǳ���Ȼ��ֱ�˳�

						if(c1=='*'){

							total*=d;

						}else if(c1=='/'){

							total/=d;

						}

					}

					//��󽫼��������ۼ������ı�

					i+=count+1;

				}

			//	System.out.println(total);

				//������滻��ԭ�����ַ�����

				s= s.replace(str1, total+"");

			//	System.out.println(s);

			}

		}

		//���мӼ�����

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
			t.writeTXT(i + "��" + t.testOperation(cals)+"");;
			
		}
		/*
	     */
	     
	}
	/**
	 * ��calculations����һ��forѭ������ƴ��
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
		       //���
		    	return "-";
		    //�����������������case���
		    case 2:
		    	return "*";
		    
		}
		return "/";
	
*/	}
	
	public String calculations() {
		Random r = new Random();
		// 1 2 3 
		
		//���Ÿ���
		int numbersOfCal =  r.nextInt(3)+1;
		//����������
		int numbers = numbersOfCal + 1 ;
		
		String cal="";
		
		int symbol;
		
		for(int  i =0;i < numbersOfCal;i++) {
			//���� 0 1 2 3
			symbol = randomSymbol();
			switch(symbol){
			    case 0 :
			    	cal = cal +  r.nextInt(range+1) +   "+" + r.nextInt(range+1)  ;
			    	break;
			    case 1 :
			    	cal = cal +  r.nextInt(range+1) +   "-" + r.nextInt(range+1)  ;
			    	break;
			    	//���
			    //�����������������case���
			    case 2:
			    	cal = cal +  r.nextInt(range+1) +   "*" + r.nextInt(range+1)  ;
			    	break;
			    case 3:
			    	cal = cal +  r.nextInt(range+1) +   "/" + r.nextInt(range+1)  ;
			    	break;
			}
		}
		
		
		
		//���ݷ�����������(�����ĸ������ٸ���������жϸ���)
		
		//�������� 0 1 2 3 4 
		
		//int sumOfFraction = r.nextInt(numbersOfCal+2);

		//String cal = "";
		//�����Ҫ �����������
		/*
		//����
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
			       //���
			    //�����������������case���
			    case 2:
		    
			    case 3:
			    	
			}
		}
		
		*/
		return cal;
	}
}
