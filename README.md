# Chat Multithread com Socket Java

#### Trabalho referente a disciplina de Computação Paralela e Sistemas Distribuídos.

Primeiramente inicia-se o servidor socket com o endereço de IP, estou usando o local porque vou rodar todos no mesmo computador, mas se for em computadores diferentes poderá colocar o IP da rede. Escolha uma porta que não esteja associada a um serviço específico e certifique de que o seu computador não tenha nenhum programa que possa bloquea-la.

Certo disto, adicione o mesmo IP e porta do servidor na janela do cliente, conforme a imagem abaixo:

<p align="center">
  <img src="chat1.png">
</p>

Depois de confirmar a conexão, a conversa poderá ser iniciada. 
Toda mensagem enviada, vai primeiro para o servidor, que depois atualiza para os demais clientes que estão conectados.


<p align="center">
  <img src="chat2.png">
</p>


E se mais pessoas quiserem entrar na conversa, basta iniciar mais um instância cliente e informar a pessoa o IP e a porta do servidor, assim a pessoa passa a participar da conversa como no exemplo abaixo:


<p align="center">
  <img src="chat3.png">
</p>



#### Material de auxílio
[Programação com sockets](https://pt.wikibooks.org/wiki/Redes_de_computadores/Programa%C3%A7%C3%A3o_com_sockets)

[Lista de portas](https://pt.wikipedia.org/wiki/Lista_padr%C3%A3o_de_servi%C3%A7os_e_portas_associadas)
