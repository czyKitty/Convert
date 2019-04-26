import java.lang.Math;
import java.util.Scanner;

public class Convert
{
    public static void main(String [] argv)
    {
        boolean flag = true;
         
            System.out.println("Type of Converting:");
            System.out.println("1. Binary to Decimal.");
            System.out.println("2. Binary to Hexadecimal.");
            System.out.println("3. Decimal to Binary.");
            System.out.println("4. Decimal to Hexadecimal.");
            System.out.println("5. Hexadecimal to Binary.");
            System.out.println("6. Hexadecimal to Decimal.");
        
            System.out.print("Please Enter Converting Type Number (Enter q to quit):");
            Scanner type = new Scanner(System.in);
            String typeStr = type.nextLine();
            
            if (typeStr.equals("1"))
            {
                System.out.print("Please Enter Binary Number:");
                Scanner bin = new Scanner(System.in);
                String binStr = bin.nextLine();
                System.out.println(BinToDec(binStr));
            }
            else if (typeStr.equals("2"))
            {
                System.out.print("Please Enter Binary Number:");
                Scanner bin = new Scanner(System.in);
                String binStr = bin.nextLine();
                System.out.println(BinToHex(binStr));
            }
            else if (typeStr.equals("3"))
            {
                System.out.print("Please Enter Decimal Number:");
                Scanner dec = new Scanner(System.in);
                String decStr = dec.nextLine();
                System.out.println(DecToBin(decStr,""));
            }
            else if (typeStr.equals("4"))
            {
                System.out.print("Please Enter Decimal Number:");
                Scanner dec = new Scanner(System.in);
                String decStr = dec.nextLine();
                System.out.println(DecToHex(decStr,""));
            }
            else if (typeStr.equals("5"))
            {
                System.out.print("Please Enter Hexadecimal Number:");
                Scanner hex = new Scanner(System.in);
                String hexStr = hex.nextLine();
                System.out.println(HexToBin(hexStr));
            }
            else if (typeStr.equals("6"))
            {
                System.out.print("Please Enter Hexadecimal Number:");
                Scanner hex = new Scanner(System.in);
                String hexStr = hex.nextLine();
                System.out.println(HexToDex(hexStr));
            }
            else
            {
                System.out.print("Undefined Type, Try again!");
            }
    }
    
    
    /**
     * Convert binary to decimal.
     * @para String binNum, binary number.
     * @return String, decimal number.
     */
    private static String BinToDec(String binNum)
    {
        int decNum = 0; //Start decimal number at 0.
        for (int i = 1; i <= binNum.length(); i++)
        {
            if (binNum.charAt(binNum.length()-i) == '1')    //When the digit is 1, add 2 to the power of that digit.
                decNum += Math.pow(2,i-1);
        }
        return Integer.toString(decNum);
    }
    
    
    /**
     * Convert binary to hexadecimal.
     * @para String binNum, binary number.
     * @return String, hexadecimal number.
     */
    private static String BinToHex(String binNum)
    {
        String hexNum = ""; //Hexadecimal number in String.
        int count = 0;  //One digit exadecimal in int.
        int index = 0;
        
        for (int i = 1; i <= binNum.length(); i++)
        {
            index++;
            
            if (index == 4 || i == binNum.length())  //Whenever there's 4 digit of binary or when there's no more digits, change it to one digit hexadecimal and set index to 0.
            {
                if (binNum.charAt(binNum.length()-i) == '1')    //When the digit is 1, add 2 to the power of that digit.
                    count += Math.pow(2,index-1);

                if (count < 10) //If the digit is less than 10, it's same as decimal number.
                {
                    hexNum = Integer.toString(count)+hexNum;
                }
                else if (count == 10)   // 10 = A in hexadecimal.
                {
                    hexNum = "A"+hexNum;
                }
                else if (count == 11)   // 11 = B in hexadecimal.
                {
                    hexNum = "B"+hexNum;
                }
                else if (count == 12)   // 12 = C in hexadecimal.
                {
                    hexNum = "C"+hexNum;
                }
                else if (count == 13)   // 13 = D in hexadecimal.
                {
                    hexNum = "D"+hexNum;
                }
                else if (count == 14)   // 14 = E in hexadecimal.
                {
                    hexNum = "E"+hexNum;
                }
                else if (count == 15)   // 15 = F in hexadecimal.
                {
                    hexNum = "F"+hexNum;
                }
                count = 0;
                index = 0;
            }
            
            else
            {
                if (binNum.charAt(binNum.length()-i) == '1')    //When the digit is 1, add 2 to the power of that digit.
                    count += Math.pow(2,index-1);
            }
        }
        return hexNum;
    }
    
    
    /**
     * Convert decimal to binary.
     * @para String decNum, decimal number.
     * @return String, binary number.
     */
    private static String DecToBin(String decNum, String binNum)
    {
        if (Integer.parseInt(decNum) <= 1)
            return decNum+binNum;
        else
            return DecToBin(Integer.toString(Integer.parseInt(decNum)/2),Integer.toString(Integer.parseInt(decNum)%2)+binNum);
    }
    
    /**
     * Convert decimal to hexadecimal.
     * @para String decNum, decimal number.
     * @return String, haxadecimal number.
     */
    private static String DecToHex(String decNum, String hexNum)
    {
        int temp = Integer.parseInt(decNum);
        
        if (temp == 0)
            return hexNum;
        else if (temp%16 < 10) //If the digit is less than 10, it's same as decimal number.
            return DecToHex(Integer.toString(temp/16),temp%16+hexNum);
        else if (temp%16 == 10)   // 10 = A in hexadecimal.
            return DecToHex(Integer.toString(temp/16),"A"+hexNum);
        else if (temp%16 == 11)   // 11 = B in hexadecimal.
            return DecToHex(Integer.toString(temp/16),"B"+hexNum);
        else if (temp%16 == 12)   // 12 = C in hexadecimal.
            return DecToHex(Integer.toString(temp/16),"C"+hexNum);
        else if (temp%16 == 13)   // 13 = D in hexadecimal.
            return DecToHex(Integer.toString(temp/16),"D"+hexNum);
        else if (temp%16 == 14)   // 14 = E in hexadecimal.
            return DecToHex(Integer.toString(temp/16),"E"+hexNum);
        else if (temp%16 == 15)   // 15 = F in hexadecimal.
            return DecToHex(Integer.toString(temp/16),"F"+hexNum);
        else    // Otherwise, use decimal numbers.
            return DecToHex(Integer.toString(temp/16),hexNum);
    }
    
    /**
     * Convert hexadecimal to binary.
     * @para String hexNum, hexadecimal number.
     * @return String, binary number.
     */
    private static String HexToBin(String hexNum)
    {
        String binNum = "";
        int temp = 0;
        for (int i = 1; i <= hexNum.length();i++)
        {
            char digit = hexNum.charAt(hexNum.length()-i);
            int digitNum = Character.getNumericValue(digit);
            
            if (digit == 'A'|| digit == 'a')    // 10 = A in hexadecimal.
                temp = 10;
            else if (digit == 'B'|| digit == 'b')   // 11 = B in hexadecimal.
                temp = 11;
            else if (digit == 'C'|| digit == 'c')   // 12 = C in hexadecimal.
                temp = 12;
            else if (digit == 'D'|| digit == 'd')   // 13 = D in hexadecimal.
                temp = 13;
            else if (digit == 'E'|| digit == 'e')   // 14 = E in hexadecimal.
                temp = 14;
            else if (digit == 'F'|| digit == 'f')   // 15 = F in hexadecimal.
                temp = 15;
            else if (digitNum <= 1)
                binNum = digitNum+binNum;
            else
                temp = digitNum;
                
            while (temp!= 0)
            {
                if (temp%2 == 0)
                    binNum = "0"+binNum;
                else
                    binNum = "1"+binNum;
                
                temp = temp/2;
            }
        }
        return binNum;
    }

    
    /**
     * Convert hexadecimal to decimal.
     * @para String hexNum, hexadecimal number.
     * @return String, decimal number.
     */
    private static String HexToDex(String hexNum)
    {
        int decNum = 0;
        int temp = 0;
        
        for (int i = 1; i <= hexNum.length();i++)
        {
            char digit = hexNum.charAt(hexNum.length()-i);
            int digitNum = Character.getNumericValue(digit);
            
            if (digit == 'A'|| digit == 'a')    // 10 = A in hexadecimal.
                temp = 10;
            else if (digit == 'B'|| digit == 'b')   // 11 = B in hexadecimal.
                temp = 11;
            else if (digit == 'C'|| digit == 'c')   // 12 = C in hexadecimal.
                temp = 12;
            else if (digit == 'D'|| digit == 'd')   // 13 = D in hexadecimal.
                temp = 13;
            else if (digit == 'E'|| digit == 'e')   // 14 = E in hexadecimal.
                temp = 14;
            else if (digit == 'F'|| digit == 'f')   // 15 = F in hexadecimal.
                temp = 15;
            else
                temp = digitNum;
            
            decNum += temp*(int)Math.pow(16,i-1);
        }
        
        return Integer.toString(decNum);
    }
    
}
