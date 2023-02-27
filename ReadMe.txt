What I want the program to do:

- User inputs number of digits (must be even, but don't bother checking)
- Computer generates two numbers with that number of digits
- The two numbers are used to initialize Karatsuba class
-  Karatsuba class must do following:
1. if digits == 1, return x * y
2. if digits != 1, a,b := first and last halves of x
3. c,d := first and last halves of y
4.  compute p:= a + b and q:= c +digits
5. compute abcd := pq-ac-bd
6. compute 10^n * ac + 10^n/2 * abcd +bd
7. return result