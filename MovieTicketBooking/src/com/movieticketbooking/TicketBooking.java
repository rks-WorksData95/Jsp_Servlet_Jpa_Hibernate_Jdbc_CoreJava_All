package com.movieticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

class Seats
{
	static ArrayList<String> plist=new ArrayList<String>();
	static ArrayList<String> BookedSeats=new ArrayList<String>();
	static int flag=0;
	
	static void PlatinumSeats(String p, ArrayList<String> PlatiniumList)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("How much seats you want to select : ");
		int Pseat=sc1.nextInt();
		System.out.println("Enter Seat Number : ");
		
		for(int i=0;i<Pseat;i++)
		{
			int P_SeatName=sc1.nextInt();
			plist.add("P"+P_SeatName);
			
			for(String selection:BookedSeats)
			{
				if(plist.contains(selection))
				{
					System.err.println("P"+P_SeatName+" seat is already booked by someone else please select another seats");
					plist.clear();
					flag=1;
				}
			}
			
		}
		
		System.out.println("Your Selected Seats are : "+plist);
		
		for(String x:PlatiniumList)
		{
			if(plist.contains(x))
			{	
				System.out.print("*"+x+"   ");
			}
			else
			{
				System.out.print(x+"   ");
			}
		}
		System.out.println();
		if(flag==0)
		{
			System.out.println("Your Seats are Booked...");
		}
		BookedSeats.addAll(plist);
		plist.clear();
		System.out.println("Booked Seats :"+BookedSeats );
		flag=0;
	}
	
	static void SilverSeats(String s, ArrayList<String> SilverList)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("How much seats you want to select : ");
		int Pseat=sc1.nextInt();
		System.out.println("Enter Seat Number : ");
		
		for(int i=0;i<Pseat;i++)
		{
			int P_SeatName=sc1.nextInt();
			plist.add("S"+P_SeatName);
			
			for(String selection:BookedSeats)
			{
				if(plist.contains(selection))
				{
					System.err.println("S"+P_SeatName+" seat is already booked by someone else please select another seats");
					plist.clear();
					flag=1;
				}
			}
			
		}
		
		System.out.println("Your Selected Seats are : "+plist);
		
		for(String y:SilverList)
		{
			if(plist.contains(y))
			{	
				System.out.print("*"+y+"   ");
			}
			else
			{
				System.out.print(y+"   ");
			}
		}
		System.out.println();
		if(flag==0)
		{
			System.out.println("Your Seats are Booked...");
		}
		BookedSeats.addAll(plist);
		plist.clear();
		System.out.println("Booked Seats :"+BookedSeats );
		flag=0;
	}
	
	static void GoldSeats(String g, ArrayList<String> GoldList)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("How much seats you want to select : ");
		int Pseat=sc1.nextInt();
		System.out.println("Enter Seat Number : ");
		
		for(int i=0;i<Pseat;i++)
		{
			int P_SeatName=sc1.nextInt();
			plist.add("G"+P_SeatName);
			
			for(String selection:BookedSeats)
			{
				if(plist.contains(selection))
				{
					System.err.println("G"+P_SeatName+" seat is already booked by someone else please select another seats");
					plist.clear();
					flag=1;
				}
			}
			
		}
		
		System.out.println("Your Selected Seats are : "+plist);
		
		for(String z:GoldList)
		{
			if(plist.contains(z))
			{	
				System.out.print("*"+z+"   ");
			}
			else
			{
				System.out.print(z+"   ");
			}
		}
		System.out.println();
		if(flag==0)
		{
			System.out.println("Your Seats are Booked...");
		}
		BookedSeats.addAll(plist);
		plist.clear();
		System.out.println("Booked Seats :"+BookedSeats );
		flag=0;
	}
	
	static void SeatSelection(ArrayList<String> PlatiniumList, ArrayList<String> SilverList, ArrayList<String> GoldList)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Seat Type Like p or s or g : ");
		String SelectRow=sc.nextLine();
		
		if(SelectRow.equalsIgnoreCase("p"))
		{
			PlatinumSeats("p",PlatiniumList);
		}
		else if(SelectRow.equalsIgnoreCase("s"))
		{
			SilverSeats("s",SilverList);
		}
		else if(SelectRow.equalsIgnoreCase("g"))
		{
			GoldSeats("g",GoldList);
		}
		else
		{
			System.out.println("Please Enter Proper Seat Type : ");
			SeatSelection(PlatiniumList,SilverList,GoldList);
		}
	}
	
}

public class TicketBooking {
	
	public static void main(String args[])
	{
		
		String Decision;
		
		ArrayList<String> PlatiniumList=new ArrayList<String>();
		PlatiniumList.add("P1");
		PlatiniumList.add("P2");
		PlatiniumList.add("P3");
		PlatiniumList.add("P4");
		PlatiniumList.add("P5");
		PlatiniumList.add("P6");
		PlatiniumList.add("P7");
		PlatiniumList.add("P8");
		PlatiniumList.add("P9");
		
		ArrayList<String> SilverList=new ArrayList<String>();
		SilverList.add("S1");
		SilverList.add("S2");
		SilverList.add("S3");
		SilverList.add("S4");
		SilverList.add("S5");
		SilverList.add("S6");
		SilverList.add("S7");
		SilverList.add("S8");
		SilverList.add("S9");
		
		ArrayList<String> GoldList=new ArrayList<String>();
		GoldList.add("G1");
		GoldList.add("G2");
		GoldList.add("G3");
		GoldList.add("G4");
		GoldList.add("G5");
		GoldList.add("G6");
		GoldList.add("G7");
		GoldList.add("G8");
		GoldList.add("G9");
		
		System.out.println("PlatiniumList : "+PlatiniumList);
		System.out.println("SilverList    : "+SilverList);
		System.out.println("GoldList      : "+GoldList);
		
		do
		{
			Scanner sc=new Scanner(System.in);
			Seats.SeatSelection(PlatiniumList,SilverList,GoldList);
			System.out.println("Do You Want To Select More Seats (y / n) : ");
			Decision=sc.nextLine();
		}while(Decision.equalsIgnoreCase("y"));
		
		System.out.println("Thank You...");
	}

}
