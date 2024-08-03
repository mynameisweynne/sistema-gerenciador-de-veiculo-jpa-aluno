package br.com.fuctura.application;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.dao.factory.DAOFactory;
import br.com.fuctura.entity.Tipo;
import br.com.fuctura.entity.Veiculo;

public class App {

	public static void main(String[] args) {

		VeiculoDAO veiculoDAO = DAOFactory.createVeiculoDAO();

		int opcao = 0;

		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("\n=== GERENCIADOR DE VEÍCULOS ===");
				System.out.println("1 - Cadastrar veículo");
				System.out.println("2 - Atualizar veículo");
				System.out.println("3 - Excluir veículo");
				System.out.println("4 - Buscar veículo por código");
				System.out.println("5 - Listar todos os veículos");
				System.out.println("0 - Sair");
				System.out.print("Escolha uma opção: ");
				opcao = sc.nextInt();
				sc.nextLine();
				switch (opcao) {
				case 1:
					cadastraVeiculo(sc, veiculoDAO);
					break;
				case 2:
					atualizarVeiculo(sc, veiculoDAO);
					break;
				case 3:
					excluirVeiculo(sc, veiculoDAO);
					break;
				case 4:
					buscarVeiculo(sc, veiculoDAO);
					break;
				case 5:
					listarVeiculo(sc, veiculoDAO);
					break;
				}
			} while (opcao != 0);

		}
	}

	private static void listarVeiculo(Scanner sc, VeiculoDAO veiculoDAO) {
		List<Veiculo> veiculos = veiculoDAO.findAll();

		if (veiculos.isEmpty()) {
			System.out.println("Nenhum veículo cadastrado!");
		} else {
			System.out.println("Lista de veículos:");
			for (Veiculo veiculo : veiculos) {
				System.out.println(veiculo);
			}
		}
	}

	private static void buscarVeiculo(Scanner sc, VeiculoDAO veiculoDAO) {
		System.out.print("Digite o código do veículo que deseja buscar: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		Veiculo veiculo = veiculoDAO.findById(codigo);

		if (veiculo == null) {
			System.out.println("Veículo não encontrado!");
		} else {
			System.out.println("Dados do veículo:");
			System.out.println(veiculo);
		}
	}

	private static void excluirVeiculo(Scanner sc, VeiculoDAO veiculoDAO) {
		System.out.print("Digite o código do veículo que deseja excluir: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		try {
			veiculoDAO.deleteById(codigo);
			System.out.println("Veículo excluído com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao excluir veículo: " + e.getMessage());
		}
	}

	private static void atualizarVeiculo(Scanner sc, VeiculoDAO veiculoDAO) {
		System.out.print("Digite o código do veículo que deseja atualizar: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		Veiculo veiculo = veiculoDAO.findById(codigo);

		if (veiculo == null) {
			System.out.println("Veículo não encontrado!");
			return;
		}

		System.out.println("Dados atuais do veículo:");
		System.out.println(veiculo);

		System.out.print("Digite a nova placa (ou Enter para manter a atual): ");
		String novaPlaca = sc.nextLine();
		if (!novaPlaca.isEmpty()) {
			veiculo.setPlaca(novaPlaca);
		}

		System.out.print("Digite o novo modelo (ou Enter para manter a atual): ");
		String novoModelo = sc.nextLine();
		if (!novoModelo.isEmpty()) {
			veiculo.setModelo(novoModelo);
		}

		System.out.print("Digite o novo ano (ou Enter para manter a atual): ");
		String novoAnoStr = sc.nextLine();
		if (!novoAnoStr.isEmpty()) {
			int novoAno = Integer.parseInt(novoAnoStr);
			veiculo.setAno(novoAno);
		}

		System.out.print("Digite o novo valor (ou Enter para manter a atual): ");
		String novoValorStr = sc.nextLine();
		if (!novoValorStr.isEmpty()) {
			double novoValor = Double.parseDouble(novoValorStr);
			veiculo.setValor(novoValor);
		}

		System.out.print("Digite a nova descrição do tipo (ou Enter para manter a atual): ");
		String novaDescricaoTipo = sc.nextLine();
		if (!novaDescricaoTipo.isEmpty()) {
			if (veiculo.getTipo() != null) {
				veiculo.getTipo().setDescricao(novaDescricaoTipo);
			} else {
				Tipo novoTipo = new Tipo(0, novaDescricaoTipo);
				veiculo.setTipo(novoTipo);
			}
		}

		try {
			veiculoDAO.update(veiculo);
			System.out.println("Veículo atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar veículo: " + e.getMessage());
		}
	}

	private static void cadastraVeiculo(Scanner sc, VeiculoDAO veiculoDAO) {
		System.out.print("Digite a placa: ");
		String placa = sc.nextLine();
		System.out.print("Digite o modelo: ");
		String modelo = sc.nextLine();
		System.out.print("Digite o ano: ");
		int ano = sc.nextInt();
		sc.nextLine();
		System.out.print("Digite o valor: ");
		double valor = sc.nextDouble();
		sc.nextLine();
		System.out.print("Digite a descrição do tipo do veículo: ");
		String descricaoTipo = sc.nextLine();
		Tipo tipo = new Tipo(0, descricaoTipo);

		Veiculo veiculo = new Veiculo(0, placa, modelo, ano, valor, tipo);
		veiculoDAO.insert(veiculo);
		System.out.println("Veículo cadastrado com sucesso!");
	}
}
