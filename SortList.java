package com.sample.rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortList {

	public static void main(String[] args) throws IOException {
		List<String> listOfString = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int N = 0;
		try{
			N = Integer.parseInt(line);
		}catch(NumberFormatException e){
			System.err.println("Invalid input, Please enter numeric value..");
			return;
		}
		if(N != 0 && (N >= 1 && N <= 5000)){
			for(int i=0; i<N; i++){
				line = reader.readLine();
				boolean check = checkStringLength(line);
				if(check)
					listOfString.add(line);
				else {
					System.out.println("Can't proceed further, String length exceeded..");
					return;
				}
			}
			
		}else{
			System.out.println("Can't proceed further, Number of Strings limit exceeded..");
			return;
		}
		//Set<String> filterSet = doFilterAndGetSetOfString(listOfString);
		List<String> filterList = doFilterAndGetListOfString(listOfString);
		if(filterList != null && !filterList.isEmpty()){
			for(String str: filterList){
				System.out.println(str);
			}
		}
	}

	private static Set<String> doFilterAndGetSetOfString(List<String> list){
		SortedSet<String> filterSet = new TreeSet<String>();
		if(list != null && !list.isEmpty()){
			for(String str : list){
				filterSet.add(str);
			}
		}
		return filterSet;
	}
	
	private static List<String> doFilterAndGetListOfString(List<String> list){
		List<String> filteredList = new ArrayList<String>();
		if(list != null && !list.isEmpty()){
			for(String str : list){
				if(!filteredList.contains(str))
					filteredList.add(str);
			}
		}
		Collections.sort(filteredList);
		return filteredList;
	}
	
	private static boolean checkStringLength(String str){
		if(str != null && str.length() >= 1 && str.length() <= 100){
			return true;
		}
		return false;
	}
}
