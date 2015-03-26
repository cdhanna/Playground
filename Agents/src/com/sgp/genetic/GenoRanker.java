package com.sgp.genetic;

public interface GenoRanker < G extends Geno<G> > {

	int rank(G geno);
	
}
