package com.movieticketbooking;
import java.util.ArrayList;

public class Seats
{
	ArrayList<String> plist;
    ArrayList<String> glist;
    ArrayList<String> slist;
    
	Seats()
	{
		plist=new ArrayList<String>();
		plist.add("a1");
		plist.add("a2");
		plist.add("a3");
		plist.add("a4");
		plist.add("a5");
		plist.add("a6");
		plist.add("a7");
		plist.add("a8");
		plist.add("a9");
		
		
		glist=new ArrayList<String>();
		glist.add("g1");
		glist.add("g2");
		glist.add("g3");
		glist.add("g4");
		glist.add("g5");
		glist.add("g6");
		glist.add("g7");
		glist.add("g8");
		glist.add("g9");
		
		
		slist=new ArrayList<String>();
		slist.add("s1");
		slist.add("s2");
		slist.add("s3");
		slist.add("s4");
		slist.add("s5");
		slist.add("s6");
		slist.add("s7");
		slist.add("s8");
		slist.add("s9");
	}
	
	void display()
	{
			System.out.println("Platinium : "+plist);
			System.out.println("Gold      : "+glist);
			System.out.println("Silver    : "+slist);
	}
}
