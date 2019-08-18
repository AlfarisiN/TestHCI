package com.example.testhci

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.example.testhci.retrofit.ItemsItem
import com.example.testhci.retrofit.NetworkAPI


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofit()
    }

    private fun showArticle(article: List<ItemsItem>) {
        viewArticle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ArticleAdapter(article)
        }
    }
    private fun showProduk(produk: List<ItemsItem>){
        viewProduk.apply {
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter = ProdukAdapter(produk)
        }
        viewProduk.isNestedScrollingEnabled
    }
    private fun retrofit(){
        val client = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .baseUrl("https://private-a8e48-hcidtest.apiary-mock.com").build()

        val api = retrofit.create(NetworkAPI::class.java)
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        api.getHome().enqueue(object :Callback<com.example.testhci.retrofit.Response>{
            override fun onResponse(call: Call<com.example.testhci.retrofit.Response>, response: Response<com.example.testhci.retrofit.Response>) {
                if(response.isSuccessful){
                    progressDialog.dismiss()
                    showArticle(response.body()!!.data!![1]!!.itemss as List<ItemsItem>)
                    showProduk(response.body()!!.data!![0]!!.itemss as List<ItemsItem>)
                    sectionTitle.text = response.body()!!.data!![1]!!.section
                }else{
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity,"" +response.message(),Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<com.example.testhci.retrofit.Response>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(this@MainActivity,"" +t,Toast.LENGTH_LONG).show()
            }


        })
    }
}
