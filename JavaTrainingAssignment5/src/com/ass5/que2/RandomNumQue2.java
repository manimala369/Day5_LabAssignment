package com.ass5.que2;

import java.util.Random;

class RandomNumber implements Runnable{
			private int sum;
			
			public RandomNumber(int sum) {
				this.sum = sum;
			}
			
			public int getSum() {
				return sum;
			}

			@Override
			public void run() {
				getSum(sum);
			}
			
			public int getSum(int sum) {

				Random random = new Random();
				int value = random.nextInt(10)+1;
				System.out.println("random number: " + value);
				
				synchronized (this) {
					this.sum += value;
				}
				return this.sum;
			}
}

public class RandomNumQue2 {

	public static void main(String[] args) {
		int add = 0;
		RandomNumber random = new RandomNumber(add);
		Thread thread1 = new Thread(random);
		Thread thread2 = new Thread(random);
		Thread thread3 = new Thread(random);
		Thread thread4 = new Thread(random);
		Thread thread5 = new Thread(random);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sum : " + random.getSum());
	}

}
