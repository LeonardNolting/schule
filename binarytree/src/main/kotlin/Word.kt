data class Word(
	override val key: String,
	val meaning: String
) : Data {
	override fun toString() = "'$key: ${meaning.cutOverflow(120).ifEmpty { "<No definition>" }}'"
}