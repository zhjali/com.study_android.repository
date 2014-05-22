//package hm3m18;
//
//class Bread {
//	public int id;
//
//	public Bread(int id) {
//		this.id = id;
//	}
//
//	@Override
//	public String toString() {
//		return "Bread [id=" + id + "]";
//	}
//	
//}
//
//class Product implements Runnable{
//	int id = 0;
//	Bag bag;
//	
//	
//	public Product(Bag bag){
//		this.bag = bag;
//	}
//	
//	@Override
//	public void run() {
//		while(true){
//			bag.put(new Bread(id++));
//			try {
//				Thread.sleep((int)(Math.random() * 100));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//}
//
//class Customer implements Runnable{
//	Bag bag;
//	
//	public Customer(Bag bag){
//		this.bag = bag;
//	}
//	
//	@Override
//	public void run() {
//		while(true){
//			bag.get();
//			try {
//				Thread.sleep((int)(Math.random() * 100));
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//}
//
//class Bag{
//	Bread[] breads = new Bread[5];
//	int index;
//	
//	public synchronized void put(Bread bread){
//		if(breads.length == index+1){
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		index++;
//		breads[index] = bread;
//		System.out.println("加入"+bread);
//		this.notify();
//	}
//	
//	public synchronized void get(){
//		if(index == 0){
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println("\t\t\t被吃了"+breads[index]);
//		breads[index] = null;
//		index--;
//		this.notify();
//	}
//	
//}
//
//public class TaskProductCustomer {
//	
//	public static void main(String[] args) {
//		Bag bag = new Bag();
//		Thread t1 = new Thread(new Product(bag),"Producter");
//		Thread t2 = new Thread(new Customer(bag),"Customer");
//		t1.start();
//		t2.start();
//	}
//}
