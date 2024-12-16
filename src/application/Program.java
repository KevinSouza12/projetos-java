package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;
import entities.Vendedor;

public class Program { //Desenvolvido por Kevin Souza https://github.com/KevinSouza12/projetos-java

	public static void main(String[] args) {
		Locale.setDefault(Locale.US); //para utilizar o padrao internacional de pontuação decimal.
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> funcionarios = new ArrayList<>(); //Polimorfismo, utilizo a classe abstrata fazendo upCasting com suas subclasses.
	
		boolean continuar = true; //para iniciar o bloco de repetição while.
		System.out.println("Bem vindo ao sistema gerenciador de funcionarios.");
		try { //capturar a exceção de entrada inválida de tipo de dado.
			while(continuar) {
				System.out.print("\nDigite a quantidade de funcionários deseja adicionar: ");
				int n = sc.nextInt();
				for(int i=1; i<=n; i++) {
					System.out.println("\nQual o cargo do funcionario que deseja adicionar?");
					System.out.print("- Gerente (g)\n- Vendedor (v)\n- Estagiário (e)\n\nDigite a opção desejada: ");
					char cargo = sc.next().charAt(0);
					cargo = Character.toLowerCase(cargo); //para padronizar a entrada do tipo char, caso digitem o dado em caixa alta.
					sc.nextLine();
					if(cargo != 'g' && cargo != 'v' && cargo != 'e') { //valida se a entrada corresponde as alternativas disponiveis.
						System.out.println("Opção inválida, tente novamente.");
						return;
					}
					else {
						System.out.println("\nDados do " + i + "º funcionário");
						System.out.print("Nome: ");
						String nome = sc.nextLine();
						System.out.print("Salario base: ");
						double salarioBase = sc.nextDouble();
						if(salarioBase <= 0) {
							System.out.println("\nDigite salário maior que zero.");
							return;
						}
						
						if(cargo == 'g' || cargo == 'G') {
							System.out.print("Valor do bônus mensal: ");
							String nomeCargo = "gerente";
							double bonusMensal = sc.nextDouble();
							funcionarios.add(new Gerente(nome, nomeCargo, salarioBase, bonusMensal));
						}
						else if(cargo == 'v' || cargo == 'V') {
							System.out.print("Valor total de vendas: ");
							String nomeCargo = "vendedor";
							double totalVendas = sc.nextDouble();
							System.out.print("Digite o percentual de comissão: ");
							double percentualComissao = sc.nextDouble();
							funcionarios.add(new Vendedor(nome, nomeCargo,salarioBase, totalVendas, percentualComissao));
						}
						else {
							String nomeCargo = "estagiario";
							funcionarios.add(new Estagiario(nome, nomeCargo,salarioBase));
						}
					}
					
				}
				System.out.println("\nDeseja adicionar mais funcionários? (s/n)");
				char opc = sc.next().charAt(0);
				opc = Character.toLowerCase(opc);
				if(opc =='n') {
					continuar = false; // altera a condição para false caso o usuario digite n, saindo do laço de repetição.
				}
				else {
					continuar = true;
				}
			}
			System.out.println("\nFuncionários cadastrados:"); //for each para percorrer e imprimir a lista de funcionarios.
			for(Funcionario f : funcionarios) {
				System.out.println(f);
			}

		}
		catch(InputMismatchException e) {
			System.out.println("\nErro: Dado inválido, tente novamente. ");
		}
		finally{
			sc.close();
		}
		
	}

}
