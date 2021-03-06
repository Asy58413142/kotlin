package com.cn.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    @Animal(name = "Dog", age = "12")
    @Lang(lang = "english")

    private val lang1 :String by lazy {
        val methods = javaClass.declaredMethods
        var type:String=""
        methods
                .filter { it.isAnnotationPresent(Lang::class.java) }
                .map { it.getAnnotation(Lang::class.java) }
                .forEach { if (!TextUtils.isEmpty(it.lang)) type=it.lang }
        type
    }
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //获取RecyclerView
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items);
        //anko获取组件
        val recycler: RecyclerView = find(R.id.forecast_list)

        val data1 = Data类("小明", "18")
        val data2 = data1.copy(name = "小红", age = "18")
        val (name, age) = data1
//        val name=data1.component1()
//        val age=data1.component2()

        async() {
            val url = ""
            Request(url).run()
            uiThread { " ....." }

        }


        val a = { a: Int, b: Int -> a + b }


        val methods = javaClass.declaredMethods

        methods
                .filter { it.isAnnotationPresent(Animal::class.java) }
                .map { it.getAnnotation(Animal::class.java) }
                .forEach { println("animal===${it.name}----${it.age}") }


        val parse = LangType.parse(lang1)
        parse.sayHello()

    }

    fun getValue() {

    }
}


