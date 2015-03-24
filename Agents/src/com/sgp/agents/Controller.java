package com.sgp.agents;

import java.util.ArrayList;
import java.util.List;

import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.io.UntypedAgentIOCollection;

public class Controller {

	
	private List<Agent> agents;
	
	public Controller(){
		this.agents = new ArrayList<Agent>();
		
		
	}
	
	public void addAgent(Agent agent){
		this.agents.add(agent);
	}
	
	
	
	public UntypedAgentIOCollection run(UntypedAgentIOCollection inputs){
		
		UntypedAgentIOCollection outputs = new UntypedAgentIOCollection();
		
		//give all agents basic input
		for (Agent agent : this.agents){
			agent.getBrain().collectInformation(inputs);
		}
		
		//let all agents think
		for (Agent agent : this.agents){
			UntypedAgentIOCollection agentOutputs = agent.getBrain().thinkOn();
			outputs.addAgentIO(agentOutputs);
		}
		
		
		//return all output
		return outputs;
		
	}
	
	
}
