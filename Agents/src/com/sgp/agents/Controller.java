package com.sgp.agents;

import java.util.ArrayList;
import java.util.List;

import com.sgp.agents.io.AgentMessageCollection;
import com.sgp.agents.io.UntypedAgentMessageCollection;

/**
 * @author cdhan_000
 * The Controller maintains a set of Agents, and runs a basic tick cycle for all of them.
 * The basic tick is called by using the run() method of the class.
 */
public class Controller {

	
	private List<Agent> agents;
	
	public Controller(){
		this.agents = new ArrayList<Agent>();
		
		
	}
	
	/**
	 * Adds a new Agent to this Controller. Adding an Agent will make the agent recieve messages when the Controller's run() method is called
	 * @param agent An agent
	 */
	public void addAgent(Agent agent){
		this.agents.add(agent);
	}
	
	
	
	/**
	 * Update all Agents. 
	 * This method will give all of the Agents the input passed to the function.
	 * Then it will ask all the Agents to think upon the inputs, and it will collect any/all output thoughts from each Agent
	 * All of those outputs will be aggregated, and returned
	 * @param inputs some input set
	 * @return some output set
	 */
	public UntypedAgentMessageCollection run(UntypedAgentMessageCollection inputs){
		
		UntypedAgentMessageCollection outputs = new UntypedAgentMessageCollection();
		
		//give all agents basic input
		for (Agent agent : this.agents){
			agent.getBrain().collectInformation(inputs);
		}
		
		//let all agents think
		for (Agent agent : this.agents){
			UntypedAgentMessageCollection agentOutputs = agent.getBrain().thinkOn();
			outputs.addAgentIO(agentOutputs);
		}
		
		
		//return all output
		return outputs;
		
	}
	
	
}
