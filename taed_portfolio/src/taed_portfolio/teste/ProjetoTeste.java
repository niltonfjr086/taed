package taed_portfolio.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import taed_portfolio.model.dao.PessoaDAO;
import taed_portfolio.model.dao.ProjetoDAO;
import taed_portfolio.model.entidade.Projeto;

public class ProjetoTeste {
	
	private ProjetoDAO projetoDAO = new ProjetoDAO();
	private Projeto projeto = new Projeto();
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	@Test
	public void testFindAll() {
		
		if (projetoDAO.findAll().size() <= 0) {
			adicionarProjetos();
		}
		
		List<Projeto> projetos = projetoDAO.findAll();		
		System.out.println("Todos os projetos cadastrados: \n" + projetos);
		
	}
	
	private void adicionarProjetos() {
		
		List<Projeto> projetos = new ArrayList<>();
		
//		PRIMEIRO PROJETO
		projeto = new Projeto();
		projeto.setNome("Construção de Pousadas");		
		projeto.setDescricao("BEM LEGAL");
		projeto.setGerente(pessoaDAO.findById(1L));
		projeto.setRisco("Alto");
		projeto.setData_inicio(new Date());
		projeto.setStatus("Análise Realizada");
		projeto.setOrcamento(45000.00f);
		projeto.getPessoas().add(pessoaDAO.findById(1L));
		projeto.getPessoas().add(pessoaDAO.findById(5L));
		
		projetos.add(projeto);
		
		
//		SEGUNDO PROJETO		
		projeto = new Projeto();
		projeto.setNome("Controle de Estoques");		
		projeto.setDescricao("BEM LEGAL");
		projeto.setGerente(pessoaDAO.findById(4L));
		projeto.setRisco("Baixo");
		projeto.setData_inicio(ConsoleTeste.defineData("05/06/2010"));
		projeto.setData_previsao_fim(ConsoleTeste.defineData("10/12/2012"));
		projeto.setData_fim(ConsoleTeste.defineData("15/12/2012"));
		projeto.setStatus("Encerrado");
		projeto.setOrcamento(45000.00f);
		projeto.getPessoas().add(pessoaDAO.findById(4L));
		
		projetos.add(projeto);
		
//		TERCEIRO PROJETO		
		projeto = new Projeto();
		projeto.setNome("Investimentos Debêntures");		
		projeto.setDescricao("BEM LEGAL");
		projeto.setGerente(pessoaDAO.findById(5L));
		projeto.setRisco("Alto");
		projeto.setData_inicio(ConsoleTeste.defineData("05/06/2010"));
		projeto.setData_previsao_fim(ConsoleTeste.defineData("10/12/2012"));
		projeto.setData_fim(ConsoleTeste.defineData("15/12/2012"));
		projeto.setStatus("Cancelado");
		projeto.setOrcamento(45000.00f);		
		projeto.getPessoas().add(pessoaDAO.findById(5L));
		projeto.getPessoas().add(pessoaDAO.findById(4L));
		
		projetos.add(projeto);
		
//		QUARTO PROJETO		
		projeto = new Projeto();
		projeto.setNome("Energia Renovável");		
		projeto.setDescricao("Sustentabilidade");
		projeto.setGerente(pessoaDAO.findById(4L));
		projeto.setRisco("Médio");
		projeto.setData_inicio(ConsoleTeste.defineData("05/06/2010"));
		projeto.setData_previsao_fim(ConsoleTeste.defineData("10/12/2012"));
		projeto.setData_fim(ConsoleTeste.defineData("15/12/2012"));
		projeto.setStatus("Encerrado");
		projeto.setOrcamento(45000.00f);
		
		projetos.add(projeto);
		
		projeto = new Projeto();
		
		for(Projeto p : projetos) {
			projetoDAO.save(p);
		}
	}

}
