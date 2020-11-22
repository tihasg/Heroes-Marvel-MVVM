package com.skydoves.marvelheroes.network

import com.skydoves.marvelheroes.model.Poster
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.DataRetainPolicy
import com.skydoves.sandwich.ResponseDataSource
import com.skydoves.sandwich.disposables.CompositeDisposable

class MarvelClient(private val marvelService: MarvelService) {

    fun fetchMarvelPosters(
            dataSource: ResponseDataSource<List<Poster>>,
            disposable: CompositeDisposable,
            onResult: (response: ApiResponse<List<Poster>>) -> Unit
    ) {
        dataSource
                // Reter dados buscados no armazenamento de memória temporariamente.
                // Se solicitar novamente, retorna os dados retidos em vez de buscar novamente na rede.
                .dataRetainPolicy(DataRetainPolicy.RETAIN)
                // tente buscar dados novamente 3 vezes com intervalo de tempo de 5.000 milissegundos quando a solicitação falha.
                .retry(3, 5000L)
                // junta-se a CompositeDisposable como descartável e descarta-se emCleared ().
                .joinDisposable(disposable)
                // combinar o serviço de rede à fonte de dados.
                .combine(marvelService.fetchMarvelPosterList(), onResult)
                // solicitar chamada de rede API de forma assíncrona.
                // se a solicitação for bem-sucedida, a fonte de dados manterá os dados de sucesso.
                // na próxima solicitação após o sucesso, retorna a resposta da API em cache com dados.
                .request()
    }
}
