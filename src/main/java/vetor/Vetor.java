package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		this.arrayInterno[indice++] = o;
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		int i = procurarIndice(o);
		if(i == -1){
			// retorna algo
		}else{
			this.arrayInterno[i] = null;
			
		}
	}


	private int procurarIndice(Object o){
		for(int i = 0; i < arrayInterno.length; i ++){
			if(this.arrayInterno[i].equals(o)){
				return i;
			}
		}return -1;
	}


	// Procura um elemento no vetor
	public Object procurar(Object o) {
		int i = procurarIndice(o);
		return this.arrayInterno[i];
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		if(this.indice == -1){
			return false;
		}return true;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		while (indice <= tamanho) {
			return false;
		}return true;
	}
}