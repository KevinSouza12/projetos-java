package entities;

public class Vendedor extends Funcionario{
	private Double totalVendas;
	private Double percentualComissao;
	
	public Vendedor() {
		super();
	}
		
	public Vendedor(String nome, String cargo, Double salarioBase, Double totalVendas, Double percentualComissao) {
		super(nome, cargo, salarioBase);
		this.totalVendas = totalVendas;
		this.percentualComissao = percentualComissao;
	}

	public Double getTotalVendas() {
		return totalVendas;
	}

	public Double getPercentualComissao() {
		return percentualComissao;
	}

	public void setPercentualComissao(Double percentualComissao) {
		this.percentualComissao = percentualComissao;
	}

	@Override
	public Double calcularSalario() {
		return getSalarioBase() + (totalVendas * percentualComissao);
	}

}
