package task21;

import java.util.ArrayList;

public class Seats {
	
	 ArrayList<String> plist;
	 ArrayList<String> glist;
	 ArrayList<String> slist;
	public Seats() {
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
		glist.add("b1");
		glist.add("b2");
		glist.add("b3");
		glist.add("b4");
		glist.add("b5");
		glist.add("b6");
		glist.add("b7");
		glist.add("b8");
		glist.add("b9");
		
		
		slist=new ArrayList<String>();
		slist.add("c1");
		slist.add("c2");
		slist.add("c3");
		slist.add("c4");
		slist.add("c5");
		slist.add("c6");
		slist.add("c7");
		slist.add("c8");
		slist.add("c9");
	
	}
		
		void display()
		{
			System.out.println("Platinium "+plist);
			System.out.println("Gold "+glist);
			System.out.println("Silver"+slist);
		}
	 
}
