package com.sgp.agents;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.thoughts.AgentBrain;
import com.sgp.agents.thoughts.AgentThoughtsCollection;

public class Agent {

	
	private AgentBrain brain;
	private String id;
	private AgentIOCollection currentInput;
	private AgentIOCollection currentOutput;
	
	
	
	public Agent(String id){
		this.id = id;
		this.brain = new AgentBrain();
		this.currentInput = new AgentIOCollection();
		this.currentOutput = new AgentIOCollection();
	}
	
	public AgentBrain getBrain(){
		return this.brain;
	}
	public String getID(){
		return this.id;
	}
	
	public void reset(){
		this.currentInput.clear();
		this.currentOutput.clear();
	}
	
	public void giveInput(AgentIO input){
		this.currentInput.addAgentIO(input);
	}
	
	public void think(){
		this.currentOutput = this.brain.thinkOn(this, this.currentInput);
	}
	
	public AgentIOCollection getOutput(){
		return this.currentOutput;
	}
	
}
