import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GraphMatrixTest {
	val matrix = GraphMatrix(maxKnoten = 14u)
	val staedte = listOf("F", "KA", "FD", "WÜ", "S", "UL", "LI", "HO", "N", "A", "R", "M", "PA", "RO")

	@BeforeEach
	fun setUp() {
		for (stadt in staedte)
			matrix.fuegeKnotenEin(stadt)
	}

	@Test
	fun fuegeKnotenEin() {
	}

	@Test
	fun getKantengewicht() {
	}
}