# Resilience4J 

Service of search zipCodes using a public API

Project to test the Resilience4J as a circuit breaker.

### TODO List:

- [x] Mudar parametros do model para receber o CEP e os parametros do viacep

- [x] Mapear a response no DTO

- [x] Ajustar a classe do UserCatalogResilience4J

- [x] Criar um controller para adicionar o cep e fazer validacao (GET)

- [x] Deixar a url do viacep dinamica

- [ ] Configurar retorno apropriado para o usuário quando cair no circuit breaker

- [ ] Verificar as configurações para cair após x vezes no circuit breaker(exemplo 3)

- [ ] Verificar a utilizar de retry, rateLimiter e bulkHead

Ver se ainda faz sentido:

- [ ] Na classe Item fazer o mapeamento dos campos que sao recebidos do viacep

- [ ] Usar o FeigClient para mapear o https://viacep.com.br/ws/01001000/json/
