//package hm3m18;
//
//class Bread{
//	int id = 0;
//	public Bread(int id){
//		this.id = id;
//	}
//	public String toString() {
//		return "Bread [id=" + id + "]";
//	}
//}
//
//class Bag {
//	Bread[] breads = new Bread[5];
//	int index = 0;
//}
//
//class Productor implements Runnable {
//	int id = 0;
//	Bag bag;
//
//	public Productor(Bag bag) {
//		this.bag = bag;
//	}
//
//	public void push(Bread bread) {
//		bag.breads[bag.index] = bread;
//		System.out.println("product" + bag.breads[bag.index++]);
//	}
//
//	@Override
//	public void run() {
//		synchronized (bag) {
//			while(true){
//			if (bag.index > (bag.breads.length - 1)) {
//				try {
//					bag.wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			push(new Bread(id++));
//			try {
//				Thread.sleep((int) (Math.random() * 100));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			bag.notify();
//		}
//		}
//	}
//
//}
//
//class Customer implements Runnable {
//	Bag bag;
//
//	public Customer(Bag bag) {
//		this.bag = bag;
//	}
//
//	public void eat() {
//		bag.index--;
//		System.out.println("\t\t\tcustomer" + bag.breads[bag.index]);
//	}
//
//	@Override
//	public void run() {
//		synchronized (bag) {
//		while (true) {
//			if (bag.index <= 0) {
//				try {
//					bag.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			eat();
//			try {
//				Thread.sleep((int) (Math.random() * 100));
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			bag.notify();
//		}
//		}
//	}
//
//}
//
//public class TaskProductCustomer2 {
//	public static void main(String[] args) {
//	Bag bag = new Bag();
//	Thread t1 = new Thread(new Productor(bag),"Productor");
//	Thread t2 = new Thread(new Customer(bag),"Customer");
//	t1.start();
//	t2.start();
//	}
//}
