import java.util.ArrayList;
import java.util.List;

/**
 * SudokuSolution Class
 */
public class SudokuSolution implements SudokuSolutionInterface {
    List<Character> allowedSymbols = new ArrayList<>();
    Integer sizeOfMatrix;
    Character defaultCharacter = '0';

    Character[][] sudokuMatrix;

    SudokuSolution(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;
        sudokuMatrix = new Character[sizeOfMatrix][sizeOfMatrix];
    }

    /**
     * Computes Solution and stores it in sudokuMatrix
     *
     * @return
     */
    @Override
    public boolean computeSolution() {
        int memRow;
        int memCol;
        if (isSolved()) {
            return true;
        } else {
            CellItem cellItem = findEmptyCell();
            memRow = cellItem.row;
            memCol = cellItem.column;
            for (int i = 0; i < sizeOfMatrix; i++) {
                if (isValid(memRow, memCol, allowedSymbols.get(i))) {
                    sudokuMatrix[memRow][memCol] = allowedSymbols.get(i);
                    if (computeSolution()) {
                        return true;
                    } else {
                        sudokuMatrix[memRow][memCol] = defaultCharacter;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if the sudoku matrix is resolved
     *
     * @return
     */
    @Override
    public boolean isSolved() {
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if (sudokuMatrix[i][j] == defaultCharacter)
                    return false;
            }
        }
        return true;
    }

    /**
     * @param row    - Row Number
     * @param column - Column Number
     * @param target - Target Character
     * @return
     */
    @Override
    public boolean isValid(int row, int column, char target) {
        // Check for row conflict
        for (int i = 0; i < sizeOfMatrix; i++)
            if (sudokuMatrix[row][i] == target)
                return false;

        // Check for column conflict
        for (int i = 0; i < sizeOfMatrix; i++)
            if (sudokuMatrix[i][column] == target)
                return false;

        //check for box conflict
        Double boxSize = (Math.sqrt(Double.valueOf(sizeOfMatrix)));
        Integer boxSizeInt = boxSize.intValue();

        Integer boxStartRow = row - row % boxSizeInt;
        Integer boxStartColumn = column - column % boxSizeInt;

        for (int i = boxStartRow; i < boxStartRow + boxSizeInt; i++) {
            for (int j = boxStartColumn; j < boxStartColumn + boxSizeInt; j++) {
                if (sudokuMatrix[i][j] == target) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Used to find the next empty cell
     *
     * @return
     */
    @Override
    public CellItem findEmptyCell() {
        CellItem cellItem = new CellItem();
        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {
                if (sudokuMatrix[i][j] == defaultCharacter) {
                    cellItem.row = i;
                    cellItem.column = j;
                    return cellItem;
                }
            }
        }
        return cellItem;
    }
}
