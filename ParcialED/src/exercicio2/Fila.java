package exercicio2;

public class Fila { 

	No inicio, fim;
	
	// m?todo para inserir um elemento no final da fila (enfileirar)
	public void enfileirar(Motorista motorista) {
		No aux = new No(motorista);
		if(inicio == null) {
			inicio = aux;
		} else {
			aux.esq = fim;
			fim.dir = aux;
		}
		fim = aux;
	}
	
	// m?todo para desenfileirar um elemento da fila, ou seja, remover o primeiro elemento
	public void desenfileirar() {
		No aux = inicio;
		
		if(inicio == null && fim == null) { //quando tenta retirar sem caminh?es
			System.out.println("n?o existem caminh?es na fila!");
		} else if(inicio == fim) { // quando s? existe 1 caminh?o na fila
			inicio = null;
			fim = null;
		} else {
			aux.dir.esq = null;
			inicio = aux.dir;
			aux.dir = null;
		}
	}
	
	// m?todo para exibir os dados (nome e placa) dos motoristas
	public void mostrarDados() {
		No aux = inicio;
		while(aux != null) {
			System.out.println("Nome: " + aux.motorista.getNome() + ", Placa: " + aux.motorista.getPlaca() );
			aux = aux.dir ;
		}
	}
}
