import kotlin.math.max

class GraphMatrix(
	private val maxKnotenAnzahl: UInt,
) {
	private val knotenAnzahl get() = knoten.count { it != null }
	private val knoten = Array<Knoten?>(maxKnotenAnzahl.toInt()) { null }
	private val adjMatrix = Array(maxKnotenAnzahl.toInt()) { spalte ->
		Array(maxKnotenAnzahl.toInt()) { zeile ->
			if (zeile == spalte) 0 // von == zu
			else -1
		}
	}
	private val befuellt get() = knotenAnzahl == maxKnotenAnzahl.toInt()

	fun fuegeKnotenEin(knoten: Knoten) = this.knoten.run {
		val indexDesLetztenKnotens = indexOfLast { it != null }
		check(!befuellt) {
			"Es wurden schon die maximale Anzahl an Knoten in die Matrix eingefügt. Kann keine weiteren Knoten einfügen."
		}
		set(indexDesLetztenKnotens + 1, knoten)
	}

	fun fuegeKnotenEin(bezeichnung: String) = fuegeKnotenEin(Knoten(bezeichnung))
	fun fuegeKanteEin(von: String, nach: String, gewicht: Int) {
		val vonIndex = getKnotenNr(von)
		val nachIndex = getKnotenNr(nach)

		require(vonIndex != nachIndex) { "Eine Strecke von a zu a ist immer 0." }

		adjMatrix[vonIndex][nachIndex] = gewicht
		adjMatrix[nachIndex][vonIndex] = gewicht
	}

	fun getKantengewicht(von: String, nach: String) =
		adjMatrix[getKnotenNr(von)][getKnotenNr(nach)]

	fun ausgeben() {
		check(befuellt) { "Bitte befülle die Matrix erst vollständig, bevor du sie ausgibst." }

		val breite = max(
			adjMatrix.flatten().maxOf { it.toString().length }, // 10000
			knoten.maxOf { it?.bezeichnung?.length ?: 0 } // Frankfurt
		).toUInt()

		fun write(string: String?) = print(" " + (string ?: "-").padded(breite) + " ")

		// Kopfzeile
		write("")
		knoten.forEach { write(it?.bezeichnung) }
		println()

		// Zeilen
		knoten.forEach {
			write(it?.bezeichnung)
			it?.let { adjMatrix[getKnotenNr(it)].forEach { gewicht -> write(gewicht.toString()) } }
			println()
		}
	}

	private fun getKnotenNr(knoten: Knoten) = getKnotenNr(knoten.bezeichnung)

	private fun getKnotenNr(bezeichnung: String) =
		knoten.indexOfFirst { it?.bezeichnung == bezeichnung }.let {
			if (it == -1) error("Knoten mit Bezeichnung $bezeichnung existiert in dieser Matrix nicht.")
			else it
		}
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
