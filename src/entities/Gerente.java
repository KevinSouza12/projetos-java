package entities;

public class Gerente extends Funcionario{
	private Double bonusMensal;
	
	public Gerente() {
		super();
	}
	
	public Gerente(String nome, String cargo, Double salarioBase, Double bonusMensal) {
		super(nome, cargo, salarioBase);
		this.bonusMensal = bonusMensal;
	}

	public Double getBonusMensal() {
		return bonusMensal;
	}

	public void setBonusMensal(Double bonusMensal) {
		this.bonusMensal = bonusMensal;
	}

	@Override
	public Double calcularSalario() {
		return getSalarioBase() + bonusMensal ;
	}
	
}
