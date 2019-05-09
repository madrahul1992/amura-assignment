package com.example.amura.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatrixValidator implements ConstraintValidator<MatrixInputValidationInterface, Object> {

//   @Override
//   public void initialize(MatrixInputValidationInterface constraint) {
//   }

//   @Override
//   public boolean isValid(String obj, ConstraintValidatorContext context) {
//      System.out.print("Is valid function::: "+ obj);
//      return false;
//   }

   @Override
   public void initialize(MatrixInputValidationInterface constraintAnnotation) {
   }

   @Override
   public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
      int[][] matrix = (int[][]) object;
      int rows = matrix.length;
      int columns = matrix[0].length;

      for(int i = 0; i < rows; i++){
         for(int j = 0; j < columns; j++){
            if(!(matrix[i][j] == 0 || matrix[i][j] == 1)){
               return false;
            }
         }
      }
      return true;
   }


}
