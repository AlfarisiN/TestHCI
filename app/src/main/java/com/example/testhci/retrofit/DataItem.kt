package com.example.testhci.retrofit

import com.google.gson.annotations.SerializedName

data class DataItem(
	@SerializedName("section_title")
	val sectionTitle: String,
	@SerializedName("section")
	val section: String,
	@SerializedName("items")
	val itemss: List<ItemsItem?>
)
