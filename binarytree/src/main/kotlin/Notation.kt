enum class Notation {
	PRE {
		override fun Node<*>.order() = dataList + leftDataList + rightDataList
	},
	IN {
		override fun Node<*>.order() = leftDataList + dataList + rightDataList
	},
	POST {
		override fun Node<*>.order() = leftDataList + rightDataList + dataList
	};

	protected val Node<*>.leftDataList get() = left.order()
	protected val Node<*>.rightDataList get() = right.order()
	protected val Node<*>.dataList get() = listOf(data)

	abstract fun Node<*>.order(): List<Data>

	@JvmName("orderNull")
	fun Node<*>?.order() = this?.order() ?: listOf()
}