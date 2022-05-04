package exercicio4;


public class Lista { 
	No inicio;
	No fim;
	
	// método para inserir um elemento na lista.
	// a inserção deve manter a lista ordenada (ordem crescente)
	public void inserir(int dado) {
		No aux = inicio, num;
		
		num = new No(dado);
		
		if(inicio == null) {
			inicio = num;
			fim = num;
		} else if(inicio == fim) {// quando a fila possui 1 elemento
			if(num.dado < fim.dado) {
				fim.esq = num;
				num.dir = fim;
				inicio = num;
			} else { // caso seja maior 
				fim.dir = num;
				num.esq = fim;
				fim = aux;
			}
			
		} else { // quando a fila é maior que 1 ou 0 elementos
			while(aux != null) {
					if(num.dado <= aux.dir.dado && num.dado >= aux.dado ) {
						aux.dir.esq = num;
						num.esq = aux;
						num.dir = aux.dir;
						aux.dir = num;
						break;
					}
					aux = aux.dir;
				}
			}	
	
	}
	
	// método para imprimir os elementos da lista
	public void imprimir() {
		No aux = inicio;
		while(aux != null) {
			System.out.println(aux.dado);
			aux = aux.dir;
		}
	}
}
