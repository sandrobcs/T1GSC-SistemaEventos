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
                System.out.println(e);
            }
        }
        return resultado;
    }

    public void gerarRelatorioMensal(int mes, int ano) {
        System.out.println("Relatório de eventos " + mes + "/" + ano);
        for (Evento e : eventos) {
            if (e.getData().getMonthValue() == mes && e.getData().getYear() == ano) {
                System.out.println(e);
                System.out.printf("Ingressos: Normais %d/%d (%.1f%%), Especiais %d/%d (%.1f%%), Ocupação total: %.1f%%\n",
                        e.getEmitidosNormais(), e.getQtdNormais(), e.getPercentualNormais(),
                        e.getEmitidosEspeciais(), e.getQtdEspeciais(), e.getPercentualEspeciais(),
                        e.getPercentualOcupacao());
            }
        }
    }
    
    public void cancelarEvento(String codigoEvento) { 
        for (int i = 0; i < eventos.size(); i++) { 
            if (eventos.get(i).getCodigoEvento().equals(codigoEvento)) { 
                System.out.println("Evento " + eventos.get(i).getNome() + " removido!"); 
                eventos.remove(i); 
                break; 
            }
        }
    }

    public Ingresso emitirIngresso(String codigoEvento, String tipo, Participante p) {
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento)) {
                int seq;
                String codigoIngresso = null;
                if (tipo.equalsIgnoreCase("Normal")) {
                    if (e.getEmitidosNormais() >= e.getQtdNormais()) {
                        System.out.println("Todos os ingressos normais já foram vendidos!");
                        return null;
                    }
                    seq = e.getEmitidosNormais() + 1;
                    codigoIngresso = codigoEvento + "-" + String.format("%03d", seq);
                } else {
                    if (e.getEmitidosEspeciais() >= e.getQtdEspeciais()) {
                        System.out.println("Todos os ingressos especiais já foram vendidos!");
                        return null;
                    }
                    seq = e.getEmitidosEspeciais() + 1 + e.getQtdNormais();
                    codigoIngresso = codigoEvento + "-" + String.format("%03d", seq) + "E";
                }
                Ingresso i = new Ingresso(codigoIngresso, tipo, p);
                e.adicionarIngresso(i);
                return i;
            }
        }
        return null;
    }

    public boolean registrarPresenca(String codigoEvento, String codigoIngresso) {
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento)) {
                for (Ingresso i : e.getIngressos()) {
                    if (i.getCodigoIngresso().equals(codigoIngresso)) {
                        if (!i.isPresente()) {
                            i.registrarPresenca();
                            System.out.println("Presença confirmada: " + i.getParticipante());
                            return true;
                        } else {
                            System.out.println("Presença já registrada!");
                            return false;
                        }
                    }
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
                System.out.println("Ingressos normais: " + e.getEmitidosNormais() + "/" + e.getQtdNormais() +
                        " (" + String.format("%.1f", e.getPercentualNormais()) + "%)");
                System.out.println("Ingressos especiais: " + e.getEmitidosEspeciais() + "/" + e.getQtdEspeciais() +
                        " (" + String.format("%.1f", e.getPercentualEspeciais()) + "%)");
                System.out.println("Total vendidos: " + e.getIngressosVendidos());
                System.out.println("Ocupação total: " + String.format("%.1f", e.getPercentualOcupacao()) + "%");

                System.out.println("Participantes presentes:");
                for (Ingresso i : e.getIngressos()) {
                    if (i.isPresente()) System.out.println(i.getParticipante().toString());
                }
                System.out.println("Participantes ausentes:");
                for (Ingresso i : e.getIngressos()) {
                    if (!i.isPresente()) System.out.println(i.getParticipante().toString());
                }
            }
        }
    }
    public void exportarPresentes(String codigoEvento) { 
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento)) {
                System.out.println("Lista de presença no evento " + e.getNome() + ":");
                for (Ingresso i : e.getIngressos()) {
                    if (i.isPresente()) {
                        System.out.println(i.getParticipante().toString());
                    }
                }
            }
        }
    }

    
    public void listarAusentes(String codigoEvento) { 
        for (Evento e : eventos) {
            if (e.getCodigoEvento().equals(codigoEvento)) {
                System.out.println("Lista de ausentes no evento " + e.getNome() + ":");
                for (Ingresso i : e.getIngressos()) {
                    if (!i.isPresente()) {
                        System.out.println(i.getParticipante().toString());
                    }
                }
            }
        }
    }
}