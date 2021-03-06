/**
 * Klasse mit primärem Konstruktor
 * @param words Liste aus Wörtern
 */
class Dictionary(
	words: List<Word>
) : BinaryTree<Word>(words) {
	/**
	 * Sekundärer Konstruktor (overload)
	 *
	 * Beispiel:
	 * ```
	 * Dictionary(
	 *     "hello" to "Greeting",
	 *     "world" to "Synonym for earth"
	 * )
	 * ```
	 * @param words Liste aus Wörtern
	 */
	constructor(
		vararg words: Pair<String, String>
	) : this(words.map { (key, meaning) -> Word(key, meaning) })

	override fun toString() =
		Notation.values().joinToString("\n") { it.name + ": " + toString(it) }
}