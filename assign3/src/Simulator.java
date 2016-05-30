
public class Simulator implements Runnable {

	int finishTime; // 20:00
	int maxProcessTime;
	int minProcessTime;
	private Scheduler scheduler;
	private SimulatorFrame frame;
	private ReadFile readFile;
	private static Simulator instance;

	public Simulator() {
		scheduler = new Scheduler();
		frame = new SimulatorFrame();
		readFile= new ReadFile();
		finishTime=readFile.getSir()[0];
		maxProcessTime=readFile.getSir()[1];
		minProcessTime=readFile.getSir()[2];
		scheduler.setThresholdTime(readFile.getSir()[3]);
		scheduler.setMaxNumberOfServers(readFile.getSir()[4]);
	}

	@Override
	public void run() {
		int currTime = 0;
		while (currTime < finishTime) {
			currTime++; // +5 min
			int processTime = (int) (Math.random() * (maxProcessTime - minProcessTime) + minProcessTime);
			if(scheduler.openNewServer()==true){
				scheduler.addServer();
			}
			Task t = new Task(currTime, processTime);

			scheduler.addTask(t);
			frame.displayData(scheduler.seeTasks());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		System.out.println("The average waiting time was: "+frame.getAvgWaitingTime()/100);
		System.out.println("The peak hour was: "+scheduler.getMaxWaitingTime());
		while (scheduler.getServer().isEmpty()){
			frame.displayData(scheduler.seeTasks());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
	
	public static Simulator getInstance() {
		if (instance == null) {
			synchronized (Simulator.class) {
				if (instance == null) {
					instance = new Simulator();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args){
		Simulator sim =  Simulator.getInstance();
		Thread th = new Thread(sim);
		th.start();
		
		
	}

}
