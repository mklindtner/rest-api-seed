package com.mkl.logic.producerConsumer.exampleProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver
{
	public static void main(String[] args) throws InterruptedException
	{
		ArrayBlockingQueue<Long> Q1 = new ArrayBlockingQueue<>(50);
		ArrayBlockingQueue<Long> Q2 = new ArrayBlockingQueue<>(50);
		for(long i = 0; i < 50; i++) {
			Q1.add(i);
		}

		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.execute(new FibProducerExample(Q1, Q2));
		executorService.execute(new FibProducerExample(Q1, Q2));
		executorService.execute(new FibProducerExample(Q1, Q2));

		executorService.execute(new FibConsumerExample(Q2));

		executorService.shutdown();

		executorService.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println("Closing Down");
	}
}
