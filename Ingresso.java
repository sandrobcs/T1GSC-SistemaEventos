public class Ingresso {
    private String codigoIngresso;     // Ex: 121-001 ou 121-075E
    private String tipo;               // "Normal" ou "Especial"
    private Participante participante; 

    public Ingresso(String codigoIngresso, String tipo, Participante participante) {
        this.codigoIngresso = codigoIngresso;
        this.tipo = tipo;
        this.participante = participante;
    }

    public String getCodigoIngresso() {
        return codigoIngresso;
    }

    public String getTipo() {
        return tipo;
    }

    public Participante getParticipante() {
        return participante;
    }

    @Override
    public String toString() {
        return "Ingresso {" +
                "codigo='" + codigoIngresso + '\'' +
                ", tipo='" + tipo + '\'' +
                ", participante=" + (participante != null ? participante.getNomeCompleto() : "N/A") +
                '}';
    }
}
