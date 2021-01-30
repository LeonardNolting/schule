enum class Notation {
	PRE {
		override fun <D : Data> Node<D>.order(): List<D> = dataList + leftDataList + rightDataList
	},
	IN {
		override fun <D : Data> Node<D>.order(): List<D> = leftDataList + dataList + rightDataList
	},
	POST {
		override fun <D : Data> Node<D>.order(): List<D> = leftDataList + rightDataList + dataList
	};

	abstract fun <D : Data> Node<D>.order(): List<D>
}