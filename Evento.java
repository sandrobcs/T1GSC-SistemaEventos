import java.util.ArrayList;

public class Evento {
    private static int contadorEventos = 0; 

    private String codigoEvento;
    private String nome;
    private String data; 
    private double valorIngresso;
    private String responsavel;
    private int capacidade;
    private ArrayList<Ingresso> ingressos; 

    public Evento(String nome, String data, double valor, String responsavel, int capacidade) {
        contadorEventos++;
        this.codigoEvento = String.format("%03d", contadorEventos); 
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valor;
        this.responsavel = responsavel;
        this.capacidade = capacidade;
        this.ingressos = new ArrayList<>();
    }
}
