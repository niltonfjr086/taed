package taed_portfolio.model.entidade.view;

import taed_portfolio.model.dao.PessoaDAO;
import taed_portfolio.model.entidade.BaseEntity;
import taed_portfolio.model.entidade.Projeto;

public class ProjetoModelView extends BaseEntity {

	private static final long serialVersionUID = 6973897282915352633L;

	private Projeto projeto = new Projeto();
	private Long idGerenteProjeto;
	private Long idNovoMembro;

	public ProjetoModelView() {
		super();
	}

	public ProjetoModelView(Projeto projeto, Long idGerenteProjeto) {
		super();
		this.projeto = projeto;
		this.idGerenteProjeto = idGerenteProjeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Long getIdGerenteProjeto() {

		if (this.projeto.getGerente() != null) {
			if (this.projeto.getGerente().getId() != null) {
				idGerenteProjeto = this.projeto.getGerente().getId();
			}
		}
		return idGerenteProjeto;
	}

	public void setIdGerenteProjeto(Long idGerenteProjeto) {
		this.idGerenteProjeto = idGerenteProjeto;

		if (this.idGerenteProjeto != null) {
			this.projeto.setGerente(new PessoaDAO().findById(idGerenteProjeto));
		}
	}

	public Long getIdNovoMembro() {
		return idNovoMembro;
	}

	public void setIdNovoMembro(Long idNovoMembro) {
		this.idNovoMembro = idNovoMembro;
	}
	
//	private String dtFormatada(Date data) {
//		
//		if(data != null ) {
//			SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
//			return simpleDate.format(data);
//		}
//		
//		return "";
//	}

}
