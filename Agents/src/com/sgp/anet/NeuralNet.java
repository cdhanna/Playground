package com.sgp.anet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeuralNet {

	
	private List< List<NeuralNode>> nodes;
	
	private NeuralNode[] inputs;
	
	public NeuralNet(){
		this.nodes = new ArrayList< List<NeuralNode>>();
		
	}
	
	public void setInputNodes(NeuralNode... inputs){
		
	}
	
	public void setLevelInfo(int cols, int rows){
		
	}
	
	public void setOutputNodes(NeuralNode... outputs){
		
	}
	
	public void finalizeForm(){
		
	}
	
	public void getResults(){
		
		for (int i = 0 ; i < this.nodes.size() ; i ++){
			this.resolveColumn(i);
		}
		
	}
	
	
	private void resolveColumn(int col){
		
		List<NeuralNode> colNodes = this.getColumn(col);
		for (NeuralNode node : colNodes){
			node.resolve();
		}
		
	}
	
	private List<NeuralNode> getColumn(int col){
		return this.nodes.get(col);
	}
	
	
}
