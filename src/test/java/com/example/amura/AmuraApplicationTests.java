package com.example.amura;

import com.example.amura.model.MatrixInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmuraApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AmuraApplicationTests {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private HttpHeaders headers = new HttpHeaders();

//    @Test
//    public void contextLoads() {
//
//    }

    @Test
    public void testSubMatrix() throws Exception {

        int[][] matrix = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        MatrixInput matrixInput = new MatrixInput();
        matrixInput.setMatrix(matrix);

        HttpEntity<MatrixInput> entity = new HttpEntity<>(matrixInput, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/matrix/sub"),
                HttpMethod.POST, entity, String.class);

        String expected = "{\"x\":1,\"y\":0,\"width\":4,\"height\":2,\"subMatrix\":[[1,1,1,1],[1,1,1,1]]}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testSubMatrixInput() {

        int[][] matrix = {
                {0, 1, 2, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        MatrixInput matrixInput = new MatrixInput();
        matrixInput.setMatrix(matrix);

        HttpEntity<MatrixInput> entity = new HttpEntity<>(matrixInput, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/matrix/sub"),
                HttpMethod.POST, entity, String.class);

        assertTrue(Objects.requireNonNull(response.getBody()).contains("Matrix should contain 1 and 0 only"));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
