package taed_portfolio.model.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "membros")
public class Membros extends BaseEntity {

	private static final long serialVersionUID = 7124604228544692141L;

	@Id
	private MembrosKey membrosKey;

	public Membros() {
		super();
	}

	public MembrosKey getMembrosKey() {
		return membrosKey;
	}

	public void setMembrosKey(MembrosKey membrosKey) {
		this.membrosKey = membrosKey;
	}

}
