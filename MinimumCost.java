package com.sample.rd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCost {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		List<Integer> minimumOfCostList = new ArrayList<Integer>();
		try{
			int numOfTests = Integer.parseInt(line);
			if(numOfTests >= 1 && numOfTests <= 10){
				for(int i=0; i<numOfTests; i++){
					int minimumCost = 0;
					line = reader.readLine();
					int numOfShops = Integer.parseInt(line);
					if(numOfShops >= 1 && numOfShops <= 105){
						for(int j=0; j< numOfShops; j++){
							line = reader.readLine();
							List<Integer> list = checkInputAndGetResult(line);
							if(list != null && !list.isEmpty() && list.size() == 3){
								minimumCost +=getSmallElement(list);
							}else{
								System.out.println("Can't proceed further, input size limit exceeded or deceeded..");
								return;
							}
						}
					}else{
						System.out.println("Can't proceed further, Shops should be greater than zero/less than 105..");
						return;
					}
					minimumOfCostList.add(minimumCost);
				}
			}else{
				System.out.println("Can't proceed further, Test cases should be greater than zero/less than 10..");
				return;
			}
			if(!minimumOfCostList.isEmpty()){
				for (Integer minimumCost : minimumOfCostList) {
					System.out.println(minimumCost);
				}
			}
		}catch(NumberFormatException e){
			System.err.println("Invalid input, Please enter numeric value..");
			return;
		}
	}

	private static int getSmallElement(List<Integer> list){
		return Collections.min(list);
	}
	
	private static List<Integer> checkInputAndGetResult(String str){
		String[] arr = str.split(" ");
		int[] costsOfItems = new int[arr.length];
		List<Integer> list = new ArrayList<Integer>();
		try{
			if(arr != null && arr.length > 0){
				for(int i=0; i<arr.length; i++){
					costsOfItems[i] = Integer.parseInt(arr[i]);
					list.add(new Integer(Integer.parseInt(arr[i])));
				}
			}
			
			return list;
		}catch(NumberFormatException e){
			System.err.println("Invalid input, Please enter numeric value..");
			return null;
		}
	}
}
