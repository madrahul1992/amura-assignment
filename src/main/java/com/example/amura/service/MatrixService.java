package com.example.amura.service;


import com.example.amura.model.MatrixOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class MatrixService {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    MatrixOutput matrixOutput;

    static int subMatrix[][];

    static int maxLeft = 0, maxRight = 0, maxHeight = 0;

    public MatrixOutput subMatrix(int[][] matrix) throws Exception{
        int rows = matrix.length;
        if(rows <= 0){
            throw new Exception("Input is not valid");
        }
        int columns = matrix[0].length;
        return maxRectangle(rows, columns, matrix);
    }

    /**
     * Returns largest sub matrix of the largest rectangle with all 1s in
     * A[][]
     * @param R
     * @param C
     * @param A
     * @return
     */
    private MatrixOutput maxRectangle(int R,int C, int A[][])
    {
        // Calculate area for first row and initialize it as
        // result
        int up = 0;
        int left=0, right =0, height =0;
        int result = maxAreaHistogram(R,C,A[up]);

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (int i = 1; i < R; i++)
        {

            for (int j = 0; j < C; j++)
                // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];


            // Update area and values if area with current row (as last
            // row of rectangle) is more

            int area1 = maxAreaHistogram(R,C,A[i]);
            if(area1 > result){
                result = area1;
                up = i;
                left = maxLeft;
                right = maxRight;
                height = maxHeight;
            }
        }

        matrixOutput.setX(up-height+1);
        matrixOutput.setY(left);
        matrixOutput.setWidth(right-left);
        matrixOutput.setHeight(height);

        return maxSubMatrix(matrixOutput);
    }

    /**
     * Finds the maximum area under the histogram represented
     * by histogram. See below article for details.
     * @param R
     * @param C
     * @param row
     * @return max_area
     */
    private int maxAreaHistogram(int R,int C,int row[])
    {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        Stack<Integer> result = new Stack<Integer>();

        int top_val;	 // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0; // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C)
        {
            // If this bar is higher than the bar on top stack,
            // push it to stack
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);

            else
            {
                // If this bar is lower than top of stack, then
                // calculate area of rectangle with stack top as
                // the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before
                // top in stack is 'left index'
                top_val = row[result.peek()];
                int left = result.pop();
                area = top_val * i;

                if (!result.empty()){
                    area = top_val * (i - result.peek() - 1 );
                    left = result.peek() + 1;
                }

                if(area > max_area){
                    max_area = area;
                    maxLeft = left;
                    maxHeight = top_val;
                    maxRight = i;
                }

            }
        }

        // Now pop the remaining bars from stack and calculate
        // area with every popped bar as the smallest bar
        while (!result.empty())
        {
            top_val = row[result.peek()];
            int left = result.pop();
            area = top_val * i;
            if (!result.empty()){
                area = top_val * (i - result.peek() - 1 );
                left = result.peek() + 1;
            }

            if(area > max_area){
                max_area = area;
                maxLeft = left;
                maxRight = i;
                maxHeight = top_val;
            }
        }
        return max_area;
    }

    /**
     * Create matrix with given x,y and width and height
     * @param matrixOutput
     * @return MatrixOutput
     */
    private MatrixOutput maxSubMatrix(MatrixOutput matrixOutput) {
        subMatrix = new int[matrixOutput.getHeight()][matrixOutput.getWidth()];
        for(int k = 0;k < matrixOutput.getHeight(); k++)
        {
            for(int p = 0; p < matrixOutput.getWidth(); p++){
                subMatrix[k][p] = 1;
            }
            System.out.println();
        }

        matrixOutput.setSubMatrix(subMatrix);
        return matrixOutput;
    }


}
