# Algoritmos dos Números: fundamentos matemáticos, implementação em Java e aplicações em criptografia assimétrica.
* **Curso:** Licenciatura em Engenharia Informática
* **Docente Responsável:** Joaquim João Nsaku Ventura
* **Ano Lectivo:** 2025/2026

Este projeto é um trabalho prático da cadeira de Algoritmo e Estrutura de Dados II, cujo objetivo é ligar a teoria à prática, mostrando como os conceitos abstratos da Matemática Discreta e da Aritmética Modular são aplicados no mundo real da Segurança Informática, traduzindo os conceitos abstratos da Teoria Elementar dos Números e da Aritmética Modular numa aplicação de consola nativa em Java (JDK 21).

O projeto está estruturado em pacotes organizados e que abrange desde a modelação de algoritmos de otimização numérica — como o Algoritmo de Euclides, testes de primalidade, fatorização de inteiros e exponenciação modular rápida — até implementação funcional do Sistema Criptográfico RSA, capaz de demonstrar com clareza os processos de geração de chaves públicas/privadas, cifragem e decifragem de dados.

### Integrantes do grupo

1. Ezequel Dinis Pinto
2. Lucas Mbunga António Pascoal
3. Ana Benedita Diwampovesa
4. Eduardo Bunga Malunguila Daniel
5. Lewusi João Mbela

### Estrutura do projeto
O projeto foi rigidamente organizado seguindo o padrão de arquitetura de pacotes como mostra a seguir:
```text
algoritmos-dos-numeros-java/
│
├── README.md                            Instruções de compilação, execução e mapeamento
├── src/
│   ├── Main.java                        Ponto de entrada do programa e menu de consola interativo
│   ├── mdc/
│   │   └── MaximoDivisorComum.java      Cálculo do MDC por método simples/directo
│   ├── euclides/
│   │   └── AlgoritmoEuclides.java       Cálculo eficiente do MDC pelo Algoritmo de Euclides
│   ├── primos/
│   │   ├── TestePrimalidade.java        Verificação optimizada de números primos
│   │   └── FactorizacaoInteiros.java    Decomposição de inteiros em factores primos
│   ├── modular/
│   │   ├── Congruencia.java             Operações estruturadas de aritmética modular
│   │   ├── Fermat.java                  Aplicação computacional do Pequeno Teorema de Fermat
│   │   └── TeoremaChinesResto.java      Resolução de sistemas simples de congruências
│   ├── euler/
│   │   └── TotienteEuler.java           Cálculo analítico da função φ(n)
│   └── rsa/
│       └── RSA.java                     Geração didáctica de chaves, cifragem e decifragem
│
├── exemplos/
│   └── entradas-saidas.txt              Casos de teste práticos executados pelo grupo
└── docs/
    └── descricao-do-projecto.md         Notas de desenvolvimento técnico

```
### Resumo dos Algoritmos Implementados

* **MaximoDivisorComum**: Algoritmo por subtrações ou iterações consecutivas para demonstrar a abordagem básica de divisibilidade.
* **AlgoritmoEuclides**: Algoritmo otimizado baseado no princípio recursivo de divisões sucessivas.
* **TestePrimalidade**: Algoritmo estruturado que valida a primalidade de inteiros
* **FactorizacaoInteiros**: Algoritmo que descontrói o número composto nos seus fatores primos constituintes.
* **Congruencia**: Implementação do método de Exponenciação Modular Rápida para evitar o estouro de memória (overflow).
* **Fermat**: Verificação de propriedades numéricas com suporte no Pequeno Teorema de Fermat.
* **TeoremaChinesResto**: Resolução algorítmica para sistemas de congruências lineares coprimas.
* **TotienteEuler**: Computação do valor de $\phi(n)$ focado na coprimalidade.
* **RSA**: Módulo criptográfico didático que integra todas as ferramentas acima para demonstrar a cifragem e decifragem de mensagens numéricas por chave pública/privada.

### Como compilar e executar o projeto

### Requisitos mínimos
Antes de começar, é preciso garantir que tens as seguintes ferramentas instaladas e configuradas na tua máquina:

* **Git**: Necessário para clonar o repositório e gerir as versões do código.

* **Java Development Kit (JDK)**: Versão 21 ou superior (mínimo obrigatório para garantir a compatibilidade com os recursos de compilação nativos).
* Uma IDE como IntelliJ IDEA, Netbeans ou Eclipse.

## Como Clonar o Projeto
Para descarregar uma cópia exata do projeto do GitHub para a tua máquina local, abre o terminal na pasta onde desejas guardar o trabalho e executa o seguinte comando:
````bash
git clone https://github.com/Lucasmbunga/algoritmos-dos-numeros-java.git
````

Depois de fazer o clone do repositório, basta localizar o projeto na pasta onde foi armazenado, abrir com uma IDE como IntelliJ IDEA, Netbeans, entre outros e executar a classe Main onde constam os testes de todos os algoritmos implementados.

### Relatório Técnico e Documentação
O relatório de fundamentação teórica contendo a descrição matemática dos conceitos e as referências bibliográficas encontra-se indexado no arquivo  entregue ao docente a partir da plataforma Classroom.