package com.rmi.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestCollection {

	public static void main(String[] args) {
		Set< String> orignal = new TreeSet<>();
		orignal.add("C°à");
		orignal.add("A°à");
		orignal.add("B°à");
		
		List<String> aValue = new ArrayList<>();
		orignal.stream().forEach(s->{
			aValue.add(s);
		});
		
		aValue.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		orignal.stream().forEach(s->{
			System.out.print(s +"   ");
		});
		System.out.println();
		aValue.forEach(s->{
			System.out.print(s +"   ");
		});
	}
	
}
