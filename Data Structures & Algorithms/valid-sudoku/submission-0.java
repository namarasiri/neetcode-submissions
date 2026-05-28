class Solution {
    public boolean isValidSudoku(char[][] board) {

        //remember numbers we already saw
        Set<String> seen = new HashSet<>();

        // go through every cell
        for (int row=0; row < 9; row++) {

            for (int col=0; col < 9; col++) {

                char num = board[row][col];

                if (num == '.') {
                    continue;
                }

                // create nique keys
                String rowKey = num + " in row " + row;
                String colKey = num + " in col " + col;
                String boxKey = num + " in box " + (row /3 ) + "-" + (col/3);

                if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                    return false;
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);

            }

        }
        
        // no duplicates
        return true;
    }
}
