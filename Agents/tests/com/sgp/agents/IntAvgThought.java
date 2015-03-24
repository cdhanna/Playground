package com.sgp.agents;

import com.sgp.agents.io.AgentIO;
import com.sgp.agents.io.TypedAgentIO;
import com.sgp.agents.io.common.IntIO;
import com.sgp.agents.thoughts.AgentThought;
import com.sgp.agents.thoughts.CommonAgentThought;

public class IntAvgThought extends CommonAgentThought {

	private int tolerance;
	private int runningSum;
	private int count;
	private int lastAvg;
	
	public IntAvgThought(int tolerance){
		this.tolerance = tolerance;
	}
	
	

	@Override
	public void onIOAdded(AgentIO input) {
		if (input instanceof IntIO){
			
			IntIO io = (IntIO) input;
			
			runningSum += io.getData();
			count ++;
			
			lastAvg = runningSum / count;
			
		}
	}

	@Override
	public AgentIO think() {
		
		String bads = "";
		for (AgentIO input : super.getInputs().getAll()){
			if (input instanceof IntIO){
				
				IntIO io = (IntIO) input;
				if (Math.abs(io.getData() - lastAvg) > tolerance){
					bads += io.getData() + ", ";
				}
			
			}
			
		}
		
		return new TypedAgentIO<String>(bads + "are not within tolerance of avg " + lastAvg);
		
	}

}
