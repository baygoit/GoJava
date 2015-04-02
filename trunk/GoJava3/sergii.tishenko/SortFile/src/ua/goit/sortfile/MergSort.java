package ua.goit.sortfile;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergSort {

  public static void main(String[] args) {

    final List<Integer> inParam = new LinkedList<Integer>(Arrays.asList(32, -5,
        0, 7, 92, 3, 5, 65, 23, 123, 7, 9));

    List<Integer> res = sortArray(inParam.subList(0, inParam.size() / 2),
        inParam.subList(inParam.size() / 2, inParam.size()));

    System.out.println("-----------------");
    System.out.println("Result:" + res);

  }

  static List<Integer> sortArray(List<Integer> inParam) {

    return sortArray(inParam.subList(0, inParam.size() / 2),
        inParam.subList(inParam.size() / 2, inParam.size()));
  }

  static List<Integer> sortArray(List<Integer> listOne, List<Integer> listTwo) {

    List<Integer> resultList = new LinkedList<Integer>();

    if (listOne.size() > 1) {
      listOne = sortArray(listOne.subList(0, listOne.size() / 2),
          listOne.subList(listOne.size() / 2, listOne.size()));
    }

    if (listTwo.size() > 1) {
      listTwo = sortArray(listTwo.subList(0, listTwo.size() / 2),
          listTwo.subList(listTwo.size() / 2, listTwo.size()));
    }

    Iterator<Integer> iter1 = listOne.iterator();
    Iterator<Integer> iter2 = listTwo.iterator();

    int val1 = iter1.next();
    int val2 = iter2.next();

    while (true) {
      if (val1 < val2) {

        resultList.add(val1);

        if (iter1.hasNext()) {
          val1 = iter1.next();
        } else {
          while (iter2.hasNext()) {
            resultList.add(val2);
            val2 = iter2.next();
          }
          resultList.add(val2);
          break;
        }
      } else {
        resultList.add(val2);

        if (iter2.hasNext()) {
          val2 = iter2.next();
        } else {
          while (iter1.hasNext()) {
            resultList.add(val1);
            val1 = iter1.next();
          }
          resultList.add(val1);
          break;
        }
      }

    }
    ;

    return resultList;
  }

}