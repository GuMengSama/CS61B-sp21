package tester;

import static org.junit.Assert.*;

import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;

public class TestArrayDequeEC {
    @Test
    public void randomizedTestOfArrayDeque() {
        StudentArrayDeque<Integer> L = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> bL = new ArrayDequeSolution<>();
        StringBuilder operations = new StringBuilder();

        int N = 100;

        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                int numToAdd = StdRandom.uniform(0, 100);
                L.addLast(numToAdd);
                bL.addLast(numToAdd);
                operations.append("addLast(").append(numToAdd).append(")\n");
            } else if (operationNumber == 1) {
                int numToAdd = StdRandom.uniform(0, 100);
                L.addFirst(numToAdd);
                bL.addFirst(numToAdd);
                operations.append("addFirst(").append(numToAdd).append(")\n");
            } else if (operationNumber == 2) {
                if (L.isEmpty()) {
                    continue;
                }
                Integer numOfL = L.removeFirst();
                Integer numOfbL = bL.removeFirst();
                operations.append("removeFirst()\n");
                assertEquals(operations.toString(), numOfL, numOfbL);
            } else if (operationNumber == 3) {
                if (L.isEmpty()) {
                    continue;
                }
                Integer numOfL = L.removeLast();
                Integer numOfbL = bL.removeLast();
                operations.append("removeLast()\n");
                assertEquals(operations.toString(), numOfL, numOfbL);
            }
        }
    }
}
