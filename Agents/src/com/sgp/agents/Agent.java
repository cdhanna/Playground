package com.sgp.agents;

import com.sgp.agents.thoughts.AgentBrain;

/**
 * @author cdhan_000
 * An Agent is a single processing unit.
 * It can accept input, think on it, and produce output.
 * An Agent is a akin to a person, in that it notices (is given) things in the environment, 
 * and acts on them.
 */
public class Agent {

	
	private AgentBrain brain;
	private String id;

	
	/**
	 * Create an Agent
	 * @param id The unique name of the Agent
	 */
	public Agent(String id){
		this.id = id;
		this.brain = new AgentBrain(this);

	}
	
	/**
	 * @return The brains of an Agent. The brain is where all of the thinking is actually done.
	 */
	public AgentBrain getBrain(){
		return this.brain;
	}
	
	/**
	 * @return The unique name of the Agent
	 */
	public String getID(){
		return this.id;
	}
	

	
}
