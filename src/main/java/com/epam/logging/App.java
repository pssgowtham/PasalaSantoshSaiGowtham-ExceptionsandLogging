package com.epam.logging;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
public class App 
{
	private static final Logger LOGGER = LogManager.getLogger(App.class);
	float estimate_cost(int material_standard,float areaofhouse,boolean fullyautomated)
	{
		float cost=0;
		switch(material_standard)
		{
		case 1: cost=(1200*areaofhouse); break;
		case 2: cost=(1500*areaofhouse); break;
		case 3: cost=(1800*areaofhouse); break;
		case 4: if(fullyautomated==true) {
			cost=(2500*areaofhouse);
		}break;
		default:break;
		}
		return cost;
	}
	void sici() 
	{
		double pr, rate, t, sim,com;
        Scanner sc = new Scanner (System. in);
        LOGGER.info("\n\nSimple and Compound Interest\n\n");
        LOGGER.info("Enter the amount:");
        pr=sc.nextDouble();
        LOGGER.info("Enter the No.of years:");
        t=sc.nextDouble();
        LOGGER.info("Enter the Rate of  interest:");
        rate=sc.nextDouble();
        sim=(pr * t * rate)/100;	//Simple interest
        com=pr * Math.pow(1.0+rate/100.0,t) - pr;	//compound interest
        DecimalFormat numf = new DecimalFormat("#.00");
        LOGGER.info("Simple Interest = "+numf.format(sim));	//using decimal format
        LOGGER.info("Compound Interest = "+numf.format(com));
        sc.close();
	}
    public static void main( String[] args )
    {
    	int material_standard;
		float areaofhouse;
		boolean fullyautomated=false;
		float total_cost;
 		Scanner sc = new Scanner (System.in);
 		LOGGER.info("Build Construction\n");
 		LOGGER.info("\n1.Standard Materials.\n2.Above Standard Materials\n3.High Standard Materials\n4.If you want fully automated home\nPlease Select Material Standard::");
		material_standard=sc.nextInt();
		
		if(material_standard==4)
			fullyautomated= true;
    
		LOGGER.info("Enter total area of house required(sq.ft):");
		areaofhouse=sc.nextFloat();
	
		App b=new App();
		total_cost=b.estimate_cost(material_standard,areaofhouse,fullyautomated);
		
		LOGGER.info("Cost required to buld a house based on your requirements is "+total_cost+" INR");
		b.sici();
		sc.close();
    }
}
