class End<D : Data> : Element<D>() {
	override fun find(key: String): D? = null
	override fun refreshAndInsert(newNode: Node<D>) = newNode
	override fun order(notation: Notation) = listOf<D>()
	override fun toString() = "End"
}