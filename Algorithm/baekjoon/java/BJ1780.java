package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 14..
 */
public class BJ1780 {
    public static void count(int[] table, int value){
        if(value == -1){
            table[0] += 1;
        }
        else if(value == 0){
            table[1] += 1;
        }
        else{// value == 1
            table[2] += 1;
        }
    }
    public static boolean same(int[][] paper, int row, int col, int size){
        for(int r = row; r < row + size; ++r){
            for(int c = col; c < col + size; ++c){
                if(paper[row][col] != paper[r][c]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void countPaper(int[] table, int[][] paper, int row, int col, int size){
        int value = paper[row][col];

        if(size == 1){
            count(table, value);
            return;
        }

        if(same(paper, row, col, size)){
            int next = size / 3;
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    countPaper(table, paper, row + next * i, col + next * j, next);
                }
            }
        }else{
            count(table, value);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] paper = new int[size][size];

        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                paper[i][j] = scanner.nextInt();
            }
        }
        int[] table = new int[3];
        countPaper(table, paper, 0,0, size);

        for(int i = 0; i < table.length; ++i)
            System.out.println(table[i]);
    }
}


















