package cyclicbarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class JavaCyclicBarrierExample {
	
	
	public static void main(String[] args) {
		
		        //3 threads are part of the barrier, ServiceOne, ServiceTwo and this main thread calling them.
		
		        final CyclicBarrier barrier = new CyclicBarrier(3,new reach());
		
		        Thread serviceOneThread = new Thread(new ServiceOne(barrier));
		
		        Thread serviceTwoThread = new Thread(new ServiceTwo(barrier));
		
		        System.out.println("Starting both the services at "+new Date());
		
		        serviceOneThread.start();
		
		        serviceTwoThread.start();
		
		        try {
		
		        	Thread.sleep(3000);
		        serviceOneThread.interrupt();
		           barrier.await();
		        	//barrier.reset();
		        } catch (BrokenBarrierException e) {
		
		            System.out.println("Main Thread interrupted! - BrokenBarrierException");
		
		            e.printStackTrace();
		
		        }
		        catch (InterruptedException e) {
		    		
		            System.out.println("Main Thread interrupted! - InterruptedException");
		
		            e.printStackTrace();
		
		        }
		        System.out.println("Ending both the services at "+new Date());
		        System.out.println(" barrier.getNumberWaiting() " +barrier.getNumberWaiting());
		        System.out.println(" barrier.getParties() " +barrier.getParties());
		    }
		
	static class reach implements Runnable{

		@Override
		public void run() {
			System.out.println("all barrier are finished.........");
		}
		
	}


}
