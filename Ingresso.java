public class Ingresso {
    private String codigoIngresso;     // Ex: 121-001 ou 121-075E
    private String tipo;               // "Normal" ou "Especial"
    private Participante participante; 

    public Ingresso(String codigoIngresso, String tipo, Participante participante) {
        this.codigoIngresso = codigoIngresso;
        this.tipo = tipo;
        this.participante = participante;
    }

}