import java.util.ArrayList;

public class SistemaEventos {
    private ArrayList<Evento> eventos;

    public SistemaEventos() {
        eventos = new ArrayList<>();
    }

    public Evento cadastrarEvento(String nome, String data, double valor, String responsavel, int capacidade) {
        Evento e = new Evento(nome, data, valor, responsavel, capacidade);
        eventos.add(e);
        return e;

    }

    public void listarEventos() {
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public ArrayList<Evento> buscarEventoPorNome(String nomeParcial) {
        ArrayList<Evento> resultado = new ArrayList<>();
        for (Evento e : eventos) {
            if (e.getNome().toLowerCase().contains(nomeParcial.toLowerCase())) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public void gerarRelatorioMensal(int mes, int ano) {
        System.out.println("Relatório de eventos " + mes + "/" + ano);
        for (Evento e : eventos) {
            if (!e.isCancelado()) {
                System.out.println(e);
            }
        }
    }
    
    public void cancelarEvento(String codigoEvento) {
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento)) {
                e.cancelar();
                System.out.println("Evento " + e.getNome() + " cancelado!");
            }
    
        }
    }
}
