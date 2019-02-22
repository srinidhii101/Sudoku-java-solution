public class Main {

    /**
     * @param args - Command Line Arguments - To be set explicitly if used in IntelliJ or Eclipse
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        if (args.length != (Character.getNumericValue(args[0].toCharArray()[0]) + 3)) {
            throw new Exception("Incorrect Configuration. Check Line Numbers \n expected: " + Character.getNumericValue(args[0].toCharArray()[0]) + 2 + "\n actual = " + args.length);
        }


        // Storing size of matrix
        Integer size = Character.getNumericValue(args[0].toCharArray()[0]);
        SudokuSolution sudokuSolution = new SudokuSolution(size);


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
    }
}
