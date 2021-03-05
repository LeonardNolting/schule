import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

/**
 * s. S.97 Abb. 3
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class GraphMatrixTest {
	val matrix = GraphMatrix(maxKnotenAnzahl = 14u)
	val staedte = listOf("F", "KA", "FD", "WÜ", "S", "UL", "LI", "HO", "N", "A", "R", "M", "PA", "RO")
	val kanten = listOf(
		"F" to "KA" to 127,
		"F" to "WÜ" to 131,
		"FD" to "WÜ" to 98,
		"KA" to "S" to 53,
		"S" to "WÜ" to 155,
		"WÜ" to "UL" to 165,
		"UL" to "LI" to 126,
		"WÜ" to "HO" to 192,
		"WÜ" to "N" to 104,
		"HO" to "N" to 116,
		"UL" to "A" to 59,
		"A" to "M" to 64,
		"N" to "M" to 163,
		"HO" to "R" to 166,
		"M" to "R" to 117,
		"R" to "PA" to 72,
		"M" to "RO" to 60
	)

	@AfterAll
	fun tearDown() {
		matrix.ausgeben()
	}

	@Test
	fun fuegeKnotenEin() {
		for (stadt in staedte)
			matrix.fuegeKnotenEin(stadt)
	}

	@Test
	fun fuegeKanteEin() {
		for ((orte, gewicht) in kanten) {
			matrix.fuegeKanteEin(orte.first, orte.second, gewicht)
			assertEquals(matrix.getKantengewicht(orte.first, orte.second), gewicht)
		}
	}
}