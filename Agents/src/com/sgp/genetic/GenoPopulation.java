package com.sgp.genetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenoPopulation < G extends Geno<G>, R extends GenoRanker<G> >{

	private List<G> genos;
	private GenoRanker<G> ranker;
	
	public GenoPopulation(GenoRanker<G> ranker, G template, int startingSize){
		this(ranker);
		if (template != null){
			for (int i = 0 ; i < startingSize ; i ++){
				genos.add(template.replicate());
			}
		}
	}

	public GenoPopulation(GenoRanker<G> ranker){
		this.genos = new ArrayList<G>();
		this.ranker = ranker;
	}

	public void add(G subject){
		this.genos.add(subject);
	}

	public void remove(G subject){
		this.genos.remove(subject);
	}
	
	public GenoPopulation<G, R> evolve(int selectionCount){
		
		Map<G, Integer> genoRankMap = new HashMap<G, Integer>();
		
		LinkedList<G> all = new LinkedList<G>();
		
		
		//map ranks to stuff
		for (G geno : this.genos){

			int rank = this.ranker.rank(geno);
			genoRankMap.put(geno, rank);
			
			boolean inserted = false;
			for (int i = 0 ; i < all.size() ; i ++){
				G current = all.get(i);
				int currentRank = genoRankMap.get(current);
				if (currentRank < rank){
					all.add(i, geno);
					inserted = true;
					break;
				}
			}
			if (!inserted){
				all.add(geno);
			}
		}
		
		//allow the top X to mate and reproduce
		List<G> outcome = new ArrayList<G>();
		for (int i = 0 ; i < all.size() ; i ++){
			if (i < all.size()/2){
				G child = all.get(i).reproduce(all.get(i+1));
				child.mutate(1);
				outcome.add(all.get(i));
				outcome.add(child);
			} else {
				//this geno dies and does not reproduce
			}
		}
		
		
		GenoPopulation<G, R> newPop = new GenoPopulation<G, R>(this.ranker);
		for (G geno : outcome){
			newPop.add(geno.replicate());
		}
		
		return newPop;
	}
	
	public void display(){
		int i = 0;
		for (G geno : this.genos){
			System.out.println(i++ + ": " + geno.display());
		}
	}
	
	

}
