/**
 * Klasse mit primärem Konstruktor
 * @param words Liste aus Wörtern
 */
class Dictionary(
	words: List<Word>
) : BinaryTree<Word>(words) {
	/**
	 * Sekundärer Konstruktor (overload)
	 * @param words Liste aus Wörtern
	 * Beispiel:
	 * ```
	 * Dictionary(
	 *     "hello" to "Greeting",
	 *     "world" to "Synonym for earth"
	 * )
	 * ```
	 */
	constructor(
		vararg words: Pair<String, String>
	) : this(words.map { (key, meaning) -> Word(key, meaning) })

	override fun toString(): String {
		return Notation.values().joinToString("\n") { it.name + ": " + toString(it) }
	}
}