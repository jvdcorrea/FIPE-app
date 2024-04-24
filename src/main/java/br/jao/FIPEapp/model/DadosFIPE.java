package br.jao.FIPEapp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFIPE(@JsonAlias("TipoVeiculo") int tipoVeiculo,
                        @JsonAlias("Valor") String valor,
                        @JsonAlias("Marca") String marca,
                        @JsonAlias("Modelo") String modelo,
                        @JsonAlias("AnoModelo") String anoModelo,
                        @JsonAlias("Combustivel") String combustivel,
                        @JsonAlias("CodigoFipe") String codigoFipe,
                        @JsonAlias("MesReferencia") String mesReferencia,
                        @JsonAlias("SiglaCombustivel") String siglaCombustivel
) {
}


//{
//        "TipoVeiculo": 1,
//        "Valor": "R$ 30.351,00",
//        "Marca": "Fiat",
//        "Modelo": "Palio 1.0 Cel. ECON./ITALIA F.Flex 8V 4p",
//        "AnoModelo": 2014,
//        "Combustivel": "Gasolina",
//        "CodigoFipe": "001269-6",
//        "MesReferencia": "abril de 2024",
//        "SiglaCombustivel": "G"
//        }