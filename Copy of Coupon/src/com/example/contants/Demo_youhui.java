package com.example.contants;

import java.io.Serializable;
import java.util.List;

public class Demo_youhui implements Serializable{
	private List<Info_youhui> results;

	public List<Info_youhui> getResults() {
		return results;
	}

	public void setResults(List<Info_youhui> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Demo [results=" + results + "]";
	}

}
