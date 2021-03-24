data class Knoten(
    val bezeichnung: String
) : Comparable<Knoten> {
    fun getBezeichnung(breite: UInt) = bezeichnung.mitBreite(breite)

    override fun compareTo(other: Knoten) = bezeichnung.compareTo(other.bezeichnung)
}