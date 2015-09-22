#OneSwipeArray task description:#

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


