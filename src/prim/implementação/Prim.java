
package prim.implementação;
  
class Prim 
{
    private static int V; 
  
    public Prim(int n)
    {
        V = n;
    }
    
    int minKey(int key[], Boolean mstSet[]) 
    {
        int min = Integer.MAX_VALUE, min_index = -1;
  
        for (int v = 0; v < V; v++) 
            if (!mstSet[v] && key[v] < min)
            { 
                min = key[v]; 
                min_index = v; 
            }
  
        return min_index; 
    }
    void printMST(int parent[], int graph[][]) 
    { 
        System.out.println("Arestas |Peso"); 
        int soma = 0;
        for (int i = 1; i < V; i++) // Inicia de 1 pois a pos 0 sempre será -1
        {
            soma += graph[i][parent[i]];
            System.out.println((char)(parent[i] + 65) + " - " + (char)(i + 65) + "\t|" + graph[i][parent[i]]);
        } 
        System.out.println("Custo:  |" + soma);
    } 
 
    void primMST(int graph[][]) 
    { 
        int parent[] = new int[V];
        int key[] = new int[V];  
        Boolean mstSet[] = new Boolean[V];
  
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1; 
  
        for (int count = 0; count < V - 1; count++) 
        { 
            int u = minKey(key, mstSet); //
  
            mstSet[u] = true; // Seta Linha Para Indicar que ja foi visitada
            for (int v = 0; v < V; v++) // Localiza o menor elemento da linha
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 
 
        printMST(parent, graph); 
    }
} 

