/**
 * Primäre Konstruktoren können Parameter sofort als Attribute behandeln
 * Java-Äquivalent:
 * ```
 * public class Word implements Data {
 *  @Override
 *  private final String key;
 *  private final String meaning;
 *  public Word(String key, String meaning) {
 *      this.key = key;
 *      this.meaning = meaning;
 *  }
 *  String getKey() {
 *      return key;
 *  }
 *  @Override
 *  String toString() {
 *      return "...";
 *  }
 * }
 * ```
 */
data class Word(
	override val key: String,
	val meaning: String
) : Data {
	override fun toString() = "'$key: ${meaning.cutOverflow(120u).ifEmpty { "<No definition>" }}'"
}