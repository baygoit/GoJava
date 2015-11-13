package com.gojava6.persistence.lesson2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Util {


  public static Date date(String s) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      return dateFormat.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }
}
