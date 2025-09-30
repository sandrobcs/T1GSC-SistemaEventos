import java.util.Scanner;


public class Main {
    

    public static void Menu(){
        int opcao = 1;
        Scanner scanner = new Scanner(System.in);

    while(opcao != 0)
        System.out.println("1 - Cadastrar Evento");
        System.out.println("2 - Listar Eventos");
        System.out.println("3 - Buscar Evento por Nome");
        System.out.println("4 - Gerar Relatório Mensal");
        System.out.println("5 - Cancelar Evento");
        System.out.println("6 - Emitir Ingresso");
        System.out.println("7 - Registrar Presença");
        System.out.println("8 - Consultar detalhe de Evento");
        System.out.println("0 - Sair");

        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch(opcao){
            case 1:
                // Código para cadastrar evento
                break;
            case 2:
                // Código para listar eventos
                break;
            case 3:
                // Código para buscar evento por nome
                break;
            case 4:
                // Código para gerar relatório mensal
                break;
            case 5:
                // Código para cancelar evento
                break;
            case 6:
                // Código para emitir ingresso
                break;
            case 7:
                // Código para registrar presença
                break;
            case 8:
                // Código para consultar detalhe de evento
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }







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

        // Criar ingressos
        Ingresso i1 = sistema.emitirIngresso(e1.getCodigoEvento(), "Normal", p1);
        Ingresso i2 = sistema.emitirIngresso(e1.getCodigoEvento(), "Normal", p2);
        Ingresso i3 = sistema.emitirIngresso(e1.getCodigoEvento(), "Especial", p3);
        Ingresso i4 = sistema.emitirIngresso(e2.getCodigoEvento(), "Normal", p4);
        Ingresso i5 = sistema.emitirIngresso(e2.getCodigoEvento(), "Especial", p5);



    }


    
}
