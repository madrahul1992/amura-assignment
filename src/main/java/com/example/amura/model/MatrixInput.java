package com.example.amura.model;

import com.example.amura.validation.MatrixInputValidationInterface;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MatrixInput {

    @JsonProperty("matrix")
    @MatrixInputValidationInterface
    private int[][] matrix;

    public MatrixInput(){}

    public MatrixInput(int[][] matrix){
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

}
