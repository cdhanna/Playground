package com.sgp.agents;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.AgentIOCollection;
import com.sgp.agents.io.TypedAgentIO;
import com.sgp.agents.io.common.IntIO;
import com.sgp.agents.thoughts.AgentThought;

public class Sandbox {

	public static void main(String[] args){
		
		System.out.println("sandbox");
		
		
		
		
		Agent a = new Agent("AgentA");
		
		a.getBrain().addThought(new IntAvgThought(2));
		
		System.out.println("giveInput");
		a.giveInput(new IntIO(15));
		a.giveInput(new IntIO(15));
		a.giveInput(new IntIO(15));
		a.giveInput(new IntIO(19));
		a.giveInput(new IntIO(14));
		a.giveInput(new IntIO(16));
		
		
		System.out.println("thinking...");
		a.think();
		
		System.out.println("getOutput");
		AgentIOCollection outputs = a.getOutput();
		for(AgentIO output : outputs.getAll()){
			
			System.out.println(output);
			
		}
		
		
	}
	
}
