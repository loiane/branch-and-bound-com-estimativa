package br.faesa.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que define um Nó de nossa árvore.
 * 
 * @author Ivan Nicoli
 * @author Loiane Groner
 * @author Luiz Gustavo Ribeiro Pagani
 *
 */
public class No {	
	/**
	 * Índice deste nó na árvore
	 */
	int i;
	/**
	 * Nó pai
	 */
	No pai;
	/**
	 * Nós filhos
	 */
	List<No> filhos = new ArrayList<No>();
	/**
	 * d = custo do caminho já percorrido – já conhecido;
	 */
	int custoPercorrido;
	/**
	 * e = custo total estimado de um caminho;
	 */
	double custoComEstimativa;
	/**
	 * r = custo da distância restante (do ponto atual até o objetivo) – é uma estimativa.
	 */
	double custoRestante;
	/**
	 * Nome deste Nó
	 */
	String nome;
	/**
	 * Retorna as informações deste nó.
	 */
	public String toString()
	{	
		String s = "";
		s += "i = " + this.i + "\n";
		s += "pai = " + this.pai + "\n";
		s += "filhos = " + this.filhos + "\n";
		s += "custo = " + this.custoPercorrido + "\n";
		s += "estCost = " + this.custoComEstimativa + "\n";
		return s;
	}
    /**
     * Exibe o nó e seus filhos no seguinte formato:
     * 
     * Pai(Custo: XX.X
	 * |    Filho(Custo: XX.X
	 * |    |      Filho do Filho (Custo: XX.X)
	 * |    )
	 * )
     * 
     */		
	public String exibeArvore() {
		String strFilhos = "";
		for (Iterator<No> iter = this.filhos.iterator(); iter.hasNext();) {
			No element = iter.next();
			strFilhos += element.exibeArvore() + "\n";
		}
		String strFilhosFinal = "";
		if (!strFilhos.equals("")) {
			String [] linhas = strFilhos.split("\n");
			for (int i = 0; i < linhas.length; i++) {
				strFilhosFinal += "\n|";
				for(int j = 0; j < this.nome.length(); j++) {
					strFilhosFinal += " ";
				}
				strFilhosFinal += linhas[i];
			}
		}
		
		String texto = this.nome + "(";
		texto += "Custo: " + this.custoComEstimativa; 
		texto += strFilhosFinal;
		
		if (this.filhos.size() == 0) { 
			texto += ")";
		}
		else {
			texto += "\n)";
		}
				
		return texto;
	}		
	/**
	 * Classe interna, que define como comparar um nó com o outro.
	 * No nosso caso, definimos que um nó tem mais prioridade 
	 * que o outro quando seu custo estimado for menor.
	 * 
	 * @author Ivan Nicoli
	 * @author Loiane Groner
	 * @author Luiz Gustavo Ribeiro Pagani
	 *
	 */
	static class NoComparator implements Comparator<No> {
		public int compare(No primeiroNo, No segundoNo) {
			/*
			 * d. Classificar toda a fila pela soma dos valores do comprimento do caminho
			 * (distâncias acumuladas) + a estimativa do custo restante (até o objetivo),
			 * colocando os caminhos de menor custo total no início ou na cabeça (front) da
			 * fila. Dessa forma, o caminho de menor custo TOTAL será avaliado primeiro;
			 */			
			if (primeiroNo.custoComEstimativa > segundoNo.custoComEstimativa) {
				return 1;
			}
			else {
				if (primeiroNo.custoComEstimativa < segundoNo.custoComEstimativa) { 
					return -1;
				}
				else {
					return 0;
				}
			}
		}		
	}	
}


