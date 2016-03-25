package com.vladik;

import java.util.*;


public class DistanceCalculator {
    private List<Integer> listOfInputs = new ArrayList<>();

    public DistanceCalculator(List<Integer> listOfInputs) {

        this.listOfInputs = listOfInputs;
    }

    private List<Integer> getMinInputs() {
        if (listOfInputs.size() < 2) {
            listOfInputs = new ArrayList<>(Arrays.<Integer>asList(0, 0));
        }
        List<Integer> sortedList = new ArrayList<>(listOfInputs);
        Collections.sort(sortedList);
        return sortedList.subList(0, 2);
    }

    private boolean hasDuplicates(int input) {
        return Collections.frequency(listOfInputs, input) > 1;
    }

    public List<Integer> findDistanceBetweenTwoMinimumInputs() {
        List<Integer> minInputs = getMinInputs();
        int firstMinInput = minInputs.get(0);
        int secondMinInput = minInputs.get(1);
        List<Integer> listOfIndexes = getIndexes(firstMinInput);

        if(!hasDuplicates(firstMinInput) && hasDuplicates(secondMinInput)){
            listOfIndexes.addAll(getIndexes(secondMinInput));
        }
        else if(!hasDuplicates(firstMinInput) && !hasDuplicates(secondMinInput)) {
            listOfIndexes.addAll(getIndexes(secondMinInput));
        }
        return findDistancesBetweenIndexes(listOfIndexes);
    }

    private List<Integer> findDistancesBetweenIndexes(List<Integer> listOfIndexes) {
        List<Integer> resultList = new ArrayList<>();
        int size = listOfIndexes.size();
        if(!hasDuplicates(getMinInputs().get(0)) && hasDuplicates(getMinInputs().get(1))){
            size = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 1; i != j && j < listOfIndexes.size(); j++) {
                resultList.add(Math.abs(listOfIndexes.get(j) - listOfIndexes.get(i)));
            }
        }
        return resultList;
    }

    private List<Integer> getIndexes(int input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listOfInputs.size(); i++) {
            if (listOfInputs.get(i) == input) {
                list.add(i);
            }
        }
        return list;
    }

    public void setListOfInputs(List<Integer> listOfInputs) {
        this.listOfInputs = listOfInputs;
    }
}
