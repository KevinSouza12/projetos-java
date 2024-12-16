package entities;

public abstract class Funcionario { /*classe abstrata que sera herdada. O atributo cargo, será definido no programa principal
								 	no momento da instanciação do objeto*/
	private String nome;
	private String cargo;
	private Double salarioBase;
	
	public Funcionario() {
	}

	public Funcionario(String nome, String cargo, Double salarioBase) {
		this.nome = nome;
		this.cargo = cargo;
		this.salarioBase = salarioBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public abstract Double calcularSalario(); //função abstrata que será sobrescrita de acordo com a necessidade de cada classe filha
	
	public String toString() { //padroniza a saída de dados entre todas as classes filhas.
		return "Nome: " + nome + ", Cargo: " + cargo
				+ ", Salário: " + String.format("%.2f", calcularSalario());
	}
	
}
