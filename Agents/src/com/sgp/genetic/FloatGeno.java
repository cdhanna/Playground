package com.sgp.genetic;

public class FloatGeno implements Geno <FloatGeno>{

	
	private float[] data;
	
	public FloatGeno(){
		data = new float[]{1, 1, 1, 1};
	}
	
	@Override
	public void mutate(float amount) {
		
		for (int i = 0 ; i < data.length ; i ++){
			float r = 2 * (float) (Math.random() - .5);
			data[i] += r * amount;
		}
		
	}

	@Override
	public FloatGeno birth(FloatGeno parent){
		
		FloatGeno kid = new FloatGeno();
		kid.data[0] = data[0];
		kid.data[1] = data[1];
		kid.data[2] = parent.data[2];
		kid.data[3] = parent.data[3];
		return kid;
		
	}
	
	@Override
	public float getRank() {
		float r = 0;
		for (int i = 0 ; i < data.length ; i ++){
			r += data[i];
		}
		return 1/r;
	}

}
