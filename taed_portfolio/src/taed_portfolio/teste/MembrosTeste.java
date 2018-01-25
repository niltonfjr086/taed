package taed_portfolio.teste;

import org.junit.Test;

import taed_portfolio.model.dao.MembrosDAO;
import taed_portfolio.model.dao.PessoaDAO;
import taed_portfolio.model.dao.ProjetoDAO;
import taed_portfolio.model.entidade.Membros;
import taed_portfolio.model.entidade.MembrosKey;

public class MembrosTeste {

	private MembrosDAO membrosDAO = new MembrosDAO();
	private Membros membros = new Membros();
	private MembrosKey membrosKey = new MembrosKey();
	
	private ProjetoDAO projetoDAO = new ProjetoDAO();
	private PessoaDAO pessoaDAO = new PessoaDAO();

	@Test
	public void testFindAll() {
		
		membrosKey = new MembrosKey();
		membrosKey.setProjeto(projetoDAO.findById(4L));
		membrosKey.setPessoa(pessoaDAO.findById(5L));
		
		membros = new Membros();
		membros = membrosDAO.findById(membrosKey);
		
		if(membros == null) {
			membros = new Membros();
			membros.setMembrosKey(membrosKey);
			membrosDAO.save(membros);
		}
		
		System.out.println(membros);

	}

}
