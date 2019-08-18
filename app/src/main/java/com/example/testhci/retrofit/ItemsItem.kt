package com.example.testhci.retrofit

import com.google.gson.annotations.SerializedName

data class ItemsItem(
	@SerializedName("link")
	val link: String,
	@SerializedName("product_image")
	val productImage: String,
	@SerializedName("product_name")
	val productName: String,
	@SerializedName("article_title")
	val articleTitle: String,
	@SerializedName("article_image")
	val articleImage: String
)
