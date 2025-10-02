import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void Menu(){
        int opcao = 1;
        Scanner scanner = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();

        
        Participante p1 = new Participante("Antonio", "98765432101");
        Participante p2 = new Participante("Sandro", "12345678901");
        Participante p3 = new Participante("Lorenzo", "19283746500");
        Participante p4 = new Participante("Arthur", "56473829100");
        Participante p5 = new Participante("Guedes", "10293847560");

        
        Evento e1 = sistema.cadastrarEvento("Fórum da Liberdade", LocalDate.of(2025,12,21), 150.0, "PUCRS", 100);
        Evento e2 = sistema.cadastrarEvento("Festival Borges", LocalDate.of(2025, 11, 20), 50.0, "Gabriel Borges", 20);

        
        Ingresso i1 = sistema.emitirIngresso(e1.getCodigoEvento(), "Normal", p1);
        Ingresso i2 = sistema.emitirIngresso(e1.getCodigoEvento(), "Normal", p2);
        Ingresso i3 = sistema.emitirIngresso(e1.getCodigoEvento(), "Especial", p3);
        Ingresso i4 = sistema.emitirIngresso(e2.getCodigoEvento(), "Normal", p4);
        Ingresso i5 = sistema.emitirIngresso(e2.getCodigoEvento(), "Especial", p5);


        do {
        System.out.println("1 - Cadastrar Evento");
        System.out.println("2 - Listar Eventos");
        System.out.println("3 - Buscar Evento por Nome");
        System.out.println("4 - Gerar Relatório Mensal");
        System.out.println("5 - Cancelar Evento");
        System.out.println("6 - Emitir Ingresso");
        System.out.println("7 - Registrar Presença");
        System.out.println("8 - Consultar detalhe de Evento");
        System.out.println("9 - Exportar lista de presença");      
        System.out.println("10 - Listar ausentes");                   
        System.out.println("0 - Sair");

        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
            case 1:
                System.out.print("Nome do evento: ");
                String nome = scanner.nextLine();
                System.out.print("Data do evento (AAAA-MM-DD): ");
                String dataStr = scanner.nextLine();
                LocalDate data = LocalDate.parse(dataStr);
                System.out.print("Preço do ingresso: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Organizador: ");
                String organizador = scanner.nextLine();
                System.out.print("Capacidade máxima: ");
                int capacidade = scanner.nextInt();
                scanner.nextLine();

                sistema.cadastrarEvento(nome, data, preco, organizador, capacidade);
                System.out.println("Evento cadastrado com sucesso!");
                break;

            case 2:
                sistema.listarEventos();
                break;

            case 3:
                System.out.print("Digite o nome do evento para buscar: ");
                String nomeBusca = scanner.nextLine();
                sistema.buscarEventoPorNome(nomeBusca);
                break;

            case 4:
                System.out.print("Digite o mês (1-12): ");
                int mes = scanner.nextInt();
                System.out.print("Digite o ano (ex: 2025): ");
                int ano = scanner.nextInt();
                scanner.nextLine();
                sistema.gerarRelatorioMensal(mes, ano);
                break;

            case 5:
                System.out.print("Digite o código do evento para cancelar: ");
                String codigoCancelar = scanner.next();
                scanner.nextLine();
                sistema.cancelarEvento(codigoCancelar);
                break;

            case 6:
                System.out.print("Digite o código do evento: ");
                String codigoEvento = scanner.next();
                scanner.nextLine();
                System.out.print("Tipo de ingresso (Normal/Especial): ");
                String tipoIngresso = scanner.nextLine();
                System.out.print("Nome do participante: ");
                String nomeParticipante = scanner.nextLine();
                System.out.print("CPF do participante: ");
                String cpfParticipante = scanner.nextLine();
                Participante participante = new Participante(nomeParticipante, cpfParticipante);
                Ingresso ingresso = sistema.emitirIngresso(codigoEvento, tipoIngresso, participante);
                if (ingresso != null) {
                    System.out.println("Ingresso emitido com sucesso! Código: " + ingresso.getCodigoIngresso());
                } else {
                    System.out.println("Não foi possível emitir o ingresso. Verifique os dados.");
                }
                break;

            case 7:
                System.out.print("Digite o código do evento: ");
                String eventoPresenca = scanner.next();
                scanner.nextLine();

                System.out.print("Digite o código do ingresso: ");
                String codigoIngresso = scanner.next();
                scanner.nextLine();

                boolean registrado = sistema.registrarPresenca(eventoPresenca, codigoIngresso);
                if (registrado) {
                    System.out.println("Presença registrada com sucesso!");
                } else {
                    System.out.println("Ingresso não encontrado ou presença já registrada.");
                }
                break;

            case 8:
                System.out.print("Digite o código do evento: ");
                String codigoDetalhe = scanner.next();
                scanner.nextLine();
                sistema.consultarDetalhesEvento(codigoDetalhe);
                break;

            case 9:
                System.out.print("Digite o código do evento: ");
                String codPres = scanner.next();
                scanner.nextLine();
                sistema.exportarPresentes(codPres); 
                break;

            case 10:
                System.out.print("Digite o código do evento: ");
                String codAus = scanner.next();
                scanner.nextLine();
                sistema.listarAusentes(codAus); 
                break;

            case 0:
                System.out.println("Saindo...");
                break;
                
            default:
                System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Menu();

    }
}
