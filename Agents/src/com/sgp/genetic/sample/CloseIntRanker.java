package com.sgp.genetic.sample;

import com.sgp.genetic.Geno;
import com.sgp.genetic.GenoRanker;

public class CloseIntRanker implements GenoRanker<IntGeno> {

	@Override
	public int rank(IntGeno geno) {
		
		int l = geno.getData(0);
		int r = geno.getData(1);
		
		return 1000 - Math.abs(l - r);
	}

	

}
