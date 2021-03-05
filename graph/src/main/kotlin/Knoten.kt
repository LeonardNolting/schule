data class Knoten(
	val bezeichnung: String
) {
	fun getBezeichnung(breite: UInt) = bezeichnung.padded(breite)
}