package br.jao.FIPEapp.main;

import br.jao.FIPEapp.model.DadosMarca;
import br.jao.FIPEapp.service.ConsumoApi;
import br.jao.FIPEapp.service.ConverteDados;

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

        var json = consumo.obterDados(url);
        DadosMarca dadosMarca = conversor.obterDados(json, DadosMarca.class);

        //System.out.println(url);
        //System.out.println(dadosMarca);










    }
}

