package br.com.tgolopes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe responsável por controlar as páginas da aplicação.
 * 
 * @author Thiago Oliveira Lopes
 *
 */

@Controller
@RequestMapping(value = "/")
public class ViewController {

	/**
	 * Método responsável por chamar via GET a página leituraStream.html, sem passar nada como parâmetro no browser.
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String abrirStream() {
        return "leituraStream";
    }
}
