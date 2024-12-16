package entities;

public class Estagiario extends Funcionario {

	public Estagiario() {
		super();
	}
	
	public Estagiario(String nome, String cargo, Double salarioBase) {
		super(nome, cargo, salarioBase);
	}
	
	@Override
	public Double calcularSalario() {
		return getSalarioBase();
	}

}
