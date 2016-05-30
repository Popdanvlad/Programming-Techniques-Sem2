import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SimulatorFrame {
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private double avgWaitingTime=0;
	public double getAvgWaitingTime() {
		return avgWaitingTime;
	}

	public void setAvgWaitingTime(double avgWaitingTime) {
		this.avgWaitingTime = avgWaitingTime;
	}

	public SimulatorFrame() {

		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(panel);

	}

	public void displayData(Task[][] tasks) {
		panel.removeAll();
		panel.revalidate();
		int wt = 0;
		for (int i = 0; i < 5; i++) {
			JList<Task> jtasks = new JList<Task>(tasks[i]);
			wt = 0;
			for (int j = 0; j < 5; j++) {
				if (tasks[i][j] != null) {
					wt = wt + tasks[i][j].getProcessTime();
					tasks[i][j].setServerID(i);
					tasks[i][j].setArrivalTime(tasks[i][j].getArrivalTime());
					tasks[i][j].setFinishTime(wt);
					tasks[i][j].seeTask();
				}

			}
			JScrollPane sp = new JScrollPane(jtasks);
			panel.add(sp);
			JLabel j = new JLabel();
			j.setText(wt + "");
			panel.add(j);
			avgWaitingTime += wt;
		}

		panel.repaint();
		panel.revalidate();
	}
}
