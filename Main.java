public class Main {
    
    public static void main(String[] args) {
        SistemaEventos sistema = new SistemaEventos();

        // Criar participantes
        Participante p1 = new Participante("Antonio", "98765432101");
        Participante p2 = new Participante("Sandro", "12345678901");
        Participante p3 = new Participante("Lorenzo", "19283746500");
        Participante p4 = new Participante("Arthur", "56473829100");
        Participante p5 = new Participante("Guedes", "10293847560");

        // Cadastrar eventos
        Evento e1 = sistema.cadastrarEvento("Fórum da Liberdade", "21/07/25", 150.0, "PUCRS", 100);
        Evento e2 = sistema.cadastrarEvento("Festival Borges", "20/11/25", 50.0, "Gabriel Borges", 20);
        
    }
}
