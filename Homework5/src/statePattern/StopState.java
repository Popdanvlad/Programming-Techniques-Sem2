package statePattern;

public class StopState implements State {

	   public void doAction(Controller context) {
	      System.out.println("Stop");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "The thesaurus si not in use anymore";
	   }
	}