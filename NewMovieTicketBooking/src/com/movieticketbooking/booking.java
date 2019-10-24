package com.movieticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

class selection
{
	int prate=250;
	int srate=200;
	int grate=150;
	int gst=10;
	int bkk=5;
	int sb=5;
	
	int pcount=0;
	int scount=0;
	int gcount=0;
	
	double pprice=0;
	double sprice=0;
	double gprice=0;
	double gstprice=0;
	double bkkprice=0;
	double sbprice=0;
	double totalprice=0;
	
	static int dayticketcount=0;
	static double daypprice=0;
	static double daysprice=0;
	static double daygprice=0;
	static double daygstprice=0;
	static double daybkkprice=0;
	static double daysbprice=0;
	static double daytotalprice=0;
	
	
	Seats sb1=new Seats();
	
	ArrayList<String> selectseat=new ArrayList<String>();
	static ArrayList<String> bookedseat=new ArrayList<String>();
	static ArrayList<String> bookedseat2=new ArrayList<String>();
	static ArrayList<String> bookedseat3=new ArrayList<String>();
	
	void selectscreen1()
	{
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		
		System.out.println("Enter Seat Number You Wnat To Book : ");
		int n=sc1.nextInt();
		
		System.out.println("Enter Seat Number : ");
		for(int i=0;i<n;i++)
		{
			String seatno=sc2.nextLine();
			
			if(!sb1.plist.contains(seatno) && !sb1.glist.contains(seatno) && !sb1.slist.contains(seatno)) {
				System.err.println("Wrong seat number, Please enter correct seat number.");
				i--;
			}else {
				selectseat.add(seatno); 
			}
			
			for(String selection:bookedseat)
			{
				if(selectseat.contains(selection))
				{
					System.err.println(seatno+" Seat is already booked , please select another seats.");
					selectseat.remove(seatno);
					i--;
				}
			}
		}
		
		bookedseat.addAll(selectseat);
		selectseat.clear();
		System.out.println("Screen1 Booked Seats Are : "+bookedseat);
	}
	
	void selectscreen2()
	{
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		
		System.out.println("Enter Seat Number You Wnat To Book : ");
		int n=sc1.nextInt();
		
		System.out.println("Enter Seat Number : ");
		for(int i=0;i<n;i++)
		{
			String seatno=sc2.nextLine();
			
			if(!sb1.plist.contains(seatno) && !sb1.glist.contains(seatno) && !sb1.slist.contains(seatno)) {
				System.err.println("Wrong seat number, Please enter correct seat number.");
				i--;
			}else {
				selectseat.add(seatno);
			}
			
			for(String selection:bookedseat2)
			{
				if(selectseat.contains(selection))
				{
					System.err.println(seatno+" Seat is already booked , please select another seats.");
					selectseat.remove(seatno);
					i--;
				}
			}
		}
		bookedseat2.addAll(selectseat);
		selectseat.clear();
		System.out.println("Screen2 Booked Seats Are : "+bookedseat2);
	}
	
	void selectscreen3()
	{
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		
		System.out.println("Enter Seat Number You Wnat To Book : ");
		int n=sc1.nextInt();
		
		System.out.println("Enter Seat Number : ");
		for(int i=0;i<n;i++)
		{
			String seatno=sc2.nextLine();
			
			if(sb1.plist.contains(seatno) || sb1.glist.contains(seatno) || sb1.slist.contains(seatno)) {
				selectseat.add(seatno);
			}else {
				System.err.println("Wrong seat number, Please enter correct seat number.");
				i--;
			}
			
			for(String selection:bookedseat3)
			{
				if(selectseat.contains(selection))
				{
					System.err.println(seatno+" Seat is already booked , please select another seats.");
					selectseat.remove(seatno);
					i--;
				}
			}
		}
		bookedseat3.addAll(selectseat);
		selectseat.clear();
		System.out.println("Screen 3 Booked Seats Are : "+bookedseat3);
	}
	
	void bill1()
	{
		
		for(String no:sb1.plist)
		{
			if(bookedseat.contains(no))
			{
				pcount++;
			}
		}
		for(String no1:sb1.slist)
		{
			if(bookedseat.contains(no1))
			{
				scount++;
			}
		}
		for(String no2:sb1.glist)
		{
			if(bookedseat.contains(no2))
			{
				gcount++;
			}
		}
		
		System.out.println("------------------------------Bill------------------------------");
		System.out.println("Total Ticket : "+(gcount+scount+pcount));
		pprice=prate*pcount;
		double gst1=(pprice*gst)/100;
		double bkk1=(pprice*bkk)/100;
		double sb1=(pprice*sb)/100;
		
		sprice=srate*scount;
		double gst2=(sprice*gst)/100;
		double bkk2=(sprice*bkk)/100;
		double sb2=(sprice*sb)/100;
		
		gprice=grate*gcount;
		double gst3=(gprice*gst)/100;
		double bkk3=(gprice*bkk)/100;
		double sb3=(gprice*sb)/100;
		
		double totalgst=gst1+gst2+gst3;
		double totalbkk=bkk1+bkk2+bkk3;
		double totalsb=sb1+sb2+sb3;
		double totalprice=pprice+sprice+gprice;
		double grandtotal=totalprice+totalgst+totalbkk+totalsb;
		
		System.out.println("Platanum ("+pcount+") : "+pprice);
		System.out.println("Silver   ("+scount+") : "+sprice);
		System.out.println("Gold     ("+gcount+") : "+gprice);
		System.out.println("Gst : "+totalgst+"    Bkk : "+totalbkk+"    Sb : "+totalsb);
		System.out.println("Total Price : "+grandtotal);
		System.out.println("----------------------------------------------------------------");
		
		dayticketcount=dayticketcount+(gcount+scount+pcount);
		daypprice=daypprice+pprice;
		daysprice=daysprice+sprice;
		daygprice=daygprice+gprice;
		daygstprice=daygstprice+totalgst;
		daybkkprice=daybkkprice+totalbkk;
		daysbprice=daysbprice+totalsb;
		daytotalprice=daytotalprice+grandtotal;
		
	}
	
	void bill2()
	{
		
		for(String no:sb1.plist)
		{
			if(bookedseat2.contains(no))
			{
				pcount++;
			}
		}
		for(String no1:sb1.slist)
		{
			if(bookedseat2.contains(no1))
			{
				scount++;
			}
		}
		for(String no2:sb1.glist)
		{
			if(bookedseat2.contains(no2))
			{
				gcount++;
			}
		}
		
		System.out.println("------------------------------Bill------------------------------");
		System.out.println("Total Ticket : "+(gcount+scount+pcount));
		pprice=prate*pcount;
		double gst1=(pprice*gst)/100;
		double bkk1=(pprice*bkk)/100;
		double sb1=(pprice*sb)/100;
		
		sprice=srate*scount;
		double gst2=(sprice*gst)/100;
		double bkk2=(sprice*bkk)/100;
		double sb2=(sprice*sb)/100;
		
		gprice=grate*gcount;
		double gst3=(gprice*gst)/100;
		double bkk3=(gprice*bkk)/100;
		double sb3=(gprice*sb)/100;
		
		double totalgst=gst1+gst2+gst3;
		double totalbkk=bkk1+bkk2+bkk3;
		double totalsb=sb1+sb2+sb3;
		double totalprice=pprice+sprice+gprice;
		double grandtotal=totalprice+totalgst+totalbkk+totalsb;
		
		System.out.println("Platanum ("+pcount+") : "+pprice);
		System.out.println("Silver   ("+scount+") : "+sprice);
		System.out.println("Gold     ("+gcount+") : "+gprice);
		System.out.println("Gst : "+totalgst+"    Bkk : "+totalbkk+"    Sb : "+totalsb);
		System.out.println("Total Price : "+grandtotal);
		System.out.println("----------------------------------------------------------------");
		
		dayticketcount=dayticketcount+(gcount+scount+pcount);
		daypprice=daypprice+pprice;
		daysprice=daysprice+sprice;
		daygprice=daygprice+gprice;
		daygstprice=daygstprice+totalgst;
		daybkkprice=daybkkprice+totalbkk;
		daysbprice=daysbprice+totalsb;
		daytotalprice=daytotalprice+grandtotal;
	}
	
	void bill3()
	{
		
		for(String no:sb1.plist)
		{
			if(bookedseat3.contains(no))
			{
				pcount++;
			}
		}
		for(String no1:sb1.slist)
		{
			if(bookedseat3.contains(no1))
			{
				scount++;
			}
		}
		for(String no2:sb1.glist)
		{
			if(bookedseat3.contains(no2))
			{
				gcount++;
			}
		}
		
		System.out.println("------------------------------Bill------------------------------");
		System.out.println("Total Ticket : "+(gcount+scount+pcount));
		pprice=prate*pcount;
		double gst1=(pprice*gst)/100;
		double bkk1=(pprice*bkk)/100;
		double sb1=(pprice*sb)/100;
		
		sprice=srate*scount;
		double gst2=(sprice*gst)/100;
		double bkk2=(sprice*bkk)/100;
		double sb2=(sprice*sb)/100;
		
		gprice=grate*gcount;
		double gst3=(gprice*gst)/100;
		double bkk3=(gprice*bkk)/100;
		double sb3=(gprice*sb)/100;
		
		double totalgst=gst1+gst2+gst3;
		double totalbkk=bkk1+bkk2+bkk3;
		double totalsb=sb1+sb2+sb3;
		double totalprice=pprice+sprice+gprice;
		double grandtotal=totalprice+totalgst+totalbkk+totalsb;
		
		System.out.println("Platanum ("+pcount+") : "+pprice);
		System.out.println("Silver   ("+scount+") : "+sprice);
		System.out.println("Gold     ("+gcount+") : "+gprice);
		System.out.println("Gst : "+totalgst+"    Bkk : "+totalbkk+"    Sb : "+totalsb);
		System.out.println("Total Price : "+grandtotal);
		System.out.println("----------------------------------------------------------------");
		
		dayticketcount=dayticketcount+(gcount+scount+pcount);
		daypprice=daypprice+pprice;
		daysprice=daysprice+sprice;
		daygprice=daygprice+gprice;
		daygstprice=daygstprice+totalgst;
		daybkkprice=daybkkprice+totalbkk;
		daysbprice=daysbprice+totalsb;
		daytotalprice=daytotalprice+grandtotal;
	}
	
	void selectscreen()
	{
		Scanner sc=new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		String decision;
		
		System.out.println("Select Screen (1 or 2 or 3): ");
		int screen=sc.nextInt();

		switch(screen)
		{
			case 1:
				    selection s=new selection();
					do
					{
						s.selectscreen1();
						
						System.out.println("do you want to book another seats? then press y");
						decision=sc1.nextLine();
						
					}while(decision.equalsIgnoreCase("y"));
					
					s.bill1();
					
					break;
			case 2:
					selection s1=new selection();
					do
					{
						s1.selectscreen2();
						
						System.out.println("do you want to book another seats? then press y");
						decision=sc1.nextLine();
						
					}while(decision.equalsIgnoreCase("y"));
					
					s1.bill2();
					
					break;
			case 3:
					selection s2=new selection();
					do
					{
						s2.selectscreen3();
						
						System.out.println("do you want to book another seats? then press y");
						decision=sc1.nextLine();
						
					}while(decision.equalsIgnoreCase("y"));
					
					s2.bill3();
					
					break;
			default:
				    System.err.println("Please, Enter screen between 1 to 3. ");
				    selectscreen();
				    break;
					
		}
	}
	
	void wholedaybill()
	{
		System.out.println("============= Whole Day Collection =============");
		System.out.println("Total Ticket : "+selection.dayticketcount);
		System.out.println("Total Platinum Seat Collection : "+selection.daypprice);
		System.out.println("Total Silver Seat Collection   : "+selection.daysprice);
		System.out.println("Total Gold Seat Collection     : "+selection.daygprice);
		System.out.println("Total GST : "+selection.daygstprice);
		System.out.println("Total BKK : "+selection.daybkkprice);
		System.out.println("Total SB  : "+selection.daysbprice);
		System.out.println("Total Collection : "+selection.daytotalprice);
		System.out.println("================================================");
	}
}



public class booking
{	
	public static void main(String args[])
	{
		Seats s=new Seats();
		s.display();
		String decision1;
		Scanner sc=new Scanner(System.in);
		do
		{
			selection obj=new selection();
			obj.selectscreen();
			
			System.out.println("Book seats? then press y");
			decision1=sc.nextLine();
			
		}while(decision1.equalsIgnoreCase("y"));
		
		selection sel=new selection();
		sel.wholedaybill();
		System.out.println("Thank you...");
	}	
}
