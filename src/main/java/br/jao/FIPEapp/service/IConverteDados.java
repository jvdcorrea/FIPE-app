package br.jao.FIPEapp.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
