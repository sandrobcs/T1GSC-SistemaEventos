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
}
