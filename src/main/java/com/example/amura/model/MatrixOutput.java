package com.example.amura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class MatrixOutput {

    public MatrixOutput(){

    }

    int x;
    int y;
    int width;
    int height;
    int[][] subMatrix;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getSubMatrix() {
        return subMatrix;
    }

    public void setSubMatrix(int[][] subMatrix) {
        this.subMatrix = subMatrix;
    }
}
