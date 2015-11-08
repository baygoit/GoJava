######Current task:######

A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7 
P = 2, difference = |4 − 9| = 5 
P = 3, difference = |6 − 7| = 1 
P = 4, difference = |10 − 3| = 7 
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

_previoius_

A non-empty zero-indexed array A consisting of N integers is given (A cannot be null, N >= 2)

You can perform a single swap operation in array A. This operation takes two indices I and J,
such that 0 <= I < J < N

The goal is to check whether array can be sorted into non-decreasing order at most one swipe operation

For example, consider array A such that:

A[0] = 1
A[1] = 2
A[2] = 4
A[3] = 3
A[4] = 2

After exchanging values A[2] and A[4] we obtain an array [1,2,2,3,4], which is sorted in non-decreasing order.

For this array we cannot do the same in one swipe:

A[0] = 1
A[1] = 2
A[2] = 5
A[3] = 7
A[4] = 2

A[3] swipe with A[4] - [1,2,5,2,7], then A[2] and A[3] - [1,2,2,5,7] - two swipe

You have to pass *OneSwipeArrayTest*

_previous_ Your home task consists of resolving two problem:
 - calculate number of island on a map (you have map - actually two dimensional array with 0 and 1,
    all 1s connected vertically, horizontally set one island - you have to calculate number of island per map );
 - Pascal Triangle  - calculate pascal triangle of a particular level.

You have two base classes in com.java6 package, you have to complete it to pass the test


