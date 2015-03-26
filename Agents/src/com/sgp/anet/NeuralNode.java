package com.sgp.anet;

import java.util.ArrayList;
import java.util.List;

public class NeuralNode {

	private List<NeuralNode> inputs;
	private float message;
	private float weight;
	
	public NeuralNode(){
		this.inputs = new ArrayList<NeuralNode>();
		this.message = 0;
		this.weight = .5f;
	}
	
	public void addInput(NeuralNode input){
		this.inputs.add(input);
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	public float setWeight(float weight){
		this.weight = weight;
		return this.weight;
	}
	
	public void resolve(){
		
		this.message = 0;
		for (NeuralNode in : this.inputs){
			this.message += in.getMessage();
		}
		this.message *= this.weight;
	}
	
	
	public float getMessage(){
		return this.message;
	}
	
}
