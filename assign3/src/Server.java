import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

	private BlockingQueue<Task> bq;
	private AtomicInteger waitingTime;

	public Server() {
		waitingTime = new AtomicInteger(0);
		bq = new LinkedBlockingQueue<>();
		
	}

	@Override
	public void run() {
		while (true) {
			Task t;
			try {
				t = bq.take();
				Thread.sleep(t.getProcessTime()*2000);
				waitingTime.addAndGet((-1) * t.getProcessTime());
				System.out.println(waitingTime+" "+t.getArrivalTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void addTask(Task t) {
		bq.add(t);
		waitingTime.addAndGet(t.getProcessTime());

	}
	
	public Task[] getTasks(){
		
		Task[] task = new Task[bq.size()];
		bq.toArray(task);
		
		return task;
	}
	public boolean isEmpty(){
		return bq.isEmpty();
	}

	public AtomicInteger getWaitingTime() {
		return waitingTime;
	}

}
