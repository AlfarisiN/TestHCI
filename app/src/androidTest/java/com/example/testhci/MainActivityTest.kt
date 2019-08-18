package com.example.testhci

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.example.testhci.CustomAssertions.Companion.hasItemCount
import com.example.testhci.CustomMatchers.Companion.withItemCount
import com.example.testhci.retrofit.ItemsItem
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

class MainActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun countArticle(){
        onView(withId(R.id.viewProduk))
    }
    @Test
    fun countProgramsWithViewAssertion() {
        onView(withId(R.id.viewProduk))
//            .check(hasItemCount(6))
    }
}