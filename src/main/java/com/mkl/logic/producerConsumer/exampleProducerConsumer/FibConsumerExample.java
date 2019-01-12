package com.mkl.logic.producerConsumer.exampleProducerConsumer;

import com.mkl.logic.producerConsumer.Consumer;

import java.util.concurrent.ArrayBlockingQueue;

public class FibConsumerExample extends Consumer<Long>
{

	public FibConsumerExample(ArrayBlockingQueue<Long> arrayBlockingQueue)
	{
		super(arrayBlockingQueue);
	}

	@Override public void task(Long aLong)
	{
		System.out.println("---Consumer Finished found number: " + aLong + "---");
	}
}
