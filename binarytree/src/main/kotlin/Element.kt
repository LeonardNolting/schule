abstract class Element<D : Data> {
	abstract fun find(key: String): D?
	abstract fun refreshAndInsert(newNode: Node<D>): Element<D>
	abstract fun order(notation: Notation): List<D>
	abstract override fun toString(): String
}