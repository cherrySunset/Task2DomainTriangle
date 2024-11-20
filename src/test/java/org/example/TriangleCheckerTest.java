package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TriangleCheckerTest {
    static List<Object[]> triangleData() throws IOException {
        return ExcelReader.readTriangleData("src/test/resources/TriangleDomainTable.xlsx");
    }
    @ParameterizedTest
    @MethodSource("triangleData")
    void testTriangleChecker(int a, int b, int c, String expected) {
        String result = Main.triangleChecker(a, b, c);
        assertEquals(expected, result);
    }
}
