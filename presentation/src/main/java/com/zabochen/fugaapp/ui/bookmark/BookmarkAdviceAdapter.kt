package com.zabochen.fugaapp.ui.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zabochen.doman.model.Advice
import com.zabochen.fugaapp.R
import com.zabochen.fugaapp.ui.bookmark.BookmarkAdviceAdapter.ViewHolder
import kotlinx.android.synthetic.main.adapter_advice_bookmark.view.*

class BookmarkAdviceAdapter(
    private val clickListener: (Advice) -> Unit
) : ListAdapter<Advice, ViewHolder>(AdviceDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_advice_bookmark, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(advice: Advice, clickListener: (Advice) -> Unit) {
            itemView.setOnClickListener { clickListener(advice) }
            itemView.adapterAdviceBookmark_textView_adviceText.text = advice.text
        }
    }

    class AdviceDiffCallback : DiffUtil.ItemCallback<Advice>() {
        override fun areItemsTheSame(oldItem: Advice, newItem: Advice): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Advice, newItem: Advice): Boolean {
            return oldItem == newItem
        }
    }
}