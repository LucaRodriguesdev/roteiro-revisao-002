package produto;


public class RepositorioProdutoArray<T extends Produto> implements  RepositorioProduto<T>{
    
	/**
	 * A estrutura (array) onde os produtos sao mantidos.
	 */
	private T[] produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
     private int cont = -1;
 
     public RepositorioProdutoArray(int size) {
    	this.produtos = (T[]) new Object[size];
    }
	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	
	private int procurarIndice(int codigo) {
		for(int i = 0; i < produtos.length; i ++){
			if(produtos[i].comparaCodigo(codigo)){
				return i;
			}
		}return -1;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean existe(int codigo) {
		if(procurarIndice(codigo) == -1 ){
			return false;
		}
		return true;
	}


	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	@Override
    public void inserir(T produto) {
        this.produtos[++cont] = produto;
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	    
     @Override
     public void atualizar(T produto) {
         int i = procurarIndice(produto.getCodigo());
             if(i != -1){
                 this.produtos[i] = produto;
             }
             else{
                 throw new RuntimeException("produto não encontrado");
             }
         }

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int i = procurarIndice(codigo);
		if(i != -1){
		this.produtos[cont] = this.produtos[i];
		this.produtos[i] = null;
		}else{
			throw new RuntimeException("produto não encontrado");
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public T procurar(int codigo) {
	int i = procurarIndice(codigo);
	T product = null;
		if(i != -1){
			product = this.produtos[i];
		}else{
			throw new RuntimeException("produto não encontrado");
		}
		return product;
	}
}



