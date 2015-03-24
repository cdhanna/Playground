package com.sgp.agents;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.thoughts.AgentBrain;
import com.sgp.agents.thoughts.AgentThoughtsCollection;

public class Agent {

	
	private AgentBrain brain;
	private String id;

	
	
	
	public Agent(String id){
		this.id = id;
		this.brain = new AgentBrain(this);

	}
	
	public AgentBrain getBrain(){
		return this.brain;
	}
	public String getID(){
		return this.id;
	}
	

	
}
