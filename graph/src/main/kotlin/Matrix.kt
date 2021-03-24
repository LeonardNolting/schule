import java.util.*
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

	fun fuegeKnotenEin(neuerKnoten: Knoten) = knoten.run {
		val indexDesLetztenKnotens = indexOfLast { it != null }
		check(!befuellt) {
			"Es wurden schon die maximale Anzahl an Knoten in die Matrix eingefügt. Kann keine weiteren Knoten einfügen."
		}
		set(indexDesLetztenKnotens + 1, neuerKnoten)
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

		// Maximale Breite
		val breite = max(
			adjMatrix.flatten().maxOf { it.toString().length }, // 10000
			knoten.maxOf { it?.bezeichnung?.length ?: 0 } // Frankfurt
		)

		/**
		 * Schreibe eine Zelle
		 */
		fun write(string: String?) = print(" " + ((string ?: "-") mitBreite breite) + " ")

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

	@Throws(IllegalStateException::class)
	private fun getKnotenNr(bezeichnung: String) =
		knoten.indexOfFirst { it?.bezeichnung == bezeichnung }.let { meinKnoten ->
			if (meinKnoten == -1) throw Exception("Knoten mit Bezeichnung $bezeichnung existiert in dieser Matrix nicht.")
			else meinKnoten
		}

	// 2021-03-24

	private val stack = Stack<Int>()

	fun tiefensuche(start: String) = besuchen(getKnotenNr(start))

	private fun besuchen(start: Int) {
		val vorgaenger = stack.peek()
		val nachbarn = adjMatrix[start].filter { it > 0 }
		val nochNichtBesuchteNachbarn = nachbarn.filterNot { stack.contains(it) }
		if (nochNichtBesuchteNachbarn.isEmpty()) besuchen(vorgaenger)
		else {
			stack.push(start)
			besuchen(nochNichtBesuchteNachbarn.first())
		}
	}
}