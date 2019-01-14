package com.mkl.logic.producerConsumer.fetchDataMultiThread;

import com.mkl.logic.producerConsumer.Producer;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class FetchProducer extends Producer<String, String>
{

	public FetchProducer(ArrayBlockingQueue<String> arrayBlockingQueue, ArrayBlockingQueue<String> arrayBlockingQueue2, int secondsBeforePull)
	{
		super(arrayBlockingQueue, arrayBlockingQueue2, secondsBeforePull);
	}


	@Override public String task(String path)
	{
		String jsonStr = null;
		try {
			URL               url = new URL(path + "/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json;charset=UTF-8");
			con.setRequestProperty("User-Agent", "server");
			Scanner scan = new Scanner(con.getInputStream());
			if (scan.hasNext()) {
				jsonStr = scan.nextLine();
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return jsonStr;
		}
	}
}
