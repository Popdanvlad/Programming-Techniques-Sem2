import java.util.ArrayList;

public class Scheduler {
	private static double MAX=10000;
	private int maxWaitingTime=0;
	private int thresholdTime;
	private int maxNumberOfServers;
	private ArrayList <Server> servers;
	private Server server;
	
	public int getMaxWaitingTime() {
		return maxWaitingTime;
	}
	public void setMaxWaitingTime(int maxWaitingTime) {
		this.maxWaitingTime = maxWaitingTime;
	}
	public int getThresholdTime() {
		return thresholdTime;
	}
	public void setThresholdTime(int thresholdTime) {
		this.thresholdTime = thresholdTime;
	}
	public int getMaxNumberOfServers() {
		return maxNumberOfServers;
	}
	public void setMaxNumberOfServers(int maxNumberOfServers) {
		this.maxNumberOfServers = maxNumberOfServers;
	}
	public Scheduler(){
		servers= new ArrayList<Server>();
		server = new Server();
		Thread th = new Thread(server);
		th.start();
	}
	public void addServer(){
		
		server = new Server();
		servers.add(server);
		Thread th = new Thread(server);
		th.start();
	}
	
	public boolean openNewServer(){
		for(Server s:servers){
			if((s.getWaitingTime()).get()< thresholdTime){
				//System.out.println(s.getWaitingTime().toString());
				return false;
			}
		}
		return true;
	}
	
	public Server getMinTime(){
		Server s1=new Server();
		double min=MAX;
		for(Server s:servers){
			if( s.getWaitingTime().get()<min){
				s1=s;
				min=s.getWaitingTime().get();
			}
		}
		return s1;
	}
	
	public Task[][] seeTasks() {
		Task[][] tasks = new Task[10][10];
		int i = 0;
		int j = 0;
		for (Server s : servers) {
			for (j = 0; j < s.getTasks().length; j++) {
				 tasks[i][j] = s.getTasks()[j];
			}
			i++;
		}
		return tasks;
	}
	public int[] getWaitingTimes() {
		int[] waitingTimes = new int[10];
		int i = 0;
		for (Server s : servers) {	
			waitingTimes[i] = s.getWaitingTime().get();
			if(waitingTimes[i]>maxWaitingTime){
				maxWaitingTime=waitingTimes[i];
			}
			i++;
		}
		return waitingTimes;
	}
	
	public void  addTask(Task t){
		getMinTime().addTask(t);
	}
	public void dispatchTaskOnServer(Task t){
		server.addTask(t);
	}
	
	public Server getServer(){
		return server;
	}
	public ArrayList<Server> getServers() {
		return servers;
	}
	public void setServers(ArrayList<Server> servers) {
		this.servers = servers;
	}
}
