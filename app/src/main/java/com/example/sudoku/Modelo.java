package com.example.sudoku;

import java.util.ArrayList;

public class Modelo {

    public static int[][] sudoku = new int[9][9];

    public int getVal(int fila, int col){
        int val = sudoku[fila][col];
        return val;
    }

    public int setVal(int fila, int col, int val){ // ACABAR
        return val;
    }

    public int comprovaFila(int fila){
        ArrayList<Integer> valorsFila = new ArrayList<Integer>();
        for (int i = 0; i < sudoku[fila].length; i++) {
            if (valorsFila.contains(sudoku[fila][i])){
                return 0;
            } else {
                valorsFila.add(sudoku[fila][i]);
            }
        }
        return 1;
    }

    public void comprobaCol(int col){

    }


}
