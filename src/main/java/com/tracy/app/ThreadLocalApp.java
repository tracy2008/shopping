package com.tracy.app;

public class ThreadLocalApp {
	
	//3条队伍分别排队叫号
	
	public static void main(String[] args) {
		SequnceNum sn = new SequnceNum();
		TestClient client1 = new TestClient(sn);
		TestClient client2 = new TestClient(sn);
		TestClient client3 = new TestClient(sn);
		new Thread(client1).start();
		new Thread(client2).start();
//		new Thread(client3).start();
	}

}
