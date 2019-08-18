package com.example.testhci.retrofit

import com.google.gson.annotations.SerializedName

data class Response(
	@SerializedName("data")
	val `data`: List<DataItem?>? = null
)
