
public class Polynomial {
	private static int MAX_NUM = 10000;
	private double [] data;
	private int order;
	
	public Polynomial(){
		this.data = new double[MAX_NUM];
		this.order = -1;
	}
	
	public Polynomial(Polynomial p){
		this.data = new double[MAX_NUM];
		for(int i = 0; i<= p.getOrder();i++){
			this.data[i] = p.getTerm(i);
		}
		this.order = p.order;
	}
	
	public Polynomial(double[] data){
		this.data = new double[MAX_NUM];
		for(int i = 0; i<data.length; i++){
			this.data[i] = data[i];
		}
		this.order = data.length-1;
	}
	
	public void setOrder(int order){
		this.order = order;
	}
	
	public void setTerm(int index, double data){
		this.data[index] = data;
		//System.out.println("data "+data+" this.data[index] "+ this.data[index]);
	}
	
	public int getOrder(){
		return this.order;
	}
	
	public double getTerm(int index){
		return this.data[index];
	}
	
	public Polynomial addPolynomial(Polynomial poly){
		int len = this.getOrder()>poly.getOrder()?this.getOrder():poly.getOrder();
		for(int i = 0; i<=len; i++){
			this.setTerm(i, this.getTerm(i)+poly.getTerm(i));
		}
		this.setOrder(len);
		return this;
	}
	
	public Polynomial subPolynomial(Polynomial poly){
		int len = this.getOrder()>poly.getOrder()?this.getOrder():poly.getOrder();
		System.out.println(len);
		if(this.getOrder()>poly.getOrder()){
			for(int i = 0; i<=len; i++){
				this.setTerm(i, this.getTerm(i)-poly.getTerm(i));
			}
			this.setOrder(len);
		}
		else{
			for(int i = 0; i<=len; i++){
				this.setTerm(i, poly.getTerm(i)-this.getTerm(i));
			}
			this.setOrder(len);
		}
		return this;
	}
	
	public Polynomial mulPolynomial(Polynomial poly){
		int all = this.getOrder()+poly.getOrder();
		double[] data = new double[all+1];
		//System.out.println(data[1]);
		for(int k =0;k<all+1;k++){data[k]=0;}
		for(int i =0; i<=this.getOrder();i++)
			for(int j =0; j<=poly.getOrder();j++){
				data[i+j]+=this.getTerm(i)*poly.getTerm(j);
			}
		
		this.setOrder(all+1);
		for(int k =0;k<all+1;k++){this.data[k]=data[k];}
		return this;
		
	}
	
	public int compPolynomial(Polynomial poly){
		if(this.getOrder()==poly.getOrder()) return 0;
		else return this.getOrder()>poly.getOrder()?1:-1;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i<this.getOrder();i++){
			str+=" "+this.data[i]+"x^"+i+" +";
		}
		str+=" "+this.data[this.getOrder()]+"x^"+this.getOrder();
		return str;
	}
	
	public static void main(String args[]){
		double[] data = {2.0,3,22,3,4,5,6,77,8,9,9,0,2};
		double[] data2 = {12,23,45,56,6,7,34,233,3,3,4,5,6,7,8};
		Polynomial p1 = new Polynomial(data);
		Polynomial p2 = new Polynomial(data2);
		
		System.out.println(p1);
		System.out.println(p2);
		//Polynomial p3 = p2.addPolynomial(p1);
		//System.out.println(p3);
		//Polynomial p4 = p2.subPolynomial(p1);
		//System.out.println(p4);
		//Polynomial p5 = p2.mulPolynomial(p1);
		//System.out.println(p5);
		//System.out.println(p5.getOrder()+" "+p2.getOrder()+" "+p1.getOrder());
		System.out.println(p1.compPolynomial(p2));
	}
}
