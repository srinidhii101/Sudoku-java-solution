public class Main {

    public static void main(String[] args) {

        SudokuSolution sudokuSolution = new SudokuSolution();

        // Storing size of matrix
        sudokuSolution.sizeOfMatrix = Character.getNumericValue(args[0].toCharArray()[0]);

        // Storing the allowed Symbols list
        for (char a : args[1].toCharArray()) {
            sudokuSolution.allowedSymbols.add(a);
        }

        // Preparing the Sudoku Matrix
        int index = 2;
        for (int i = 0; i < sudokuSolution.sizeOfMatrix; i++) {
            for (int j = 0; j < sudokuSolution.sizeOfMatrix; j++) {
                if (args[index].toCharArray()[j] == '.')
                    sudokuSolution.sudokuMatrix[i][j] = '0';
                else
                    sudokuSolution.sudokuMatrix[i][j] = args[index].toCharArray()[j];
            }
            index++;
        }

        // Preparing the default Character
        sudokuSolution.defaultCharacter = '0';
        sudokuSolution.computeSolution();

        for (int i = 0; i < sudokuSolution.sizeOfMatrix; i++) {
            for (int j = 0; j < sudokuSolution.sizeOfMatrix; j++) {
                System.out.print(sudokuSolution.sudokuMatrix[i][j]);
            }
            System.out.println();
        }


        System.out.println("Size of the sudoku matrix = " + args[0]);
        System.out.println("List of allowed symbols = " + args[1]);

    }
}
