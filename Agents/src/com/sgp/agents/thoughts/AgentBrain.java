package com.sgp.agents.thoughts;

import com.sgp.agents.Agent;
import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.io.ReflectedAgentIO;
import com.sgp.agents.io.UntypedAgentIOCollection;

public class AgentBrain extends AgentThoughtsCollection{

	private Agent agent;
	
	public AgentBrain(Agent agent){
		this.agent = agent;
	}

	public void collectInformation(UntypedAgentIOCollection inputs){
		//stage one, give all input to every thought. 
		for (AgentThought thought : super.getThoughts()){
			thought.prepare();
			for (AgentIO input : inputs.getAll()){
				thought.addIO(input);
			}
		}
	}

	public UntypedAgentIOCollection thinkOn(){

		UntypedAgentIOCollection outputs = new UntypedAgentIOCollection();

		//stage two, assemble output from all thoughts.
		for (AgentThought thought : super.getThoughts()){
			UntypedAgentIOCollection thoughtOutputs = thought.think();
			
			for (AgentIO output : thoughtOutputs.getAll()){
			
				if (output != null && output.getData() != null){
					ReflectedAgentIO refOutput = new ReflectedAgentIO(this.agent.getID(), output);
					outputs.addAgentIO(refOutput);
				}
			}
		}

		return outputs;
	}

}
