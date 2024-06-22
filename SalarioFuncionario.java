package questao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionarios;

public class SalarioFuncionario {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionarios> lista = new ArrayList<>();
		System.out.println("Quantos funcionarios serão registrados?");
		int nFunc = sc.nextInt();
		for (int i = 0; i < nFunc; i++) {
			System.out.println("Digite o ID do funcionario:");
			Integer id = sc.nextInt();
			System.out.println("Digite o nome funcionario:");
			String nome = sc.next();
			System.out.println("Digite o salario do funcionario:");
			double salario = sc.nextDouble();
			Funcionarios func = new Funcionarios(id, nome, salario);
			lista.add(func);
		}
		System.out.println("Informe o ID do funcionario vai receber aumento");
		int idsalario = sc.nextInt();
		Funcionarios func = lista.stream().filter(x -> x.getId() == idsalario).findFirst().orElse(null);
		if (func == null) {
			System.out.println("Esse ID não existe.");
		} else {
			System.out.println("Informe a porcentagem de aumento do salario:");
			double porcentagem = sc.nextDouble();
			func.aumentarSalario(porcentagem);
		}
		printarLista(lista);
		sc.close();
	
	}
	
	public static void printarLista(List<Funcionarios> lista) {
		System.out.println("Lista de Funcionarios:");
		System.out.println("id \t nome \t salario \t");
		for (Funcionarios funcionario : lista) {
			System.out.printf("%d \t %s \t %.2f \t \n", funcionario.getId(), funcionario.getNome(), funcionario.getSalario());
		}
	}

}
