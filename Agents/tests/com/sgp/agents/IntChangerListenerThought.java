package com.sgp.agents;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.TypedAgentIO;
import com.sgp.agents.io.common.IntIO;
import com.sgp.agents.thoughts.AgentThought;

public class IntChangerListenerThought implements AgentThought {

	private int tolerance;
	private int runningSum;
	private int count;
	private int lastAvg;
	
	public IntChangerListenerThought(int tolerance){
		this.tolerance = tolerance;
	}
	
	@Override
	public AgentIO thinkOn(AgentIO input) {
		
		if (input instanceof IntIO){
			
			IntIO io = (IntIO) input;
			
			runningSum += io.getData();
			count ++;
			
			lastAvg = runningSum / count;
			if (Math.abs(io.getData() - lastAvg) > tolerance){
				return new TypedAgentIO<String>("This isn't normal!!! " + io.getData() + ". Current avg = " + lastAvg);
			}
			
			
			
		}
		
		return null;
	}

}
