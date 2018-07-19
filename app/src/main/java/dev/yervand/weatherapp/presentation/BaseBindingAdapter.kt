package dev.yervand.weatherapp.presentation

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseBindingAdapter<I> : RecyclerView.Adapter<BaseBindingViewHolder>(), BaseBindingViewHolder.ClickListener {

    private var items: MutableList<I> = ArrayList()
    private var itemClickListener: ItemClickListener<I>? = null

    override fun onViewClick(position: Int, view: View) {
        if (itemClickListener != null) {
            itemClickListener!!.onClick(items[position], position, view)
        }
    }

    fun getItems(): List<I> {
        return items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = bind(inflater, parent, viewType)
        return BaseBindingViewHolder(binding, this)
    }

    protected abstract fun bind(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): ViewDataBinding

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: MutableList<I>) {
        this.items = items
        notifyDataSetChanged()
    }


    fun addItem(item: I, position: Int = items.size) {
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addItems(itemsToAdd: List<I>, position: Int = items.size) {
        items.addAll(position, itemsToAdd)
        notifyItemRangeInserted(position, itemsToAdd.size)
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clear() {
        val size = items.size
        if (size > 0) {
            items.clear()
            notifyItemRangeRemoved(0, size)
        }
    }

    fun setItemClickListener(itemClickListener: ItemClickListener<I>) {
        this.itemClickListener = itemClickListener
    }

    interface ItemClickListener<I> {
        fun onClick(item: I, position: Int, view: View)
    }
}