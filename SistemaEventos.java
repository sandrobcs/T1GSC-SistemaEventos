import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaEventos {
    private ArrayList<Evento> eventos;

    public SistemaEventos() {
        eventos = new ArrayList<>();
    }

    public Evento cadastrarEvento(String nome, LocalDate data, double valor, String responsavel, int capacidade) {
        if (data.isBefore(LocalDate.now().plusDays(1))) {
            System.out.println("Data inválida! O evento deve ser no futuro.");
            return null;
        }
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

    public Ingresso emitirIngresso(String codigoEvento, String tipo, Participante p) {
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento) && !e.isCancelado()) {
                String codigoIngresso = codigoEvento + "-" + String.format("%03d", e.getIngressos().size() + 1);
                if (tipo.equalsIgnoreCase("Especial")) codigoIngresso += "E";
                Ingresso i = new Ingresso(codigoIngresso, tipo, p);
                e.adicionarIngresso(i);
                return i;
            }
        }
        return null;
    }

     public boolean registrarPresenca(String codigoEvento, String codigoIngresso) {
        for (Evento e : eventos) {
            for (Ingresso i : e.getIngressos()) {
                if (i.getCodigoIngresso().equals(codigoIngresso)) {
                    System.out.println("Presença confirmada: " + i.getParticipante());
                    return true;
                }
            }
        }
        return false;
    }

    public void consultarDetalhesEvento(String codigoEvento) {
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento)) {
                System.out.println("Detalhes do evento " + e.getNome());
                System.out.println("Capacidade: " + e.getCapacidade());
                System.out.println("Ingressos vendidos: " + e.getIngressosVendidos());
                System.out.println("Ocupação: " + e.getPercentualOcupacao() + "%");
            }
        }
    }
}