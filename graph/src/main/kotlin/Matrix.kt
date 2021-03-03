class GraphMatrix(
	private val maxKnoten: UInt,
) {
	private val knotenAnzahl get() = knoten.count { it != null }
	private val knoten = Array<Knoten?>(maxKnoten.toInt()) { null }
	private val adjMatrix = Array(maxKnoten.toInt()) { Array<Int?>(maxKnoten.toInt()) { null } }
	fun fuegeKnotenEin(knoten: Knoten) = this.knoten.run {
		val indexDesLetztenKnotens = indexOfLast { it != null }
		require(indexDesLetztenKnotens + 1 != size) {
			"Es wurden schon die maximale Anzahl an Knoten in die Matrix eingefügt. Kann keine weiteren Knoten einfügen."
		}
		set(indexDesLetztenKnotens + 1, knoten)
	}

	fun fuegeKnotenEin(bezeichnung: String) = fuegeKnotenEin(Knoten(bezeichnung))
	fun fuegeKanteEin(von: String, nach: String, gewicht: Int) {
		TODO()
	}

	fun getKantengewicht(von: String, nach: String): Int {
		TODO()
	}

	fun ausgeben(breite: Int) {
		TODO()
	}

	fun getKnotenNr(bezeichnung: String) =
		knoten.indexOfFirst { it?.bezeichnung == bezeichnung }
}

/*
class Matrix(anzahlZeilen: Int, anzahlSpalten: Int) {
	private val zeilen = Array(anzahlZeilen) {
		Array<Int?>(anzahlSpalten) { null }
	}

	fun befuelleZeile(zeilenIndex: Int, werte: Array<Int>) = zeilen[zeilenIndex].apply {
		require(zeilenIndex < zeilen.size) { "Kann $zeilenIndex. Zeile nicht befüllen, da diese nicht existiert. Vorhandene Zeilen: ${zeilen.size}" }
		require(werte.size == size) { "Die Anzahl der Werte muss dem angegebenem Wert entsprechen. Gegeben: ${werte.size}; Erwartet: $size" }

		for ((spaltenIndex, _) in this.withIndex())
			zeilen[zeilenIndex][spaltenIndex] = werte[spaltenIndex]
	}

	fun befuellen(werte: Array<Array<Int>>) = zeilen.apply {
		require(werte.size == size) { "Die Anzahl der Listen aus Werten muss dem angegebenem Wert entsprechen. Gegeben: ${werte.size}; Erwartet: $size" }

		for ((zeilenIndex, _) in werte.withIndex()) befuelleZeile(zeilenIndex, werte[zeilenIndex])
	}

	fun befuellen(werte: Array<Int>) {
		require(zeilen.isNotEmpty()) { "Kann Matrix mit 0 Zeilen nicht befüllen." }

		val erwarteteAnzahlWerte = zeilen.size * zeilen[0].size
		require(werte.size == erwarteteAnzahlWerte) { "Anzahl Werte passt nicht. Gegeben: ${werte.size}; Erwartet: $erwarteteAnzahlWerte" }

		werte.toList().chunked(zeilen[0].size).withIndex()
			.forEach { (index, werte) -> befuelleZeile(index, werte.toTypedArray()) }
	}

	fun befuellen() {
		var wert = 1
		zeilen.withIndex().forEach { (index, zeile) ->
			befuelleZeile(index, zeile.indices.map { wert++ }.toTypedArray())
		}
	}

	override fun toString() =
		zeilen.joinToString("\n") { spalten -> spalten.joinToString(", ") }
}*/
