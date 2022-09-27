/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package CS4488.Capstone.Library.Tools;

import CS4488.Capstone.Library.BackEndSystemInterfaces.NumberConverterInterface;
import java.io.Serializable;

/**
 * Hex4Digit
 *
 * A class that holds a char[4] that represents a 4 digit hexadecimal number.
 * Contains various utilities for conversions.
 * @version 1.0
 * @author Traae
 */
public class Hex4digit implements NumberConverterInterface, Serializable {
    // Instance Variables
    private char[] hex;

    // Constructor
    public Hex4digit(){
        hex = makeBlankChar4();
    }
    public Hex4digit(char[] value){
        hex = makeBlankChar4();
        this.setValue(value);
    }
    public Hex4digit(short value){
        hex = makeBlankChar4();
        this.setValue(value);
    }

    private static char[] makeBlankChar4(){
        char[] array = new char[4];
        for (char c:array) {
            c = '0';
        }
        return array;
    }

    // Public Static Procedural Functions - Conversion Decimal<->Hexadecimal
    public static Short hexToDecimal(char[] hexArray){
                int index = 3;
        int power = 0;
        int result = 0;

        while (index > -1){
            result = result + (hexValue(hexArray[index]) * (int)Math.pow(16, power));
            index = index - 1;
            power = power + 1;
        }
        return (short) result;
    }
    public static char[] decimalToHex(short value){
        char[] output = makeBlankChar4();
        int index = 3;
        int remainder;
        int v = value;

        //TODO This while loop can be written with either index to 0, or v to 0.
        while (index > -1){
            remainder = v%16;
            v = v/16;
            output[index] = hexChar(remainder);
            index = index - 1;
        }
        return output;
    }
    public static char hexChar(int n){
        char result = '0';
        switch (n){
            case 0: result = '0';
                break;
            case 1:
                result = '1';
                break;
            case 2:
                result = '2';
                break;
            case 3:
                result = '3';
                break;
            case 4:
                result = '4';
                break;
            case 5:
                result = '5';
                break;
            case 6:
                result = '6';
                break;
            case 7:
                result = '7';
                break;
            case 8:
                result = '8';
                break;
            case 9:
                result = '9';
                break;
            case 10:
                result = 'a';
                break;
            case 11:
                result = 'b';
                break;
            case 12:
                result = 'c';
                break;
            case 13:
                result = 'd';
                break;
            case 14:
                result = 'e';
                break;
            case 15:
                result = 'f';
                break;
        }
        return result;
    }
    public static int hexValue(char n){
        int result = 0;
        switch (n){
            case '0':
                result = 0;
                break;
            case '1':
                result = 1;
                break;
            case '2':
                result = 2;
                break;
            case '3':
                result = 3;
                break;
            case '4':
                result = 4;
                break;
            case '5':
                result = 5;
                break;
            case '6':
                result = 6;
                break;
            case '7':
                result = 7;
                break;
            case '8':
                result = 8;
                break;
            case '9':
                result = 9;
                break;
            case 'a':
                result = 10;
                break;
            case 'b':
                result = 11;
                break;
            case 'c':
                result = 12;
                break;
            case 'd':
                result = 13;
                break;
            case 'e':
                result = 14;
                break;
            case 'f':
                result = 15;
                break;
        }
        return result;
    }

    // Utility Methods
    private void cleanString(String s){
        s.stripTrailing().stripLeading().toLowerCase().replaceAll("[^0-9a-f]","");
        if (s.length()>4){
            s = s.substring(0,3);
        }
    }

    // Setters
    @Override
    public void setValue(Short number) {
        hex = decimalToHex(number);
    }
    @Override
    public void setValue(String number) {
        cleanString(number);
        hex = number.toCharArray();
    }
    public void setValue(char[] number) {
        String toSet = new String(number);
        cleanString(toSet);
        hex = toSet.toCharArray();
    }

    public void setFirst(char first) {
        hex[0] = first;
    }

    public void setSecond(char second) {
        hex[1] = second;
    }

    public void setThird(char third) {
        hex[2] = third;
    }

    public void setForth(char forth) {
        hex[3] = forth;
    }

    @Override
    public Short getShort() {
        return hexToDecimal(this.hex);
    }
    @Override
    public char[] getHexChars() {
        return hex;
    }
    @Override
    public int getMiddle2Value() {
        char[] middle2 = new char[2];
        middle2[0] = hex[1];
        middle2[1] = hex[2];
        return hexToDecimal(middle2);
    }
    @Override
    public int getLast2Value() {
        char[] last2 = new char[2];
        last2[0] = hex[2];
        last2[1] = hex[3];
        return hexToDecimal(last2);
    }
}
