
public class BinarySearch {
    public static void main(String[] args) {
	int[] initialMass = {26, 26, 29, 8, 10, 15, 16, 17, 25};
	System.out.println(returnIndex(initialMass, 26));
    }

    public static int returnIndex(int[] m, int elementToSearch) {
	int startIndex = 0;
	int endIndex = m.length - 1;
	int middleIndex = (endIndex - startIndex) / 2;
	while (elementToSearch != m[middleIndex] && startIndex < endIndex) {
	    if (middleIndex == startIndex || middleIndex == endIndex) {
		return -1;
	    }
	    if (elementToSearch < m[middleIndex]) {
		if (elementToSearch >= m[startIndex]) {
		    endIndex = middleIndex;
		    middleIndex = backward(startIndex, endIndex);
		} else if (m[startIndex] > m[middleIndex]) {
		    endIndex = middleIndex;
		    middleIndex = backward(startIndex, endIndex);
		} else {
		    startIndex = middleIndex;
		    middleIndex = forward(startIndex, endIndex);
		}
	    } else {
		if (elementToSearch <= m[endIndex]) {
		    startIndex = middleIndex;
		    middleIndex = forward(startIndex, endIndex);
		} else if (m[endIndex] < m[middleIndex]){
		    startIndex = middleIndex;
		    middleIndex = forward(startIndex, endIndex);
		} else {
		    endIndex = middleIndex;
		    middleIndex = backward(startIndex, endIndex);
		}
	    }
	}
	
	return middleIndex; 
    }

    private static int forward (int startIndex, int endIndex) {
	return startIndex + Math.abs(endIndex - startIndex + 1) / 2;
    }

    private static int backward (int startIndex, int endIndex) {
	return endIndex - Math.abs(endIndex - startIndex + 1) / 2;
    }
}
