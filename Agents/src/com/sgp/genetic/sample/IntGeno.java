package com.sgp.genetic.sample;

import com.sgp.genetic.Geno;
import com.sgp.genetic.GenoRanker;

public class IntGeno implements Geno <IntGeno>{

	
	private int[] data;
	
	public IntGeno(){
		data = new int[]{1, 1};
	}
	
	public IntGeno(int[] data){
		this.data = data;
	}
	
	public int getData(int x){
		return data[x];
	}
	
	@Override
	public void mutate(float amount) {
		
		if (Math.random() > .5){
			
			int i = (int)(Math.random() * 2);
			
			if (Math.random() > .5){
				data[i] ++;
			} else {
				data[i] --;
			}
			
		}
	
		
	}

	@Override
	public IntGeno reproduce(IntGeno parent){
		
		IntGeno kid = new IntGeno();
		for (int i = 0 ; i < data.length ; i ++){
			if (i < data.length/2){
				kid.data[i] = data[i];
			} else kid.data[i] = parent.data[i];
		}
		return kid;
		
	}
		
	public IntGeno replicate(){
		return new IntGeno(this.data);
	}

	public String display(){
		String s = "";
		for (int i = 0 ; i < data.length ; i ++){
			s += data[i] + ", ";
		}
		return s;
	}
	
}

