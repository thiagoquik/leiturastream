package br.com.tgolopes.service;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tgolopes.exception.NenhumCaracterUnicoEncontrado;
import br.com.tgolopes.stream.Stream;

/**
 * Classe que representa os serviços para o processamento da stream que será consumido pela classe EnderecoController
 * 
 * @author Thiago Oliveira Lopes
 *
 */
@Service
@Validated
public class StreamService {
	private LinkedHashSet<Character> listaSemRepeticao = new LinkedHashSet<Character>();
	private List<Character> listaAuxiliar = new ArrayList<Character>();
	private Character charsProcessados;
	private Character primeiroCharSemRepeticao;
	
	/**
	 * Método responsável por efetuar um algoritmo onde passado uma String por parametro ele processa e retorna qual o primeiro Character que não se repetiu.
	 * @param texto
	 * @return
	 * @throws NenhumCaracterUnicoEncontrado
	 */
	public Character pegarPrimeiroCaracter(@NotNull Stream texto) throws NenhumCaracterUnicoEncontrado {
		while(texto.hasNext()){
			this.charsProcessados = texto.getNext();
			if(!this.listaSemRepeticao.contains(this.charsProcessados) && !this.listaAuxiliar.contains(this.charsProcessados)){
				this.listaSemRepeticao.add(this.charsProcessados);
			} else{
				this.listaSemRepeticao.remove(this.charsProcessados);
				this.listaAuxiliar.add(this.charsProcessados);
			}
		}
		
		if (this.listaSemRepeticao.isEmpty()) {
			throw new NenhumCaracterUnicoEncontrado();
		} else{
			for (Character character : this.listaSemRepeticao) {
				this.primeiroCharSemRepeticao = character;
				break;
			}
		}
		this.listaAuxiliar.clear();
		this.listaSemRepeticao.clear();
		return this.primeiroCharSemRepeticao;
	}
}