package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.SudokuSolver;
import org.junit.Assert;
import org.junit.Test;

public class TestSudokuSolver {

    private final SudokuSolver solver;

    public TestSudokuSolver() {
        solver = new SudokuSolver();
    }

    @Test
    public void testOne() {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
        solver.solveSudoku(board);
        Assert.assertTrue(true);
    }
}
