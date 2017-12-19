package taed_portfolio.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import taed_portfolio.model.dao.PessoaDAO;
import taed_portfolio.model.entidade.Pessoa;

public class ConsoleTeste {
	public static void main(String[] args) {
		
		System.out.println("OK");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		if(pessoaDAO.findAll().size() <= 0) {
			adicionarPessoas();
		}
		
	}
	
	
	private static Date defineData(String date) {
		
		Date retorno = new Date();
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		try {
			retorno = simpleDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	private static void adicionarPessoas() {
		
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		pessoa = new Pessoa();
		pessoa.setNome("Pedro Silva");
		pessoa.setCpf("345.345.345-32");
		pessoa.setFuncionario(true);
		pessoa.setDatanascimento(defineData("01/10/1990"));
		pessoaDAO.save(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setNome("João Matos");
		pessoa.setCpf("435.215.585-90");
		pessoa.setFuncionario(false);
		pessoa.setDatanascimento(defineData("10/12/1985"));
		pessoaDAO.save(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setNome("Maria Oliveira");
		pessoa.setCpf("211.432.954-21");
		pessoa.setFuncionario(false);
		pessoa.setDatanascimento(defineData("15/02/1982"));
		pessoaDAO.save(pessoa);
		
	}
}
