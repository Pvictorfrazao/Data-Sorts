import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringSort {

    public static void main(String[] args) throws IOException {
        
        // Definir os cenários e tamanhos de amostras
        String[] cenarios = {"Ordenado crescente", "Ordenado decrescente", "Aleatório"};
        int[] tamanhos = {10000, 100000, 500000};

        // Criar uma lista para armazenar os dados
        List<BenchmarkData> resultados = new ArrayList<>();

        // Realizar os testes para cada cenário e cada algoritmo
        for (String cenario : cenarios) {
            for (int tamanho : tamanhos) {
                // Gerar um vetor de dados para o teste
                String[] vetor = generateTestData(tamanho, cenario);
                long startTime, endTime;

                // Teste para Bubble Sort
                String[] vetorBubble = Arrays.copyOf(vetor, vetor.length);
                startTime = System.nanoTime();
                SortingAlgorithms.bubbleSort(vetorBubble);
                endTime = System.nanoTime();
                double bubbleTime = (endTime - startTime) / 1000.0;  // Tempo em microsegundos
                resultados.add(new BenchmarkData("BubbleSort", tamanho, cenario, bubbleTime));

                // Teste para Quick Sort
                String[] vetorQuick = Arrays.copyOf(vetor, vetor.length);
                startTime = System.nanoTime();
                SortingAlgorithms.quickSort(vetorQuick, 0, vetorQuick.length - 1);
                endTime = System.nanoTime();
                double quickTime = (endTime - startTime) / 1000.0;  // Tempo em microsegundos
                resultados.add(new BenchmarkData("QuickSort", tamanho, cenario, quickTime));

                // Teste para Shell Sort
                String[] vetorShell = Arrays.copyOf(vetor, vetor.length);
                startTime = System.nanoTime();
                SortingAlgorithms.shellSort(vetorShell);
                endTime = System.nanoTime();
                double shellTime = (endTime - startTime) / 1000.0;  // Tempo em microsegundos
                resultados.add(new BenchmarkData("ShellSort", tamanho, cenario, shellTime));

                // Teste para Merge Sort
                String[] vetorMerge = Arrays.copyOf(vetor, vetor.length);
                startTime = System.nanoTime();
                SortingAlgorithms.mergeSort(vetorMerge);
                endTime = System.nanoTime();
                double mergeTime = (endTime - startTime) / 1000.0;  // Tempo em microsegundos
                resultados.add(new BenchmarkData("MergeSort", tamanho, cenario, mergeTime));
            }
        }

        // Salvar os dados no formato CSV
        BufferedWriter writer = new BufferedWriter(new FileWriter("resultados_benchmark.csv"));
        writer.write("Algoritmo,Tamanho,Cenario,TempoExecucao\n");
        for (BenchmarkData data : resultados) {
            writer.write(data.algoritmo + "," + data.tamanhoAmostra + "," + data.cenario + "," + data.tempoExecucao + "\n");
        }
        writer.close();

        System.out.println("Benchmark completo. Dados exportados para CSV.");
    }

    // Função para gerar dados de teste com base no cenário
    public static String[] generateTestData(int tamanho, String cenario) {
        String[] arr = new String[tamanho];
        Random random = new Random();
        switch (cenario) {
            case "Ordenado crescente":
                for (int i = 0; i < tamanho; i++) {
                    arr[i] = generateString(i % 3 + 1); // Strings incrementais (simuladas)
                }
                Arrays.sort(arr); // Garante a ordem crescente
                break;
            case "Ordenado decrescente":
                for (int i = 0; i < tamanho; i++) {
                    arr[i] = generateString(i % 3 + 1); // Strings incrementais (simuladas)
                }
                Arrays.sort(arr, (a, b) -> b.compareTo(a)); // Ordem decrescente
                break;
            case "Aleatório":
                for (int i = 0; i < tamanho; i++) {
                    arr[i] = generateString(random.nextInt(3) + 1); // Strings aleatórias de 1 a 3 caracteres
                }
                break;
        }
        return arr;
    }

    // Função para gerar strings aleatórias com comprimento mínimo e máximo
    public static String generateString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}