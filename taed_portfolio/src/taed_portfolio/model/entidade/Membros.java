package taed_portfolio.model.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="membros")
public class Membros extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7124604228544692141L;

	@Id
	@Column(nullable=false)
	private Long idprojeto;
	
	@Column(nullable=false)
	private Long idpessoa;

	public Membros() {
		super();
	}

	public Long getIdprojeto() {
		return idprojeto;
	}

	public void setIdprojeto(Long idprojeto) {
		this.idprojeto = idprojeto;
	}

	public Long getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(Long idpessoa) {
		this.idpessoa = idpessoa;
	}

}
