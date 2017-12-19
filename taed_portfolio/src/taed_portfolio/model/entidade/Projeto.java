package taed_portfolio.model.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6788092750785437199L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false, length=200)
	private String nome;
	
	private Date data_inicio;
	private Date data_previsao_fim;
	private Date data_fim;
	
	@Column(length=5000)
	private String descricao; // VARCHAR(5000) ,
	
	@Column(length=45)
	private String status;
	
	private Float orcamento;
	
	@Column(length=45)
	private String risco; // VARCHAR(45) ,
	
	@Column(nullable=false)
	private Long idgerente;

	public Projeto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_previsao_fim() {
		return data_previsao_fim;
	}

	public void setData_previsao_fim(Date data_previsao_fim) {
		this.data_previsao_fim = data_previsao_fim;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Float orcamento) {
		this.orcamento = orcamento;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public Long getIdgerente() {
		return idgerente;
	}

	public void setIdgerente(Long idgerente) {
		this.idgerente = idgerente;
	}

}
