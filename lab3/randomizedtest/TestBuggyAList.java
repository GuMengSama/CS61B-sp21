package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList
{
    // YOUR TESTS HERE
    @Test
    public void randomizeTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bL = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1)
        {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0)
            {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bL.addLast(randVal);
            } else if (operationNumber == 1)
            {
                // size
                int size = L.size();
                int bSize = bL.size();
                assertEquals(size, bSize);
            } else if (operationNumber == 2 && L.size() != 0)
            {
                assertEquals(L.getLast(), bL.getLast());
            } else if (operationNumber == 3 && L.size() != 0)
            {
                assertEquals(L.removeLast(), bL.removeLast());
            }
        }
    }
}
