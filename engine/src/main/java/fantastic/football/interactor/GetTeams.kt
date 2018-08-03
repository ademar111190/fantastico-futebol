package fantastic.football.interactor

import fantastic.football.model.*

class GetTeams {

    fun all() = listOf(
        Team("América-MG", MINAS_GERAIS),
        Team("Atlético-MG", MINAS_GERAIS),
        Team("Atlético-PR", SUL),
        Team("Bahia", NORTE),
        Team("Botafogo", RIO_DE_JANEIRO),
        Team("Ceará", NORTE),
        Team("Chapecoense", SUL),
        Team("Corinthians", SAO_PAULO),
        Team("Cruzeiro", MINAS_GERAIS),
        Team("Flamengo", RIO_DE_JANEIRO),
        Team("Fluminense", RIO_DE_JANEIRO),
        Team("Grêmio", SUL),
        Team("Internacional", SUL),
        Team("Palmeiras", SAO_PAULO),
        Team("Paraná", SUL),
        Team("Santos", SAO_PAULO),
        Team("Sport", NORTE),
        Team("São Paulo", SAO_PAULO),
        Team("Vasco", RIO_DE_JANEIRO),
        Team("Vitória", NORTE))

    fun byLocation() = all().groupBy { it.location }

}
