package com.sgp.agents.thoughts;

import com.sgp.agents.Agent;
import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.AgentMessageCollection;
import com.sgp.agents.io.ReflectedAgentMessage;
import com.sgp.agents.io.UntypedAgentMessageCollection;

/**
 * @author cdhan_000
 * The AgentBrain is the one doing most of the work.
 * It allows AgentMessages to be given
 * and then does some thinking later.
 */
public class AgentBrain extends AgentThoughtsCollection{

	private Agent agent;
	
	public AgentBrain(Agent agent){
		this.agent = agent;
	}

	/**
	 * @param inputs Some input for the agent
	 */
	public void collectInformation(UntypedAgentMessageCollection inputs){
		//stage one, give all input to every thought. 
		for (AgentThought thought : super.getThoughts()){
			thought.prepare();
			for (AgentMessage input : inputs.getAll()){
				thought.addMessage(input);
			}
		}
	}

	/**
	 * @return The result of thinking on all the thoughts, on all the messages
	 */
	public UntypedAgentMessageCollection thinkOn(){

		UntypedAgentMessageCollection outputs = new UntypedAgentMessageCollection();

		//stage two, assemble output from all thoughts.
		for (AgentThought thought : super.getThoughts()){
			UntypedAgentMessageCollection thoughtOutputs = thought.think();
			
			for (AgentMessage output : thoughtOutputs.getAll()){
			
				if (output != null && output.getData() != null){
					ReflectedAgentMessage refOutput = new ReflectedAgentMessage(this.agent.getID(), output);
					outputs.addAgentIO(refOutput);
				}
			}
		}

		return outputs;
	}

}
