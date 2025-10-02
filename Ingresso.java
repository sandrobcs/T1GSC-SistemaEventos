public class Ingresso {
    private String codigoIngresso;     
    private String tipo;               
    private Participante participante; 
    private boolean presente;

    public Ingresso(String codigoIngresso, String tipo, Participante participante) {
        this.codigoIngresso = codigoIngresso;
        this.tipo = tipo;
        this.participante = participante;
        this.presente = false;
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

    public boolean isPresente() { 
        return presente; 
    }

    public void registrarPresenca() {
         this.presente = true; 
    }

    @Override
    public String toString() {
        return "Ingresso {" +
                "codigo='" + codigoIngresso + '\'' +
                ", tipo='" + tipo + '\'' +
                ", participante=" + (participante != null ? participante.getNomeCompleto() : "N/A") +
                ", presente=" + presente +
                '}';
    }
}
