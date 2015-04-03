package ua.goit.xmlparsertdd;

import java.util.HashSet;
import java.util.Set;

public class CharUtil {
  static Set<Character> nameStartChar= new HashSet<Character>();
  static Set<Character> nameChar= new HashSet<Character>();
  
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
    addCharsToSet(0x10000, 0xEFFFF, nameStartChar );
    
    addCharsToSet(0x10000, 0xEFFFF, nameChar );
    nameChar.add('-');
    nameChar.add('.');
    nameChar.add((char)0xB7);
    addCharsToSet('0','9',nameChar );
    addCharsToSet(0x0300, 0x036F,nameChar );
    addCharsToSet(0x203F,0x2040, nameChar );
  };

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
  
  
  private CharUtil(){}
  
  public static boolean isEmptyChar(char symb){
    boolean res = false;
    res = (symb == ' ') || (symb == '\n')|| (symb == '\t')|| (symb == '\r');
    return res;
  } 

  public static boolean isNameChar(char ch){
    boolean res = false;
    
    if(nameStartChar.contains(ch)){
      res = true;
    }else{
      res = nameChar.contains(ch);
    }
    return res;
  }
  
  public static boolean isNameStartChar(char ch){
    boolean res = false;
    res = nameStartChar.contains(ch);
    return res;
  } 

}
