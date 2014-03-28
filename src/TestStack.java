
public class TestStack {
	private static int count = 0;
	TestStack(){
		
	}
	
	public String changedigit(int data){
		Stack s = new Stack();
		while(data!=0){
			s.push(data%8);
			data/=8;
		}
		String str = "";
		while(!s.isEmpty()){
			str+=s.pop();
		}
		return str;
	}
	
	public boolean checkBracket(String str){
		Stack s = new Stack();
		for(int i = 0;i<str.length();i++){
			if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
				s.push(str.charAt(i));
			}
			if(str.charAt(i)==')'){
				if(s.getTop() =='('){
					s.pop();
					continue;
				}else{return false;}
			}
			if(str.charAt(i)==']'){
				if(s.getTop()=='['){
					s.pop();
					continue;
				}else{return false;}
			}
			if(str.charAt(i)=='}'){
				if(s.getTop()=='{'){
					s.pop();
					continue;
				}
			}				
		}
		if(s.isEmpty()){
			return true;
		}
		return false;
	}
	
	public int calulate(String str){
		Stack num = new Stack();
		Stack opr = new Stack();
		
		for(int i = 0; i<str.length();i++){
			//if(str.charAt(i)>='0')
		}
		
		return 0;
	}
	
	public void hanoi(int n, char x, char y, char z){
		if(n == 1)
			move(n,x,z);
		else{
			hanoi(n-1, x,z,y);
			move(n,x,z);
			hanoi(n-1,y,x,z);
		}
	}
	
	public void move(int n, char x, char z){
		System.out.printf("%d. move disk %d from %c to %c\n", ++this.count, n, x, z);
	}
	
	public static void main(String args[]){
		int data = 1348;
		TestStack s = new TestStack();
		String str = s.changedigit(data);
		System.out.println(str);
		
		String str1 = "{[][][][][][][({[]})][[[[[[()]]]]]]}";
		System.out.println(s.checkBracket(str1));
		
		s.hanoi(50, 'x', 'y', 'z');
	}

}
