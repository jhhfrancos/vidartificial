/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.Random;

/**
 *
 * @author Jhh lectura 5 pg 66
 * que es emergencia cuando es emergencia y cuando lo es
 */
public class SandPile {
    
    public int[][] grid;
    public int limit = 4;
    
    public SandPile(){
        int[][] grilla = new int[120][120];
        for(int i = 0; i<grilla.length;i++){
            for(int j = 0; j<grilla.length;j++){
                grilla[i][j] = 0;
            }
        }
        grid = fillRandGrilla(grilla);
        
    }
    public int[][] sumPile(int[][] grid){
        int leng = grid.length;
        grid[leng/2][leng/2] = grid[leng/2][leng/2] + 1;
        return grid;
    }
    public int[][] pile(int[][] grid, int[] point){
        int x = point[0];
        int y = point[1];
        int sigX = (((x+1) % grid.length) + grid.length) % grid.length;
        int atrX = (((x-1) % grid.length) + grid.length) % grid.length;
        int sigY = (((y+1) % grid.length) + grid.length) % grid.length;
        int atrY = (((y-1) % grid.length) + grid.length) % grid.length;
        grid[x][y] = 0;
        grid[sigX][y] = grid[sigX][y] + 1;
        grid[atrX][y] = grid[atrX][y] +1;
        grid[x][sigY] = grid[x][sigY] + 1;
        grid[x][atrY] = grid[x][atrY] + 1;
        return grid;
    }
    public int[] limitExist(int[][] grid){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid.length; j++){
                if(grid[i][j] >= limit){
                    int[] xy = {i,j};
                    return xy;
                }
            }
        }
        return null;
    }
    public int[][] fillRandGrilla(int[][] grilla){
        int gridLeng = grilla.length;
        Random rand = new Random();
        int x = 0;
        int y = 0;
        while(grilla[x][y] != limit){
            x = rand.nextInt(gridLeng);
            y = rand.nextInt(gridLeng);
            grilla[x][y] = grilla[x][y] + 1;
        }
        return grilla;
    }
    
    public static void main(String[] args) {
        SandPile sandPile = new SandPile();
        //int[][] grid = sandPile.grid;
        //for(int i = 0; i<grid.length; i++){for(int j = 0; j<grid.length; j++){System.out.print(grid[i][j]);}System.out.println("");}
    }
}
