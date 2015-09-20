package goit.lonelyNumber;

import java.util.*;

public class LonelyNumber {

    private List<Integer> number;
    private Map<Integer, Integer> uniqueNumber;
    private Integer minValue;

    public LonelyNumber(List<Integer> number) {
        this.number = number;
        prepare();
        setMinValue(Collections.min(uniqueNumber.values()));
    }

    private void prepare() {
        uniqueNumber = new HashMap<>();
        for (Integer element : number) {
            if (!uniqueNumber.containsKey(element)) {
                uniqueNumber.put(element, Collections.frequency(number, element));
            }
        }
    }

    private void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public List<Integer> retrieve() {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : uniqueNumber.entrySet()) {
            if (element.getValue().equals(minValue)) {
                result.add(element.getKey());
            }
        }
        return result;
    }
}
