data class Knoten(
	val bezeichnung: String
) {
	fun getBezeichnung(breite: UInt) = bezeichnung
		.padEnd(breite.toInt(), ' ')
		.substring(0 until breite.toInt())
}