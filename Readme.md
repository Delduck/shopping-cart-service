## 📖 Sobre o Projeto

Um serviço que gerencia um carrinho de compras simples, integrando dados de uma API externa para fornecer produtos disponíveis. Ele utiliza uma arquitetura eficiente que combina cache (Redis), banco de dados NoSQL (MongoDB), e contêineres (Docker), garantindo alta performance e escalabilidade.

### Principais Objetivos:
- Oferecer uma experiência fluida ao usuário.
- Minimizar chamadas desnecessárias à API externa através do cache.
- Facilitar o deploy em ambientes containerizados.

---

## 🛠 Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias:

### Java 17
- A versão mais moderna da linguagem Java, focada em desempenho e funcionalidades aprimoradas.

### Lombok
- Reduz a verbosidade do código, automatizando a criação de getters, setters e construtores.

### Redis
- Um banco de dados em memória, utilizado como cache para melhorar a performance nas interações com a API externa.

### MongoDB
- Banco de dados NoSQL, utilizado para armazenar as informações do carrinho de compras de maneira flexível.

### OpenFeign
- Uma biblioteca que simplifica a integração com APIs externas, tornando a comunicação mais intuitiva e reduzindo a verbosidade do código.

### Docker
- Ferramenta de containerização para criar ambientes consistentes e simplificados para deploy.

### API Externa
- Integração com uma API que fornece a lista de produtos disponíveis para o carrinho.
- Saiba mais sobre integração com APIs: [Guia para trabalhar com APIs](https://www.postman.com/api-documentation/)

---

## ✨ Funcionalidades

- **Listar Produtos**: Gerencie os produtos do carrinho de forma simples.
- **Criar, Alterar, Pagar e Deletar**: Gerencie o carrinho de compras.
- **Cache Inteligente**: Reduz o tempo de resposta com dados armazenados no Redis.
- **Persistência com MongoDB**: Armazene os dados do carrinho com segurança e flexibilidade.
- **Integração com API Externa**: Produtos são carregados diretamente de uma API confiável.
- **Suporte Docker**: Implante o projeto rapidamente em qualquer ambiente.

---
## 🚀 Como Rodar o Projeto

### Pré-requisitos

- **Docker** (ou instâncias de Redis e MongoDB configuradas localmente)
- **Java 17**
- **Maven** (ou use o wrapper mvnw)