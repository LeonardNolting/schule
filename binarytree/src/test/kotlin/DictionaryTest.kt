import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

internal class DictionaryTest {
	// Will be set before each test
	lateinit var dictionary: Dictionary

	@BeforeEach
	fun setUp() {
		dictionary = Dictionary(
			// 1
			"delta" to "",

			// 2
			"bravo" to "",

			// 3
			"alfa" to "",
			"charlie" to "",

			// 2
			"foxtrot" to "",

			// 3
			"echo" to "",
			"golf" to "",
		)
	}

	@Test
	fun order() = mapOf(
		Notation.PRE to listOf("delta", "bravo", "alfa", "charlie", "foxtrot", "echo", "golf"),
		Notation.IN to listOf("alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf"),
		Notation.POST to listOf("alfa", "charlie", "echo", "golf", "bravo", "foxtrot", "delta")
	).forEach { (notation, expected) ->
		assertEquals(expected, dictionary.order(notation).map { it.key }, "Ordering in $notation failed.")
	}

	@Test
	@Order(1)
	fun alfaFound() = assertNotNull(
		dictionary.find("alfa"),
		"There is no element with key `alfa`."
	)

	@Test
	@Order(2)
	fun addExisting() {
		assertThrows(IllegalArgumentException::class.java, {
			dictionary += Word("alfa", "")
		}) { "Could insert element with same key twice." }
	}

	@Test
	fun fooNotfound() = assertNull(dictionary.find("foo"))
}