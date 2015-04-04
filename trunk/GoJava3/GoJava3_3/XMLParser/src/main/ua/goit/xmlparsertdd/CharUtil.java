package ua.goit.xmlparsertdd;

import java.util.HashSet;
import java.util.Set;

public class CharUtil {
  static Set<Character> nameStartChar= new HashSet<>();
  static Set<Character> nameChar= new HashSet<>();
  
  static{
    nameStartChar.add(':');
    nameStartChar.add('_');
    addCharsToSet('a','z',nameStartChar );
    addCharsToSet('A','Z',nameStartChar );
    addCharsToSet(0xC0, 0xD6, nameStartChar );
    addCharsToSet(0xD8, 0xF6, nameStartChar );
    addCharsToSet(0xF8, 0x2FF, nameStartChar );
    addCharsToSet(0x370, 0x37D, nameStartChar );
    addCharsToSet(0x37F, 0x1FFF, nameStartChar );
    addCharsToSet(0x200C, 0x200D, nameStartChar );
    addCharsToSet(0x2070, 0x218F, nameStartChar );
    addCharsToSet(0x2C00, 0x2FEF, nameStartChar );
    addCharsToSet(0x3001,0xD7FF, nameStartChar );
    addCharsToSet(0xF900, 0xFDCF, nameStartChar );
    addCharsToSet(0xFDF0, 0xFFFD, nameStartChar );
//    addCharsToSet(0x10000, 0xEFFFF, nameStartChar );
    
    nameChar.add('-');
    nameChar.add('.');
    nameChar.add((char)0xB7);
    addCharsToSet('0','9',nameChar );
    addCharsToSet(0x0300, 0x036F,nameChar );
    addCharsToSet(0x203F,0x2040, nameChar );
  }

  private CharUtil(){}

  static void addCharsToSet(char start,char end, Set<Character> charSet){
    if (start > end){
      return;
    }
    for(char ch = start; ch<= end; ch++){
      charSet.add(ch);
    } 
  }
  
  static void addCharsToSet(int start,int end, Set<Character> charSet){
    if (start > end){
      return;
    }
    for(char ch = (char)start; ch<= (char)end; ch++){
      charSet.add(ch);
    } 
  }

  public static boolean isEmptyChar(char symb){
    return (symb == ' ') || (symb == '\n')|| (symb == '\t')|| (symb == '\r');
  } 

  public static boolean isNameChar(char ch){
    return nameStartChar.contains(ch) || nameChar.contains(ch);
  }
  
  public static boolean isNameStartChar(char ch){
    return nameStartChar.contains(ch);
  } 
  
  public static void print() {
    int i = 0;
    System.out.println("Start:");
    for (Character ch : nameChar) {
      System.out.print(ch + " ");
      i++;
      if(i % 100 == 0 )System.out.print("\n");
    }
  }
}
