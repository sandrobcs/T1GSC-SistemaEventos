# Trabalho de Gerenciamento de Configuração de Software

## Fluxo de Trabalho

No projeto, foi adotado o fluxo de trabalho **GitHub Flow**, no qual todos os integrantes da equipe colaboram a partir de uma única branch principal, denominada main. Esse modelo valoriza a simplicidade e a colaboração contínua, facilitando o gerenciamento das contribuições e garantindo que a base do código se mantenha estável e funcional.

A dinâmica consiste na criação de branches temporárias e específicas para o desenvolvimento de funcionalidades ou correções, que, após concluídas, são integradas de volta à branch principal por meio de Pull Requests.
Essa prática permite revisões colaborativas, evita o acúmulo de alterações extensas e reduz os riscos de conflitos, mantendo o projeto em evolução constante. Dessa maneira, a equipe conseguiu trabalhar em paralelo de forma organizada, assegurando integração contínua, participação conjunta e alinhamento às boas práticas de versionamento.


---

## Grupo

| Participante                      | Usuário Github     |
|:----------------------------------|:------------------|
| Antonio Dal Bem                   | AntonioFDB         |
| Arthur Dias da Silva              | arthurdiasilva      |
| Arthur de Oliveira Ferreira       | ArthurF28          |
| Bruno Carboni                     | brun0c4r           |
| Gabriel Michaelsen Borges         | borgesk1ngg        |
| Lorenzo Bueno                     | LorenzoBueno       |
| Lucas Guedes Moura                | lucasguedes19      |
| Matheus Giordani                  | matheusgior        |
| Sandro Costa e Silva              | sandrobcs          |
| Vicente Goldani                   | Goldani7           |

---

# Sistema de Gerenciamento de Eventos

Este projeto é um sistema em Java para **gerenciamento de eventos, ingressos e participantes**, atendendo a requisitos típicos de organização de eventos presenciais ou virtuais.

## Funcionalidades Principais

- **Cadastro de eventos** com nome, data, valor do ingresso, responsável e capacidade máxima.
    - Validação de data (somente eventos futuros).
    - Geração automática de código único para cada evento.
    - Reserva automática de 15% dos ingressos para casos especiais (ex: cadeirantes, PCD).
    - Numeração de ingressos diferenciada para normais e especiais.
- **Emissão de ingressos nominais** (associados a um participante com nome e CPF).
    - Controle de lotação máxima e separação de tipos (normal/especial).
    - Cada ingresso possui código único e não pode ser alterado após emissão.
- **Registro de presença** dos participantes no dia do evento.
    - Consulta posterior de quem compareceu e quem não compareceu.
- **Listagem e busca de eventos** por nome.
- **Consulta detalhada de eventos**, incluindo:
    - Número total de ingressos disponíveis e vendidos (por tipo).
    - Percentual de ocupação total e por tipo de ingresso.
    - Lista de participantes presentes e ausentes.
- **Relatório mensal** com estatísticas de todos os eventos de um determinado mês/ano.
- **Funcionalidades extras**:
    - Exportação da lista de presentes.
    - Listagem dos ausentes em determinado evento.

---

## Como Utilizar

1. **Compile todos os arquivos Java**:
    ```sh
    javac *.java
    ```
2. **Execute o sistema**:
    ```sh
    java Main
    ```
3. **Utilize o menu do sistema** para cadastrar eventos, emitir ingressos, registrar presença, consultar relatórios e demais funcionalidades.

---

## Observações

- Não há necessidade de login/senha.
- O sistema foi desenvolvido para rodar em modo console, mas pode ser adaptado para interface gráfica futuramente.
- Todas as regras de negócio seguem a especificação do trabalho acadêmico.

---

**Desenvolvido para fins acadêmicos.**