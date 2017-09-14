package com.tracy.app;

public class SequnceNum {
	int num = 0;
	
//	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
//		@Override
//		protected Integer initialValue() {
//			return 0;
//		}
//	};
	
	public synchronized int getNextNum(){
//		seqNum.set(seqNum.get() + 1);
//		return seqNum.get();
		
		return num++;
	}

}
