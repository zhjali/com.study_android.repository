
public class Factory {
	String name;
	Person manager;
	String goods;
	String address;
	int goodsNum;
	int stafNum;
	
	public Factory(){
	   this("star",new Person("wang"),"chips","haidian",1200,100);
	}
	
	public Factory(String name,Person manager,String goods,String address,int goodsNum,int stafNum){
		this.name = name;
		this.manager = manager;
		this.goods = goods;
		this.address = address;
		this.goodsNum = goodsNum;
		this.stafNum = stafNum;
	}
	
	public void getInfo(){
		System.out.println("Name: "+name+" Manager: "+manager);		
		System.out.println("Address: "+address);
		System.out.println("Product Goods: "+goods);
		System.out.println("Goods number: "+goodsNum);
		System.out.println("staff number: "+stafNum);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory fa = new Factory();
		fa.getInfo();
	}

}
