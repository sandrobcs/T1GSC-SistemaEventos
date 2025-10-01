# Trabalho de Gerenciamento de Configuração de Software

## Fluxo de Trabalho

No projeto, foi adotado o fluxo de trabalho **Trunk-Based Development**, no qual todos os integrantes da equipe colaboram a partir de uma única branch principal, denominada `main`. Esse modelo prioriza a simplicidade e a integração contínua, reduzindo a complexidade no gerenciamento de branches e favorecendo a coordenação entre os membros do grupo.

A dinâmica consiste na criação de branches curtas e específicas para a implementação de funcionalidades ou correções, que, após concluídas, são rapidamente integradas de volta à branch principal.  
Essa prática evita o acúmulo de alterações extensas e de longa duração, o que diminui o risco de conflitos de código e garante que o repositório permaneça em estado estável. Dessa maneira, a equipe consegue trabalhar de forma paralela e organizada, assegurando que a evolução do sistema ocorra de modo contínuo, colaborativo e alinhado às boas práticas de gerenciamento de configurações de software.

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