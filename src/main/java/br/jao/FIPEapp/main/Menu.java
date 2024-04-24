package br.jao.FIPEapp.main;

import br.jao.FIPEapp.model.DadosFIPE;
import br.jao.FIPEapp.model.DadosMarca;
import br.jao.FIPEapp.model.DadosModelo;
import br.jao.FIPEapp.model.Veiculo;
import br.jao.FIPEapp.service.ConsumoApi;
import br.jao.FIPEapp.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private String url = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    public void exibeMenu() {

        System.out.println("Digite uma opção para continuar\n" +
                "carros\n" +
                "motos\n" +
                "caminhoes\n");
        var opVeiculo = scanner.nextLine();

        if (opVeiculo.equals("carros") || opVeiculo.equals("motos") || opVeiculo.equals("caminhoes")){
            url = url + opVeiculo + "/marcas/";
        } else {
            System.out.println("Erro");
        }

        try {
            var json = consumo.obterDados(url);
            List<DadosMarca> dadosMarca = conversor.obterlista(json, DadosMarca.class);
            dadosMarca.forEach(System.out::println);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nDigite o codigo do modelo desejado");
        var opModelo = scanner.nextLine();
        url = url + opModelo + "/modelos/";
        System.out.println(url);

        DadosModelo dadosParaFiltrar = new DadosModelo(null, null);
        try {
            var json = consumo.obterDados(url);
            DadosModelo dadosModelo = conversor.obterDados(json, DadosModelo.class);
           System.out.println(dadosModelo);
           dadosParaFiltrar = dadosModelo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Veiculo> veiculos = new ArrayList<>();
        System.out.println("Digite o nome do carro desejado.");
        var nomeCarro = scanner.nextLine();
        dadosParaFiltrar.modelos().stream()
                .filter(e -> e.toString().toUpperCase().contains(nomeCarro.toUpperCase()))
                        .forEach(e -> veiculos.add(new Veiculo(e.codigo(), e.nome())));

        veiculos.forEach(System.out::println);

        System.out.println("Digite o codigo do carro desejado");
        var codigoVeiculo = scanner.nextLine();
        url = url + codigoVeiculo + "/anos/";

        try{
            var json = consumo.obterDados(url);
            List<DadosMarca> dadosAnos = conversor.obterlista(json, DadosMarca.class);
            dadosAnos.forEach(System.out::println);

            for(DadosMarca e : dadosAnos) {
                json = url + e.codigo();
                List<DadosFIPE> dfipe = conversor.obterlista(json, DadosFIPE.class);
                System.out.println(dfipe);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }









    }
}

