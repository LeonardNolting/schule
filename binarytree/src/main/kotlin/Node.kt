class Node<D : Data>(
	val data: D,
) {
	var left: Node<D>? = null
		private set
	var right: Node<D>? = null
		private set

	override fun toString() = "Node(data=$data, left=$left, right=$right)"

	operator fun plusAssign(newData: D) {
		this += Node(newData)
	}

	operator fun plusAssign(newNode: Node<D>) {
		require(newNode.data != data) { "Binary tree cannot hold two equal elements." }

		if (newNode.data < data) left = left.refreshAndInsert(newNode)
		else right = right.refreshAndInsert(newNode)
	}

	/**
	 * = in Funktionen:
	 * Folgende Funktionen sind gleich:
	 * ```
	 * fun foo(): String { return "bar" }
	 * fun foo(): String = "bar"
	 * fun foo() = "bar" // type inference
	 * ```
	 * @return Element of type [D] or null if no element with that key can be found.
	 */
	fun find(key: String): D? =
		when (key.compareTo(data.key).coerceIn(minimumValue = -1, maximumValue = 1)) {
			-1   -> left?.find(key)
			1    -> right?.find(key)
			else -> data
		}

	fun order(notation: Notation) = with(notation) { order() }
}

fun <D : Data> Node<D>?.refreshAndInsert(newData: D) = refreshAndInsert(Node(newData))
fun <D : Data> Node<D>?.refreshAndInsert(newNode: Node<D>) =
	this?.apply {
		this += newNode
	} ?: newNode