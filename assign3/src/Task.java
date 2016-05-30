
public class Task {
	private int arrivalTime;
	private int processTime;
	private int finishTime;
	private int serverID;
	
	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getServerID() {
		return serverID;
	}

	public void setServerID(int serverID) {
		this.serverID = serverID;
	}

	public Task(int arrivalTime,int processTime){
		this.arrivalTime = arrivalTime;
		this.processTime = processTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessTime() {
		return processTime;
	}
	
	public void seeTask() {
		System.out.println("Server : " + serverID);
		System.out.println("Start time : " + arrivalTime);
		System.out.println("Process time : " + processTime);
		System.out.println("Finish time : " + finishTime);
		System.out.println();
	}

	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}
	
	public String toString(){
		return String.valueOf(arrivalTime)+ " " +String.valueOf(processTime);
	}

}
