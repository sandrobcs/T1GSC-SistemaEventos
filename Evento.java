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

     public String getCodigoEvento() {
        return codigoEvento;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

     public void adicionarIngresso(Ingresso ingresso) {
        if (ingressos.size() < capacidade) {
            ingressos.add(ingresso);
        } else {
            System.out.println("Capacidade máxima do evento atingida!");
        }
    }

    public int getIngressosVendidos() {
        return ingressos.size();
    }

    public double getPercentualOcupacao() {
        return (getIngressosVendidos() * 100.0) / capacidade;
    }

    public void cancelar() { 
        this.cancelado = true; 
    }

    @Override
    public String toString() {
        return "Evento {" +
                "codigo='" + codigoEvento + '\'' +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", valor=" + valorIngresso +
                ", responsavel='" + responsavel + '\'' +
                ", capacidade=" + capacidade +
                ", vendidos=" + getIngressosVendidos() + "}";
    }

    

}
