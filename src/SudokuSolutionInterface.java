public interface SudokuSolutionInterface {

    boolean computeSolution();

    boolean isSolved();

    boolean isValid(int row, int column, char target);

    CellItem findEmptyCell();
}
