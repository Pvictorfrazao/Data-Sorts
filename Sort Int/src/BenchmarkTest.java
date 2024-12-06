import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BenchmarkTest {
    public static void main(String[] args) throws IOException {
        
        String[] cenarios = {"Ordenado crescente", "Ordenado decrescente", "Aleatório"};
        int[] tamanhos = {10000, 100000, 500000};
        
      
        List<BenchmarkData> resultados = new ArrayList<>();

        for (int i = 0; i < 31; i++) {
         
            for (String cenario : cenarios) {
                for (int tamanho : tamanhos) {
                    
                    int[] vetor = generateTestData(tamanho, cenario);
                    long startTime = System.nanoTime();
                    long endTime = System.nanoTime();
                
                    // Teste para Bubble Sort
                    int[] vetorBubble = Arrays.copyOf(vetor, vetor.length);
                    startTime = System.nanoTime();
                    SortingAlgorithms.bubbleSort(vetorBubble);
                    endTime = System.nanoTime();
                    double bubbleTime = (endTime - startTime) / 1000.0;  
                    resultados.add(new BenchmarkData("BubbleSort", tamanho, cenario, bubbleTime));

                    //Teste para Quick Sort
                    int[] vetorQuick = Arrays.copyOf(vetor, vetor.length);
                    startTime = System.nanoTime();
                    SortingAlgorithms.quickSort(vetorQuick, 0, vetorQuick.length - 1);
                    endTime = System.nanoTime();
                    double quickTime = (endTime - startTime) / 1000.0;  
                    resultados.add(new BenchmarkData("QuickSort", tamanho, cenario, quickTime));

                    //Teste para Shell Sort
                    int[] vetorShell = Arrays.copyOf(vetor, vetor.length);
                    startTime = System.nanoTime();
                    SortingAlgorithms.shellSort(vetorShell);
                    endTime = System.nanoTime();
                    double shellTime = (endTime - startTime) / 1000.0;  
                    resultados.add(new BenchmarkData("ShellSort", tamanho, cenario, shellTime));

                    // Teste para Merge Sort
                    int[] vetorMerge = Arrays.copyOf(vetor, vetor.length);
                    startTime = System.nanoTime();
                    SortingAlgorithms.mergeSort(vetorMerge);
                    endTime = System.nanoTime();
                    double mergeTime = (endTime - startTime) / 1000.0;  
                    resultados.add(new BenchmarkData("MergeSort", tamanho, cenario, mergeTime));
                }
            }
        }

      
        BufferedWriter writer = new BufferedWriter(new FileWriter("resultados_benchmark_int_2_.csv"));
        writer.write("Algoritmo,Tamanho,Amostra,Cenario,TempoExecucao\n");
        for (BenchmarkData data : resultados) {
            writer.write(data.algoritmo + "," + data.tamanhoAmostra + "," + data.cenario + "," + data.tempoExecucao + "\n");
        }
        writer.close();

        System.out.println("Benchmark completo. Dados exportados para e CSV.");
    }

   
    public static int[] generateTestData(int tamanho, String cenario) {
        int[] arr = new int[tamanho];
        switch (cenario) {
            case "Ordenado crescente":
                for (int i = 0; i < tamanho; i++) arr[i] = i;
                break;
            case "Ordenado decrescente":
                for (int i = 0; i < tamanho; i++) arr[i] = tamanho - i;
                break;
            case "Aleatório":
                for (int i = 0; i < tamanho; i++) arr[i] = (int) (Math.random() * 1000);
                break;
        }
        return arr;
    }
}



