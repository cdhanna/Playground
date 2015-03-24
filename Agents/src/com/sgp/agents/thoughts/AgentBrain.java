package com.sgp.agents.thoughts;

import com.sgp.agents.Agent;
import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.io.ReflectedAgentIO;

public class AgentBrain extends AgentThoughtsCollection{

	public AgentIOCollection thinkOn(Agent agent, AgentIOCollection inputs){

		AgentIOCollection outputs = new AgentIOCollection();

		for (AgentIO input : inputs.getAll()){
			for (AgentThought thought : super.getThoughts()){
				AgentIO output = (thought.thinkOn(input));
				if (output != null && output.getData() != null){
					
					ReflectedAgentIO refOutput = new ReflectedAgentIO(agent.getID(), output);
					outputs.addAgentIO(refOutput);
					
				}
			}
		}


		return outputs;
	}

}
