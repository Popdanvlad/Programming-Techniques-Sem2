package test;

import statePattern.Controller;
import statePattern.StartState;
import statePattern.StopState;

public class Main {
	public static void main(String[] args) {
		Controller c = new Controller();

		StartState startState = new StartState();

		startState.doAction(c);

		System.out.println(c.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(c);
		System.out.println(c.getState().toString());

	}
}
