package com.example.amura.controller;

import com.example.amura.model.MatrixInput;
import com.example.amura.model.MatrixOutput;
import com.example.amura.service.MatrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/matrix")
public class Matrix {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    final MatrixService matrixService;

    public Matrix(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    public ResponseEntity<MatrixOutput> subMatrix(@Valid @RequestBody MatrixInput matrixInput) throws Exception{
            MatrixOutput matrixOutput = matrixService.subMatrix(matrixInput.getMatrix());
            final ResponseEntity<MatrixOutput> matrixOutputResponseEntity = new ResponseEntity<>(matrixOutput, HttpStatus.ACCEPTED);
            return matrixOutputResponseEntity;
    }
}

