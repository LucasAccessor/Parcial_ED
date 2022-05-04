package exercicio1;

public class Lista {
	No inicio, fim;
	
	// insere um nó no final da lista. Esse método será chamado pelo método inserir
	private void inserirFim(No aux) {
		if(inicio == null) {
			inicio = aux;
		} else {
			fim.prox = aux;
		}
		fim = aux;
	}
	
	//esse método deverá ser implementado de acordo com o enunciado do exercício
	private void inserirPrioridade(No aux) {
		No proxAmar = inicio;
		boolean adicionado = false;
		
		if(inicio == null) { // verificação inicial se existem elementos na fila
			inicio = aux;
			fim = aux;
			adicionado = true;
		}
		
		while(!adicionado) {
			if(proxAmar.cor.equalsIgnoreCase("verde")){ //quando a fila não possui nenhum amarelo
				aux.prox = inicio;
				inicio = aux;
				adicionado = true;
			} else if ((proxAmar.prox.cor.equalsIgnoreCase("verde")) && (proxAmar.cor.equalsIgnoreCase("amarelo"))) { // quando a fila possui amarelo
				aux.prox = proxAmar.prox;
				proxAmar.prox = aux;
				adicionado = true;
			} else {
				proxAmar = proxAmar.prox;
				//System.out.println(proxAmar.numero);
			}
		} 
	}
	
	// método inserir. Esse método será chamado a partir da classe Main
	public void inserir(int numero, String cor) {
		No aux = new No(numero, cor);
		if(cor.equalsIgnoreCase("verde")) {
			inserirFim(aux);
		} else {
			inserirPrioridade(aux);
		}
	}
	
	// método utilizado para imprimir os dados da lista
	public void imprimir() {
		No aux = inicio;
		while(aux != null) {
			System.out.println(aux.numero);
			aux = aux.prox;
		}
	}
}
