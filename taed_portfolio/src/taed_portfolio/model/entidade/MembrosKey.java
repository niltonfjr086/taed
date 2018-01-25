package taed_portfolio.model.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class MembrosKey extends BaseEntity {

	private static final long serialVersionUID = -673281815740747840L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idprojeto", nullable = false)
	private Projeto projeto;
//	private Long idprojeto;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idpessoa", nullable = false)
	private Pessoa pessoa;
//	private Long idpessoa;
	
	public MembrosKey() {
		super();
	}

	public MembrosKey(Projeto projeto, Pessoa pessoa) {
		super();
		this.projeto = projeto;
		this.pessoa = pessoa;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
