package taed_portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import taed_portfolio.model.dao.PessoaDAO;
import taed_portfolio.model.dao.ProjetoDAO;
import taed_portfolio.model.entidade.Pessoa;
import taed_portfolio.model.entidade.Projeto;

@Controller
public class ProjetoController {
	
	ProjetoDAO projetoDAO = new ProjetoDAO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	@RequestMapping(value = "/listaProjetos", method = RequestMethod.GET)
	public String listarClientes(HttpServletRequest request) {

		List<Projeto> projetos = projetoDAO.findAll();
		
		request.getSession().setAttribute("projetos", projetos);
		
		return "listaProjetos";
	}
	
	@RequestMapping(value = "/cadastroProjeto", method = RequestMethod.GET)
	public ModelAndView cliente(HttpServletRequest request) {
		
		List<Pessoa> pessoas = pessoaDAO.findAll();
		List<Pessoa> funcionarios = new ArrayList<>();
		for(Pessoa p : pessoas) {
			if(p.getFuncionario()) {
				funcionarios.add(p);
			}
		}
		request.getSession().setAttribute("funcionarios", funcionarios);
		
		return new ModelAndView("cadastroProjeto", "command", new Projeto());
	}

	@RequestMapping(value = "/addProjeto", method = RequestMethod.POST)
	public String adicionarCliente(@ModelAttribute("SpringWeb") Projeto projeto) {
		
		try {
			projetoDAO.save(projeto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "listaProjetos";
	}

}
