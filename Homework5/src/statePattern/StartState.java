package statePattern;

public class StartState implements State {

	   public void doAction(Controller context) {
	      System.out.println("State is start");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "Started using thesaurus class";
	   }
	}