package com.mkl.logic.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class Consumer<Output> implements Runnable
{
	public abstract void task(Output output); //?? mby??
	protected ArrayBlockingQueue<Output> arrayBlockingQueue;

	public Consumer(ArrayBlockingQueue<Output> arrayBlockingQueue)
	{
		this.arrayBlockingQueue = arrayBlockingQueue;
	}

	@Override public void run()
	{
		while(true) {
			try {
				Output output = arrayBlockingQueue.poll(4, TimeUnit.SECONDS); //change according to need
				if(output == null)
					break;
				task(output);
			} catch(InterruptedException ex) {
				System.out.println("-----CONSUMER Exception----" + ex);
			}
		}
	}
}
