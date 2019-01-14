package com.mkl.logic.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class Producer<Input, Output> implements Runnable
{
	private int secondsBeforePull;
	public abstract Output task(Input input);
	protected ArrayBlockingQueue<Input>  inputArrayBlockingQueue;
	protected ArrayBlockingQueue<Output> outputArrayBlockingQueue;

	public Producer(ArrayBlockingQueue<Input> arrayBlockingQueue, ArrayBlockingQueue<Output> outputArrayBlockingQueue, int secondsBeforePull)
	{
		this.inputArrayBlockingQueue = arrayBlockingQueue;
		this.outputArrayBlockingQueue = outputArrayBlockingQueue;
		this.secondsBeforePull = secondsBeforePull;
	}

	@Override public void run()
	{
		while (true) {
			try {
				Input input = inputArrayBlockingQueue.poll(secondsBeforePull, TimeUnit.SECONDS); //change according to need
				if (input == null)
					break;
				outputArrayBlockingQueue.put(task(input));
				System.out.println("---Producer finished task:" + Thread.currentThread().getName() + "---");
			} catch (InterruptedException ex) {
				System.out.println("----EXCEPTION FROM PRODUCER----: " + ex);
			}
		}
	}
}
