package dev.yervand.weatherapp.view.controls

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.view.controls.adapter.BindingRecyclerViewAdapter
import dev.yervand.weatherapp.view.controls.adapter.ClickHandler
import dev.yervand.weatherapp.view.controls.adapter.LongClickHandler
import dev.yervand.weatherapp.view.controls.adapter.binding.ItemBinder

private const val KEY_ITEMS = -123
private const val KEY_CLICK_HANDLER = -124
private const val KEY_LONG_CLICK_HANDLER = -125

@BindingAdapter("items")
fun <T> setItems(recyclerView: RecyclerView, items: Collection<T>) {
    val adapter = recyclerView.adapter as? BindingRecyclerViewAdapter<T>
    adapter?.setItems(items) ?: recyclerView.setTag(KEY_ITEMS, items)
}

@BindingAdapter("clickHandler")
fun <T> setHandler(recyclerView: RecyclerView, handler: ClickHandler<T>) {
    val adapter = recyclerView.adapter as? BindingRecyclerViewAdapter<T>
    if (adapter != null) {
        adapter.clickHandler = handler
    } else {
        recyclerView.setTag(KEY_CLICK_HANDLER, handler)
    }
}

@BindingAdapter("longClickHandler")
fun <T> setHandler(recyclerView: RecyclerView, handler: LongClickHandler<T>) {
    val adapter = recyclerView.adapter as? BindingRecyclerViewAdapter<T>
    if (adapter != null) {
        adapter.longClickHandler = handler
    } else {
        recyclerView.setTag(KEY_LONG_CLICK_HANDLER, handler)
    }
}

@BindingAdapter("itemViewBinder")
fun <T> setItemViewBinder(recyclerView: RecyclerView, itemViewMapper: ItemBinder<T>) {
    val items = recyclerView.getTag(KEY_ITEMS) as? ObservableList<T>
    val clickHandler = recyclerView.getTag(KEY_CLICK_HANDLER) as? ClickHandler<T>
    val adapter = BindingRecyclerViewAdapter(itemViewMapper, items)
    if (clickHandler != null) {
        adapter.clickHandler = clickHandler
    }
    recyclerView.adapter = adapter
}

@BindingAdapter("unSelectItem", "selectItem")
fun selectItem(recyclerView: RecyclerView, items: ObservableArrayList<Forecast>?, item: Forecast?) {
    items?.forEach {
        it.selected = false
    }
    item?.selected = true
    recyclerView.adapter?.notifyDataSetChanged()
}