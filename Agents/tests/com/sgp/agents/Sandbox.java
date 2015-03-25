package com.sgp.agents;

import com.sgp.agents.io.AgentMessage;
import com.sgp.agents.io.AgentMessageCollection;
import com.sgp.agents.io.TypedAgentMessage;
import com.sgp.agents.io.UntypedAgentMessageCollection;
import com.sgp.agents.io.common.IntIO;
import com.sgp.agents.thoughts.AgentThought;
import com.sgp.agents.thoughts.IntDoubler;
import com.sgp.agents.thoughts.Repeater;

public class Sandbox {

	public static void main(String[] args){
		
		
		Controller c = new Controller();
		
		Agent gentA = new Agent("gentA");
		Agent gentB = new Agent("gentB");
		
		gentA.getBrain().addThought(new IntDoubler());
		gentB.getBrain().addThought(new Repeater(gentA));
		
		c.addAgent(gentA);
		c.addAgent(gentB);
		
		UntypedAgentMessageCollection outputs = new UntypedAgentMessageCollection();
		
		outputs.addAgentIO(new IntIO(5));
		
		
		for (int i = 0 ; i < 2 ; i ++){
			System.out.println("SIM ROUND : " + i);
			outputs = c.run(outputs);
			
			for (AgentMessage io : outputs.getAll()){
				System.out.println(io);
			}
		}
		
	}
	
}
