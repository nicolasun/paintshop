package com.hbc.paintshop;

import com.hbc.paintshop.calculate.CalculateColor;

/**
 * paint shop
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CalculateColor cc = new CalculateColor();
        
        String path = args[0];
        if(path==null || path =="") {
        	path = "./src/test/testFiles/3C4C.txt";
        }
        //cc.caculateColor(args[0]);
        String a = cc.calculateColor(path);
        System.out.println(a);
    }
}
