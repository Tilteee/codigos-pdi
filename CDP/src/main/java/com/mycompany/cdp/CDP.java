package com.mycompany.cdp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Alunos
 */
public class CDP {
    
    public static void printaMatriz(int [][] matriz, int linha, int coluna) {
        for(int i = 0; i < linha; i++) {
             for(int j = 0; j < coluna; j++){
                 System.out.print(" " + matriz[i][j] + " ");
             }
             System.out.println(" ");
        }
    }
    
    public static void salvaArquivo(int [][] matriz, int linha, int coluna, String filename) throws IOException {
        FileWriter arq = new FileWriter("C:\\Users\\Alunos\\Documents\\NetBeansProjects\\CDP\\src\\main\\java\\com\\" + filename + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        for(int i = 0; i < linha; i++) {
            for(int j = 0; j < coluna; j++){
                gravarArq.println(matriz[i][j]);
            }
        }
        arq.close();
    }
    
    public static int[][] somaMatriz(int[][] matriz1, int[][] matriz2, int linha, int coluna) {
        int [][] resultante =  new int[linha][coluna];
        for(int i = 0; i < 9; i++) {
             for(int j = 0; j < coluna; j++){
                 int soma = matriz1[i][j] + matriz2[i][j];
                 if(soma > 100) {
                     resultante[i][j] = 100;
                 } else {
                     resultante[i][j] = soma;
                 }
             }
        }
        return resultante;
    }
    
    public static int[][] subtraiMatriz(int[][] matriz1, int[][] matriz2, int linha, int coluna) {
        int [][] resultante =  new int[linha][coluna];
        for(int i = 0; i < linha; i++) {
             for(int j = 0; j < coluna; j++){
                 int soma = matriz1[i][j] - matriz2[i][j];
                 if(soma < 0) {
                     resultante[i][j] = 0;
                 } else {
                     resultante[i][j] = soma;
                 }
             }
        }
        return resultante;
    }
    
    public static void main(String[] args) {
        
        
        BufferedReader reader;
        BufferedReader reader2;
        
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\Alunos\\Documents\\NetBeansProjects\\CDP\\src\\main\\java\\com\\matriz1.txt"));
            String line = reader.readLine();
            reader2 = new BufferedReader(new FileReader("C:\\Users\\Alunos\\Documents\\NetBeansProjects\\CDP\\src\\main\\java\\com\\matriz2.txt"));
            String line2 = reader2.readLine();
            int[][] matriz1 = new int[9][10];
            int[][] matriz2 = new int[9][10];
            int linha = 9;
            int coluna = 10;
            for(int i = 0; i < linha; i++) {
                for(int j = 0; j < coluna; j++) {
                    int lineValue = Integer.parseInt(line);
                    int lineValue2 = Integer.parseInt(line2);
                    matriz1[i][j] = lineValue;
                    matriz2[i][j] = lineValue2;
                    line = reader.readLine();
                    line2 = reader2.readLine();
                    if(line == null) break;
                }
                    System.out.println(" ");
            }
                
            reader.close();
            reader2.close();
            
            int[][] novaMatrizSoma = somaMatriz(matriz1, matriz2, linha, coluna);
            int[][] novaMatrizSub = subtraiMatriz(matriz1, matriz2, linha, coluna);
            
            salvaArquivo(novaMatrizSub, linha, coluna, "subtracao");
            salvaArquivo(novaMatrizSoma, linha, coluna, "soma");
            
        } catch (IOException e) {
                e.printStackTrace();
        }
        
    }
}
