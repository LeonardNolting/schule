class Knoten(
	private val bezeichnung: String
) {
	fun getBezeichnung(breite: UInt) = bezeichnung.substring(0 until breite.toInt()).padEnd(breite.toInt(), ' ')
}