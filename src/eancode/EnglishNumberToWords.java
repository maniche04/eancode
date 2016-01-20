/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eancode;

import java.text.DecimalFormat;

/**
 *
 * @author santosh
 */
public class  EnglishNumberToWords {

  private static final String[] tensNames = {
    "",
    " Ten",
    " Twenty",
    " Thirty",
    " Forty",
    " Fifty",
    " Sixty",
    " Seventy",
    " Eighty",
    " Ninety"
  };

  private static final String[] numNames = {
    "",
    " One",
    " Two",
    " Three",
    " Four",
    " Five",
    " Six",
    " Seven",
    " Eight",
    " Nine",
    " Ten",
    " Eleven",
    " Twelve",
    " Thirteen",
    " Fourteen",
    " Fifteen",
    " Sixteen",
    " Seventeen",
    " Eighteen",
    " Nineteen"
  };

  private EnglishNumberToWords() {}

  private static String convertLessThanOneThousand(int number) {
    String soFar;

    if (number % 100 < 20){
      soFar = numNames[number % 100];
      number /= 100;
    }
    else {
      soFar = numNames[number % 10];
      number /= 10;

      soFar = tensNames[number % 10] + soFar;
      number /= 10;
    }
    if (number == 0) return soFar;
    return numNames[number] + " Hundred" + soFar;
  }


  public static String convert(long number) {
    //0 to 999 999 999 999
    if (number == 0) { return "zero"; }

    String snumber = Long.toString(number);

    // pad with "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int billions = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int millions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int thousands = Integer.parseInt(snumber.substring(9,12));
    
  
    String tradBillions;

    switch (billions) {
    case 0:
      tradBillions = "";
      break;
    case 1 :
      tradBillions = convertLessThanOneThousand(billions)
      + " Billion ";
      break;
    default :
      tradBillions = convertLessThanOneThousand(billions)
      + " Billion ";
    }
    
    String result =  tradBillions;
    String tradMillions;
    switch (millions) {
    case 0:
      tradMillions = "";
      break;
    case 1 :
      tradMillions = convertLessThanOneThousand(millions)
         + " Million ";
      break;
    default :
      tradMillions = convertLessThanOneThousand(millions)
         + " Million ";
    }
    
    result =  result + tradMillions;

    String tradHundredThousands;
    switch (hundredThousands) {
    case 0:
      tradHundredThousands = "";
      break;
    case 1 :
      tradHundredThousands = "One Thousand ";
      break;
    default :
      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
         + " Thousand ";
    }
    result =  result + tradHundredThousands;

    String tradThousand;
    tradThousand = convertLessThanOneThousand(thousands);
    result =  result + tradThousand;

    // remove extra spaces!
    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
  }
  
public static String convertDicimal(String number) 
  {
    String decimalpointtotext = "";
      
    
     decimalpointtotext = "And " + checkDecimal(number.substring(1,2))+" "+checkDecimal(number.substring(2));
     return decimalpointtotext;   
  }
  
private static String checkDecimal(String str)
{
    String value="";
    
    switch (str)
     {
         case "0" :
             value = "Zero";
             break;
         case "1" :
             value = "One";
             break;
         case "2" :
             value = "Two";
             break;
         case "3" :
             value = "Three";
             break;
         case "4" :
             value = "Four";
             break;
         case "5" :
             value = "Five";
             break;
         case "6" :
             value = "Six";
             break;
         case "7" :
             value = "Seven";
             break;
         case "8" :
             value = "Eight";
             break;
         case "9" :
             value = "Nine";
             break;
         default :
                
     }
  return value;
}

}
