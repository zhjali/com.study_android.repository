package com.example.contants;

import java.io.Serializable;
import java.util.List;

public class pagedresults implements Serializable{
	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "pagedresults [results=" + results + "]";
	}

}
