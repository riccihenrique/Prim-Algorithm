package prim.implementação;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrimImplementação {

    public static void main(String[] args) throws FileNotFoundException, IOException {              
        System.out.println("Digite o caminho para o arquivo: ");
        Scanner scan = new Scanner(System.in);
        String caminho = scan.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        
        String linha;
        linha = br.readLine();
        linha = linha.replace(" ", "");
        int n = linha.length(), i = 0, j;
        int[][] grafo = new int[n][n];
        String[] split;
        while((linha = br.readLine()) != null)
        {
            split = linha.split(" ");
            for(j = 0; j < n; j++)
                grafo[i][j] = Integer.parseInt(split[j]);
            i++;
        }
        Prim p = new Prim(n);  
        p.primMST(grafo);
    }
}
