# Descrição Técnica do Projecto: Algoritmos dos Números

Este documento fornece uma visão técnica sobre a arquitetura de software, decisões de implementação e mapeamento de responsabilidades do projeto desenvolvido para a cadeira de **Algoritmo e Estrutura de Dados II**.

##  Decisões de Implementação

1. **Abordagem Orientada a Objetos:** Cada algoritmo obrigatório foi encapsulado numa classe própria com métodos estáticos (`public static`), garantindo uma separação clara de responsabilidades e facilitando os testes unitários manuais chamados a partir da classe `Main`.
2. **Isolamento de Bibliotecas:** Respeitando as restrições impostas, não foram utilizadas APIs externas como `java.math.BigInteger` para as operações criptográficas. Toda a lógica de exponenciação e inversão modular foi desenvolvida nativamente.
