package taed_portfolio.model.dao;

import static taed_portfolio.model.FactoryDAO.sessionInstance;

import java.util.List;

import taed_portfolio.model.entidade.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Long>{
	
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAllFuncionarios() {
		return sessionInstance().createQuery(("FROM " + this.manipulada.getName()) + " WHERE funcionario=true ").getResultList();
	}
	

}
