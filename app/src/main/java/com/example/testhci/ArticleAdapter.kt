package com.example.testhci

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.testhci.retrofit.ItemsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemviewarticle.view.*

class ArticleAdapter(private val article: List<ItemsItem>): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        context = p0.context
        val view = LayoutInflater.from(p0.context).inflate(R.layout.itemviewarticle, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount() =  article.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.articleTitle.text = article[p1].articleTitle
        p0.linearArticle.setOnClickListener {
            val uris = Uri.parse(article.get(p1).link)
            val intents = Intent(Intent.ACTION_VIEW, uris)
            context.startActivity(intents)
        }
        val articleImage = p0.itemView.articleImage
        Picasso.with(context).load(article[p1].articleImage).into(articleImage)
    }

    class ViewHolder(itemVieww : View) : RecyclerView.ViewHolder(itemVieww) {
        val articleTitle : TextView = itemVieww.articleTitle
        val linearArticle : FrameLayout = itemVieww.linearArticle
        val articleImage : RoundedImageView = itemVieww.articleImage
    }

}
