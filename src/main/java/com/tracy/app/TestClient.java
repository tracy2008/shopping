package com.tracy.app;

public class TestClient implements Runnable {

	private SequnceNum sn;

	public TestClient(SequnceNum sn) {
		super();
		this.sn = sn;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "  sn:" + sn.getNextNum());
		}	
	}
}
