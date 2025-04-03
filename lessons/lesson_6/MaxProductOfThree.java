// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
package lessons.lesson_6;

import java.util.*;

public class MaxProductOfThree {
    public int solution(int[] A) {
        // Sort the array in ascending order
        Arrays.sort(A);

        // Calculate the product of the three largest numbers
        int n = A.length;
        int product1 = A[n - 1] * A[n - 2] * A[n - 3];

        // Calculate the product of the two smallest numbers and the largest number
        int product2 = A[0] * A[1] * A[n - 1];

        // Return the maximum of the two products
        return Math.max(product1, product2);
    }
    
}
