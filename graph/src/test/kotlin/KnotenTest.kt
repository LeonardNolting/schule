import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class KnotenTest {
	@Test
	fun `bezeichnung formatierte länge entspricht breite`() {
		assertEquals(Knoten("ab").getBezeichnung(4u), "ab  ")
		assertEquals(Knoten("abcdef").getBezeichnung(4u), "abcd")
	}
}