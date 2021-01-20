class Dictionary(
	words: List<Word>
) : BinaryTree<Word>(words) {
	constructor(
		vararg words: Pair<String, String>
	): this(words.map { Word(it.first, it.second) })

	override fun toString(): String {
		return Notation.values().joinToString("\n") { it.name + ": " + toString(it) }
	}
}