package fantastic.football.model

data class Location(
    val name: String,
    val parent: Location? = null
)

val BRASIl = Location("Brasil")
val NORTE = Location("Norte", BRASIl)
val MINAS_GERAIS = Location("Minas Gerais", BRASIl)
val SUL = Location("Sul", BRASIl)
val RIO_DE_JANEIRO = Location("Rio de Janeiro", BRASIl)
val SAO_PAULO = Location("São Paulo", BRASIl)
