package com.mkl.logic.producerConsumer.exampleProducerConsumer;

import com.mkl.logic.producerConsumer.Producer;

import java.util.concurrent.ArrayBlockingQueue;

public class FibProducerExample extends Producer<Long, Long>
{

	public FibProducerExample(ArrayBlockingQueue<Long> arrayBlockingQueue, ArrayBlockingQueue<Long> OutputBlockingQueue)
	{
		super(arrayBlockingQueue, OutputBlockingQueue, 4);
	}

	@Override public Long task(Long aLong)
	{
		return aLong == 0 || aLong == 1 ? aLong : task(aLong - 1) + task(aLong - 2);
	}

}
