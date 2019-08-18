package com.example.testhci

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.testhci.retrofit.ItemsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemviewproduk.view.*

class ProdukAdapter(private val produk: List<ItemsItem>) : RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        context = p0.context
        val view = LayoutInflater.from(p0.context).inflate(R.layout.itemviewproduk, p0, false)
        return ProdukAdapter.ViewHolder(view)
    }

    override fun getItemCount() = produk.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.titleProduk.text = produk[p1].productName
        val produkImage = p0.itemView.produkImage
        produkImage.setOnClickListener {
            val uris = Uri.parse(produk.get(p1).link)
            val intents = Intent(Intent.ACTION_VIEW, uris)
            context.startActivity(intents) }
        Picasso.with(context).load(produk[p1].productImage).into(produkImage)
    }

    class ViewHolder(itemVieww : View) : RecyclerView.ViewHolder(itemVieww) {
        val produkImage : ImageView = itemVieww.produkImage
        val titleProduk : TextView = itemVieww.titleProduk
    }


}
