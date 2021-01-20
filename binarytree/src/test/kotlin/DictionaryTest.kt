import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DictionaryTest {
	lateinit var dictionary: Dictionary

	@BeforeEach
	fun setUp() {
		dictionary = Dictionary(
			"Hello" to "Hello is a salutation or greeting in the English language. It is first attested in writing from 1826.",
			"World" to "The world is the Earth and all life on it, including human civilization.",
			"Supercalifragilisticexpialidocious" to """
				A song and single from the 1964 Disney musical film Mary Poppins. The song was written by the Sherman Brothers, and sung by Julie Andrews and Dick Van Dyke. It also appears in the 2004 stage show version. Because Mary Poppins was a period piece set in 1910, songs that sounded similar to songs of the period were wanted. The movie version finished at #36 in AFI's 100 Years...100 Songs survey of top tunes in American cinema.
			""".trimIndent(),
			"Superstition" to """
				A superstition is "a belief or practice resulting from ignorance, fear of the unknown, trust in magic or chance, or a false conception of causation" or "an irrational abject attitude of mind toward the supernatural, nature, or God resulting from superstition." Often, it arises from ignorance, a misunderstanding of science or causality, a belief in fate or magic, or fear of that which is unknown. It is commonly applied to beliefs and practices surrounding luck, prophecy, and certain spiritual beings, particularly the belief that future events can be foretold by specific (apparently) unrelated prior events. The word superstition is often used to refer to a religion not practiced by the majority of a given society regardless of whether the prevailing religion contains alleged superstitions.
			""".trimIndent(),
			"Alphabet" to "All letters."
		)
	}

	@Test
	fun superstitionFound() {
		assertNotNull(dictionary.find("Superstition"))
	}

	@Test
	fun fooNotfound() {
		assertNull(dictionary.find("foo"))
	}
}