package com.state;

import java.awt.Graphics2D;

public class StateManager {
	private State[] states;
	private int currentState;
	
	public static final int NUMSTATES = 3;
//	declare variables to help keep track of the available states
	public static final int MENUSTATE = 0;
	public static final int KEYEXAMPLESTATE = 1;
	public static final int BOUNCEBALLSTATE = 2;
	
//	Constructor
	public StateManager() {
		states = new State[NUMSTATES];
		
		currentState = MENUSTATE;
		loadState(currentState);
	}
	
//	Method to load the needed state
	private void loadState(int state) {
		if (state == MENUSTATE) {
			states[state] = new MenuState(this);
		}
		else if (state == KEYEXAMPLESTATE) {
			states[state] = new KeyListenerExampleState(this);
		}
		else if (state == BOUNCEBALLSTATE) {
			states[state] = new BouncingBallState(this);
		}
	}
//	Method to unload a state when it's no longer needed
	private void unloadState(int state) {
		states[state] = null;
	}
//	Method to change state then call the loadState method to load it
	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		
		loadState(currentState);
	}
	
//	Method to call a state's method to update
	public void update() {
		try {
			states[currentState].update();
		}
		catch (Exception e) {
			
		}
	}
//	Receive MainPanel's g2d then pass it to a running state so something can be drawn there
	public void draw(Graphics2D g2d) {
		try {
			states[currentState].draw(g2d);
		}
		catch (Exception e) {
		}
	}
	
//	Receive keyboard inputs from MainPanel class then pass it to a running state
	public void keyPressed(int k) {
		states[currentState].keyPressed(k);
	}
	public void keyReleased(int k) {
		states[currentState].keyReleased(k);
	}
}
