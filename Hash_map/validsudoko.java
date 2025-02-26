//1st approach and 2nd approch scrol down

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check Rows
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char item = board[i][j];
                if (item != '.' && !set.add(item)) {
                    return false;
                }
            }
        }

        // check Columns
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char item = board[j][i];
                if (item != '.' && !set.add(item)) {
                    return false;
                }
            }
        }

        // check 3x3 Sub-grids
        int[][] starts = {{0, 0}, {0, 3}, {0, 6},
                          {3, 0}, {3, 3}, {3, 6},
                          {6, 0}, {6, 3}, {6, 6}};
        
        for (int[] start : starts) {
            Set<Character> set = new HashSet<>();
            for (int row = start[0]; row < start[0] + 3; row++) {
                for (int col = start[1]; col < start[1] + 3; col++) {
                    char item = board[row][col];
                    if (item != '.' && !set.add(item)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}



//2nd apporoach
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] r = new HashSet[9];
        HashSet<Character>[] c = new HashSet[9];
        HashSet<Character>[] g = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            r[i] = new HashSet<>();
            c[i] = new HashSet<>();
            g[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];
                if (n == '.') continue;
                int gi = (i / 3) * 3 + (j / 3);
                
                if (r[i].contains(n) || c[j].contains(n) || g[gi].contains(n)) {
                    return false;
                }

                r[i].add(n);
                c[j].add(n);
                g[gi].add(n);
            }
        }
        return true;
    }
}
