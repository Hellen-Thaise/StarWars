# StarWars
Descrição do problema
O império continua sua luta incessante de dominar a galáxia, tentando ao máximo expandir seu território e eliminar os rebeldes.
Você, como um soldado da resistência, foi designado para desenvolver um sistema para compartilhar recursos entre os rebeldes.

Requisitos
Você irá desenvolver uma API, que irá armazenar informação sobre os rebeldes, bem como os recursos que eles possuem.
Adicionar rebeldes:
Um rebelde deve ter um nome, idade, gênero e localização(nome da base). Um rebelde também possui um inventário que deverá ser passado na requisição com os recursos em sua posse.
Um rebelde também possui um inventário que deverá ser passado na requisição com os recursos em sua posse.

Atualizar localização do rebelde:
Um rebelde deve possuir a capacidade de reportar sua última localização, armazenando a nova base.

Reportar o rebelde como um traidor:
Eventualmente algum rebelde irá trair a resistência e se aliar ao império. Quando isso acontecer, nós precisamos informar que o rebelde é um traidor.
Um rebelde é marcado como traidor quando, ao menos, três outros rebeldes reportarem a traição.
Uma vez marcado como traidor o mesmo se torna inativo e não consegue mais fazer compras na base.

Relatórios
A API deve oferecer os seguintes relatórios:
Porcentagem de traidores.
Porcentagem de rebeldes.

Base de compras:
	Os rebeldes poderão comprar itens.
Para isso será necessário ter uma classe que armazena os seguintes itens:
Item
Valor
Arma
100
Munição
30
Água
5
Comida
15



Notas

Não será necessário autenticação.
Nós ainda nos preocupamos com uma programação adequada (código limpo), você deve demonstrar que é um digno soldado da resistência através das suas habilidades.
Não esqueça de documentar a sua API e como usá-la.
Dentro do seu banco de dados faça os seguintes join com as tabelas dos rebeldes e da base de compras:
INNER-JOIN
LEFT-JOIN
RIGHT-JOIN
FULL-JOIN

