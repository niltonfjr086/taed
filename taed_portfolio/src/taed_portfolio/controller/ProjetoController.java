package taed_portfolio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import taed_portfolio.model.dao.PessoaDAO;
import taed_portfolio.model.dao.ProjetoDAO;
import taed_portfolio.model.entidade.Pessoa;
import taed_portfolio.model.entidade.Projeto;
import taed_portfolio.model.entidade.view.ProjetoModelView;

@Controller
public class ProjetoController {
	
	ProjetoDAO projetoDAO = new ProjetoDAO();
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	@RequestMapping(value = {"/listaProjetos", ""}, method = RequestMethod.GET)
	public String listarProjetos(HttpServletRequest request) {
		
		try {
			List<Projeto> projetos = projetoDAO.findAll();
			request.getSession().setAttribute("projetos", projetos);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "listaProjetos";
	}
	
	@RequestMapping(value = "/cadastroProjeto", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView projeto(@RequestParam(value = "idProjeto", required = false) String idProjeto, HttpServletRequest request) {
		
		List<Pessoa> funcionarios = pessoaDAO.findAllFuncionarios();
		request.getSession().setAttribute("funcionarios", funcionarios);
		
		ProjetoModelView projetoModelView = new ProjetoModelView();
		ModelAndView model = new ModelAndView("cadastroProjeto", "command", projetoModelView);
		
		if(idProjeto != null && Long.valueOf(idProjeto) > 0L) {
			projetoModelView.setProjeto(projetoDAO.findById(Long.valueOf(idProjeto)));
			
			model.addObject("membrosProjeto", projetoModelView.getProjeto().getPessoas());
			
			model.addObject("data_inicioFormatar", projetoModelView.getProjeto().getData_inicio());
			model.addObject("data_previsao_fimFormatar", projetoModelView.getProjeto().getData_previsao_fim());
			model.addObject("data_fimFormatar", projetoModelView.getProjeto().getData_fim());
		}
		
		return model;
	}
	
	@RequestMapping(value = "/addMembro", method = RequestMethod.GET)
	public ModelAndView adicionarMembro(@ModelAttribute("SpringWeb") ProjetoModelView projetoModelView) {
		
		Long id = Long.valueOf(projetoModelView.getIdNovoMembro());
		projetoModelView.getProjeto().getPessoas().add(pessoaDAO.findById(id));
				
		ModelAndView model = new ModelAndView("cadastroProjeto", "command", projetoModelView);
		
		model.addObject("membrosProjeto", projetoModelView.getProjeto().getPessoas());
		model.addObject("data_inicioFormatar", projetoModelView.getProjeto().getData_inicio());
		model.addObject("data_previsao_fimFormatar", projetoModelView.getProjeto().getData_previsao_fim());
		model.addObject("data_fimFormatar", projetoModelView.getProjeto().getData_fim());
		
		return model;
	}
	
	@RequestMapping(value = "/delMembro", method = RequestMethod.GET)
	public ModelAndView adicionarMembro(@ModelAttribute("SpringWeb") ProjetoModelView projetoModelView, 
			@RequestParam(value = "idFuncionario", required = false) String idFuncionario) {
		
		Long id = Long.valueOf(idFuncionario);
		
		List<Pessoa> membros = projetoModelView.getProjeto().getPessoas();
		for(Pessoa p : membros) {
			if(p.getId() == id) {
				membros.remove(p);
			}
		}
		
		ModelAndView model = new ModelAndView("cadastroProjeto", "command", projetoModelView);
		
		model.addObject("membrosProjeto", membros);
		model.addObject("data_inicioFormatar", projetoModelView.getProjeto().getData_inicio());
		model.addObject("data_previsao_fimFormatar", projetoModelView.getProjeto().getData_previsao_fim());
		model.addObject("data_fimFormatar", projetoModelView.getProjeto().getData_fim());
		
		return model;
	}

	@RequestMapping(value = "/addProjeto", method = {RequestMethod.GET, RequestMethod.POST})
	public RedirectView adicionarProjeto(@ModelAttribute("SpringWeb") ProjetoModelView projetoModelView, HttpServletRequest request) {
		
		try {
			
			if(projetoModelView.getProjeto() != null && projetoModelView.getProjeto().getId() != null) {
				projetoDAO.update(projetoModelView.getProjeto());
				
			} else {
				projetoDAO.save(projetoModelView.getProjeto());

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Projeto> projetos = projetoDAO.findAll();
		request.getSession().setAttribute("projetos", projetos);

		return new RedirectView("listaProjetos");
	}
	
	@RequestMapping(value = "/delProjeto", method = RequestMethod.GET)
	public RedirectView deletarProjeto(@RequestParam(value = "idProjeto", required = false) String idProjeto) {
		
		try {
			Long id = Long.valueOf(idProjeto);
			
			projetoDAO.delete(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new RedirectView("listaProjetos");
	}

}
