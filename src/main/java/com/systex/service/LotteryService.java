package com.systex.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;



public class LotteryService {
	public LotteryService() {}
	public  ArrayList[] getNumbers(int groups,LinkedList<Integer> excludes) {
		
		ArrayList<Integer>[] lists = new ArrayList[groups];
		for(int i=0;i<groups;i++) {
			Set<Integer> set = new TreeSet<>();
			while(set.size()<6) {
				//set.add()
				Integer temp = (int)(Math.random()*49)+1;
				if(excludes.contains(temp)==true) continue;
				set.add(temp);
			}
			lists[i] = new ArrayList<>(set);
		}
		return lists;
	}
}
