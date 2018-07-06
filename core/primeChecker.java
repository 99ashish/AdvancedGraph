package com.jda.core;
import java.lang.Math;
public class CoordinateDistance
{
	public static void main(String[] args)
	{
	 float x=Float.valueOf(args[0]);
	 float y=Float.valueOf(args[1]);
	 float ans = x*x + y*y ;
	 System.out.println("Distance of point (" + x + "," + y + ") is " + Math.sqrt(ans) );
	}
	
	
}