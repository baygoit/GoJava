package goit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class LonelyNumber {

    private List<Integer> number;
    private Map<Integer, Integer> uniqueNumber;
    private Integer minValue;

    LonelyNumber(List<Integer> number) {
        this.number = number;
        prepare();
        setMinValue(Collections.min(uniqueNumber.values()));
    }

    private void prepare() {
        uniqueNumber =  new HashMap<Integer, Integer>();
        for (Integer element : number) {
            if (!uniqueNumber.containsKey(element)) {
                uniqueNumber.put(element, Collections.frequency(number, element));
            }
        }
    }

    private void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    Integer getMinValue() {
        return minValue;
    }

    List<Integer> retrieve() {
        List<Integer> result = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> element : uniqueNumber.entrySet()) {
            if (element.getValue().compareTo(minValue) == 0) {
                result.add(element.getKey());
            }
        }
        return result;
    }
}
