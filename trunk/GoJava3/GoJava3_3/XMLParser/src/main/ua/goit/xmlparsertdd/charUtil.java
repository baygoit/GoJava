package ua.goit.xmlparsertdd;

import java.util.HashSet;
import java.util.Set;

public class charUtil {
  static Set<Character> nameStartChar= new HashSet<Character>();
  static Set<Character> nameChar= new HashSet<Character>();
  
  static{
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
    addCharsToSet(0x10000, 0xEFFFF, nameStartChar );
    
  };
  static void addCharsToSet(char start,char end, Set charSet){
    if (start > end){
      return;
    }
    for(char ch = start; ch<= end; ch++){
      charSet.add(ch);
    } 
  }
  
  static void addCharsToSet(int start,int end, Set charSet){
    if (start > end){
      return;
    }
    for(char ch = (char)start; ch<= (char)end; ch++){
      charSet.add(ch);
    } 
  }
  
  
  private charUtil(){}
  
  static public boolean isEmptyChar(char symb){
    boolean res = false;
    res = (symb == ' ') || (symb == '\n')|| (symb == '\t')|| (symb == '\r');
    return res;
      
  
  } 
  static public boolean isNameChar(char ch){
    boolean res = false;
    res = ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    return res;
  }
  
  static public boolean isNameStartChar(char ch){
    boolean res = false;
    res = ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '1' && ch <= '0')) ;
    return res;
  } 

}
