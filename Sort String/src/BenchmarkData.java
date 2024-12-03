public class BenchmarkData {
    String algoritmo;
    int tamanhoAmostra;
    String cenario;
    double tempoExecucao;

    public BenchmarkData(String algoritmo, int tamanhoAmostra, String cenario, double tempoExecucao) {
        this.algoritmo = algoritmo;
        this.tamanhoAmostra = tamanhoAmostra;
        this.cenario = cenario;
        this.tempoExecucao = tempoExecucao;
    }
}
