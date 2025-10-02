import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {
    private static int contadorEventos = 0; 

    private String codigoEvento;
    private String nome;
    private LocalDate data; 
    private double valorIngresso;
    private String responsavel;
    private int capacidade;
    private ArrayList<Ingresso> ingressos;
    private int qtdNormais;            
    private int qtdEspeciais;         
    private int emitidosNormais;      
    private int emitidosEspeciais;     

    public Evento(String nome, LocalDate data, double valor, String responsavel, int capacidade) {
        contadorEventos++;
        this.codigoEvento = String.format("%03d", contadorEventos); 
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valor;
        this.responsavel = responsavel;
        this.capacidade = capacidade;
        this.ingressos = new ArrayList<>();
        this.qtdEspeciais = (int)Math.ceil(capacidade * 0.15);  
        this.qtdNormais = capacidade - qtdEspeciais; 
        this.emitidosNormais = 0;                               
        this.emitidosEspeciais = 0;   
    }

     public String getCodigoEvento() {
        return codigoEvento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData() {
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
    
    public int getQtdNormais() {
        return qtdNormais; 
    }           

    public int getQtdEspeciais() {
        return qtdEspeciais; 
    }        

    public int getEmitidosNormais() { 
        return emitidosNormais; 
    }  

    public int getEmitidosEspeciais() { 
        return emitidosEspeciais; 
    } 


    public void adicionarIngresso(Ingresso ingresso) {
        if (ingresso.getTipo().equals("Normal")) {
            if (emitidosNormais < qtdNormais) {
                ingressos.add(ingresso);
                emitidosNormais++;
            } else {
                System.out.println("Limite de ingressos normais atingido!");
            }
        } else {
            if (emitidosEspeciais < qtdEspeciais) {
                ingressos.add(ingresso);
                emitidosEspeciais++;
            } else {
                System.out.println("Limite de ingressos especiais atingido!");
            }
        }
    }

    public double getPercentualNormais() {          
        return (emitidosNormais * 100.0) / qtdNormais;
    }
    
    public double getPercentualEspeciais() {        
        return (emitidosEspeciais * 100.0) / qtdEspeciais;
    }

    public int getIngressosVendidos() {
        return ingressos.size();
    }

    public double getPercentualOcupacao() {
        return (getIngressosVendidos() * 100.0) / capacidade;
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
                ", vendidos=" + getIngressosVendidos() + 
                ", normais=" + emitidosNormais +
                ", especiais=" + emitidosEspeciais + "}";
    }
}
