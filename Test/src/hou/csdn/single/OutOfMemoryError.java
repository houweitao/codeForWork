package hou.csdn.single;

/**
 * @author houweitao
 * 2015年9月6日 下午3:59:03
 * http://blog.csdn.net/mergades/article/details/46956271
 */

public class OutOfMemoryError {
	public void dontStop(){
		
		while(true){
			
			
		}
	}
	
	public void stackLengthThread(){
		
		while(true){
			
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		
		OutOfMemoryError oome = new OutOfMemoryError();
		oome.stackLengthThread();
	}
}
