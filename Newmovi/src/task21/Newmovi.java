package task21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Newmovi {

	static ArrayList<String> seats=new ArrayList<String>();
	static ArrayList<String> temp=new ArrayList<String>();
	static ArrayList<Double> fund=new ArrayList<Double>(); 
	static Seats s1=new Seats();
	static int gst=18;
	static int krushikalyantax=5; 
	static int swacchbharattax=5;
	static int platiniumrate=250;
	static int goldrate=200;
	static int silverrate=150;
	static int pcount=0;
	static int scount=0;
	static int gcount=0;
	static double pbill;
	static double sbill;
	static double gbill;
	static double bill;
	static double gstt;
	static double sbt;
	static double kkt;
	static double total,ptotal,stotal,gtotal;
	
	static void selected()
	{
		
		Scanner sc;
		int n;
		System.err.println("total seats are booked  ::"+seats);
		System.out.println("enter a seat number you want to book");
		sc=new Scanner(System.in);
		n=sc.nextInt();
		
		if(n<=9)
		{
			
			System.out.println("enter a seat number ");
			for(int i=0;i<n;i++)
			{
				String j=sc.next();
				temp.add(j);
				System.out.println("seats are "+seats);
				for(String selection:seats)
				{
					if(temp.contains(selection))
					{
						System.err.println(j+" seat is already booked by someone please select another seats");
						temp.clear();
					}
				}
			}
			System.out.println("temppppp "+temp);
		}
		else
		{
			System.err.println("you can book maximum 9 seats:::");
		}
		
		seats.addAll(temp);
		temp.clear();
		for(String sel:s1.plist)
		{
			if(seats.contains(sel))
			{
				System.out.print("<"+sel+">"+"\t");
			
			}
			else
			{
				System.out.print(sel+"\t");
			}
		}
		System.out.println(" ");
		for(String sel:s1.glist)
		{
			if(seats.contains(sel))
			{
				System.out.print("<"+sel+">"+"\t");
			}
			else
			{
				System.out.print(sel+"\t");
			}
		}
		
		System.out.println(" ");
		for(String sel:s1.slist)
		{
			if(seats.contains(sel))
			{
				System.out.print("<"+sel+">"+"\t");
			}
			else
			{
				System.out.print(sel+"\t");
			}
		}
	}
	
	
	static void count()
	{
		System.out.println("size is "+seats.size());
		
		for(String ss:s1.plist)
		{
			if(seats.contains(ss))
			{
				pcount++;
				System.out.println("p couunt us "+pcount);
			}	
		}
		for(String ss:s1.glist)
		{
			if(seats.contains(ss))
			{
				gcount++;
				System.out.println("g couunt us "+gcount);
			}
		}
		for(String ss:s1.slist)
		{
			if(seats.contains(ss))
			{
				scount++;
				System.out.println("s couunt us "+scount);
			}
		}
	}
	 static void bill()
	 {
		 if(pcount>0)
		 {
			 pbill=platiniumrate*pcount;
			 gstt=pbill*gst/100;
			 sbt=pbill*swacchbharattax/100;
			 kkt=pbill*krushikalyantax/100;
			 ptotal=pbill+gstt+sbt+kkt; 
			 System.out.println(pcount);
			 System.out.println(gstt);
			 System.out.println(sbt);
			 System.out.println(kkt);
			 System.out.println(ptotal);
			 pcount=0;
			 System.out.println("after zero "+pcount);
			
		 }
		 if(scount>0)
		 {
			 sbill=silverrate*scount;
			 gstt=sbill*gst/100;
			 sbt=sbill*swacchbharattax/100;
			 kkt=sbill*krushikalyantax/100;
			 stotal=sbill+gstt+sbt+kkt;
			 System.out.println(scount);
			 System.out.println(gstt);
			 System.out.println(sbt);
			 System.out.println(kkt);
			 System.out.println(stotal);
			 scount=0;
			 System.out.println("after zero "+scount);
		 }
		 if(gcount>0)
		 {
			 gbill=goldrate*gcount;
			 gstt=gbill*gst/100;
			 sbt=gbill*swacchbharattax/100;
			 kkt=gbill*krushikalyantax/100;
			 gtotal=gbill+gstt+sbt+kkt;
			 System.out.println(gcount);
			 System.out.println(gstt);
			 System.out.println(sbt);
			 System.out.println(kkt);
			 System.out.println(gtotal);
			 gcount=0;
			 System.out.println("after zero "+gcount);
		 }
		 total=ptotal+stotal+gtotal;
		 System.out.println("extra chargess bill "+gstt+"  "+sbt+"  "+kkt);
		 System.out.println("total is "+total);
		 
		 fund.add(total);
		 System.out.println(fund);
	 }
	
	
	static String decision;
	static void reboook()
	{
		System.out.println("want another seat book?????? press y for yes or press n for exit");
		Scanner sc=new Scanner(System.in);
		char dec=sc.next().toUpperCase().charAt(0);
		if(dec=='Y')
		{
			 pcount=0;
			 scount=0;
			 gcount=0;
			selected();
			count();
			reboook();
		}
		if(dec=='N')
		{
			bill();
			temp.clear();
		}
		
	}
	public static void main(String[] args) {
		Seats s=new Seats();
		s.display();
		do{
			selected();
			count();
			reboook();
			
			System.out.println(pcount+" "+scount+" "+gcount);
			System.out.println("do you want to book another seats?????  then press y");
			Scanner sc=new Scanner(System.in);
			decision=sc.next();
		}while(decision.equalsIgnoreCase("y"));
		System.out.println("Thank you ");
	}

}
