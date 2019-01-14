package com.mkl.logic.producerConsumer.fetchDataMultiThread;

import java.util.concurrent.*;

public class FetchResults
{
	private static final int TIME_BEFORE_Q1_POLL = 0;

	public StringBuffer getResultsFromBlockingQueue(ArrayBlockingQueue<String> Q1, ArrayBlockingQueue<String> Q2)
			throws InterruptedException
	{
		StringBuffer results = new StringBuffer();
		results.append("[");
		ExecutorService es = Executors.newCachedThreadPool();

		es.execute(new FetchProducer(Q1, Q2, TIME_BEFORE_Q1_POLL));
		es.execute(new FetchProducer(Q1, Q2, TIME_BEFORE_Q1_POLL));
		es.execute(new FetchProducer(Q1, Q2, TIME_BEFORE_Q1_POLL));
		es.execute(new FetchProducer(Q1, Q2, TIME_BEFORE_Q1_POLL));

		es.execute(new FetchConsumer(Q2, results));

		es.shutdown();
		es.awaitTermination(5, TimeUnit.SECONDS);
		results.append("]");
		return results;
	}
}
