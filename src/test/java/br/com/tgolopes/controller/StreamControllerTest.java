package br.com.tgolopes.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;



import br.com.tgolopes.LeituraStreamApplicationTests;
import br.com.tgolopes.exception.NenhumCaracterUnicoEncontrado;
import br.com.tgolopes.service.StreamService;
import br.com.tgolopes.stream.Stream;
import br.com.tgolopes.stream.StreamImp;

/**
 * 
 * @author Thiago OLiveira Lopes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LeituraStreamApplicationTests.class)
@WebAppConfiguration
public class StreamControllerTest {

	private StreamService streamService = new StreamService();
	
    @Test
    public void testarHasNextTextoComEspaco() throws Exception {
		Stream stream = new StreamImp("mar vel");
		Assert.isTrue(stream.hasNext());
    }
    
    @Test
    public void testarHasNext() throws Exception {
		Stream stream = new StreamImp("MARVEL");
		Assert.isTrue(stream.hasNext());
    }
    
	@Test
	public void testaGetNex() throws Exception{
		Stream stream = new StreamImp("marvel");
		Assert.isTrue(stream.getNext() == 'm');
		Assert.isTrue(stream.getNext() == 'a');
		Assert.isTrue(stream.getNext() == 'r');
		Assert.isTrue(stream.getNext() == 'v');
		Assert.isTrue(stream.getNext() == 'e');
		Assert.isTrue(stream.getNext() == 'l');
		Assert.isTrue(!stream.hasNext());
	}
	
	@Test(expected = NenhumCaracterUnicoEncontrado.class)
    public void validarTodosOscaracteresSeRepetem() throws Exception{
		Stream stream = new StreamImp("aabbcc");
        streamService.pegarPrimeiroCaracter(stream);                		
    }
	
	@Test
    public void validarPrimeiroCaracterSemRepeticao() throws Exception{
        Stream stream = new StreamImp("aabbcdd");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='c');                		
    }
	
	@Test
    public void validarMaisDeUmCaracterSemRepeticao() throws Exception{
        Stream stream = new StreamImp("aabcdee");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='b');                		
    }
	
	@Test
    public void validarPrimeiroCaracterEspecialSemRepeticao() throws Exception{
        Stream stream = new StreamImp("marmar*");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='*');                		
    }
	
	@Test
    public void validarPrimeiroCaracterSemRepeticaoComEspacos() throws Exception{
        Stream stream = new StreamImp("m m a a r v v e l");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='r');                		
    }
	
	@Test
    public void validarPrimeiroCaracterSemRepeticaoNoComeco() throws Exception{
        Stream stream = new StreamImp("marvel");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='m');                		
    }
	
	@Test
    public void validarPrimeiroCaracterSemRepeticaoNoMeio() throws Exception{
        Stream stream = new StreamImp("aabcc");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='b');                		
    }
	
	@Test
    public void validarPrimeiroCaracterSemRepeticaoNoFim() throws Exception{
        Stream stream = new StreamImp("tartaro");
        Assert.isTrue(streamService.pegarPrimeiroCaracter(stream) =='o');                		
    }
	
	@Test(expected = NenhumCaracterUnicoEncontrado.class)
    public void validarCampoStreamVazio() throws Exception{
		Stream stream = new StreamImp("");
        streamService.pegarPrimeiroCaracter(stream);            		
    }
}
