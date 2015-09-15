package com.sample.rd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrangeSmallNumber<T> {

	private final static Integer[] nums = {10,8,2,3};

	public static void main(String[] args) {
		ArrangeSmallNumber<Integer> instance = new ArrangeSmallNumber<Integer>();
		List<Integer> numbers = new ArrayList<Integer>();
		if(nums != null && nums.length != 0){
			Collection<Integer> input = new ArrayList<Integer>();
			for(Integer num : nums)
				input.add(num);
			Collection<List<Integer>> output = instance.permute(input);
			Set<List<Integer>> pnr = null;

			pnr = new HashSet<List<Integer>>();
			for(List<Integer> integers : output){
				pnr.add(integers.subList(0, integers.size()));
			}
			if(pnr != null && !pnr.isEmpty()){
				Iterator<List<Integer>> iterator = pnr.iterator();				
				StringBuilder builder = null;
				while(iterator.hasNext()){					
					List<Integer> list = iterator.next();
					builder = new StringBuilder();
					for(Integer number : list)
						builder.append(String.valueOf(number));
					numbers.add(Integer.parseInt(builder.toString()));
				}
			}
			int smallest = Integer.MAX_VALUE;
			if(numbers != null && !numbers.isEmpty()){				
				for(int i =0;i<numbers.size();i++) {
					if(smallest > numbers.get(i)) {
						smallest = numbers.get(i);
					}
				}
			}
			System.out.println(smallest);
		}else
			System.out.println("Can't proceed further");
	}

	public Collection<List<T>> permute(Collection<T> input) {
		Collection<List<T>> output = new ArrayList<List<T>>();
		if (input.isEmpty()) {
			output.add(new ArrayList<T>());
			return output;
		}
		List<T> list = new ArrayList<T>(input);
		T head = list.get(0);
		List<T> rest = list.subList(1, list.size());
		for (List<T> permutations : permute(rest)) {
			List<List<T>> subLists = new ArrayList<List<T>>();
			for (int i = 0; i <= permutations.size(); i++) {
				List<T> subList = new ArrayList<T>();
				subList.addAll(permutations);
				subList.add(i, head);
				subLists.add(subList);
			}
			output.addAll(subLists);
		}
		return output;
	}
}
