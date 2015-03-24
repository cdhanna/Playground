package com.sgp.agents.thoughts;

import com.sgp.agents.Agent;
import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.io.ReflectedAgentIO;

public class AgentBrain extends AgentThoughtsCollection{

	public AgentIOCollection thinkOn(Agent agent, AgentIOCollection inputs){

		AgentIOCollection outputs = new AgentIOCollection();

		//stage one, give all input to every thought. 
		for (AgentThought thought : super.getThoughts()){
			thought.prepare();
			for (AgentIO input : inputs.getAll()){
				thought.addIO(input);
			}
		}
		
		//stage two, assemble output from all thoughts.
		for (AgentThought thought : super.getThoughts()){
			AgentIO output = thought.think();
			if (output != null && output.getData() != null){
				ReflectedAgentIO refOutput = new ReflectedAgentIO(agent.getID(), output);
				outputs.addAgentIO(refOutput);
			}
		}
		


		return outputs;
	}

}
