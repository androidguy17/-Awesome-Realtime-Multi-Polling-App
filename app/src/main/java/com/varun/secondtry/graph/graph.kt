package com.varun.secondtry.graph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.chart.common.listener.Event
import com.anychart.chart.common.listener.ListenersInterface
import com.anychart.enums.Align
import com.anychart.enums.LegendLayout
import com.varun.secondtry.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_graph.*
import kotlinx.android.synthetic.main.graph_token.view.*
import java.util.ArrayList

class graph : AppCompatActivity() {

    var adapter: GroupAdapter<GroupieViewHolder> ?=null
    var id: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        var bundle: Bundle? = intent.extras

        id = bundle?.getString("ID")

            recycler_graph.adapter = adapter

        adapter?.add(graph())
        adapter?.add(graph())
        adapter?.add(graph())
    }

    inner class graph():Item<GroupieViewHolder>(){
        override fun getLayout(): Int {
            return R.layout.graph_token
        }

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {







                    val anyChartView = viewHolder.itemView.charts
                    anyChartView.setProgressBar(viewHolder.itemView.pro)
                    val pie = AnyChart.pie()
                    pie.setOnClickListener(object :
                        ListenersInterface.OnClickListener(arrayOf("x", "value")) {
                        override fun onClick(event: Event) {

                        }
                    })
                    val data: MutableList<DataEntry> = ArrayList()
                    data.add(ValueDataEntry("Apples", 6371664))
                    data.add(ValueDataEntry("Pears", 789622))
                    data.add(ValueDataEntry("Bananas", 7216301))
                    data.add(ValueDataEntry("Grapes", 1486621))
                    data.add(ValueDataEntry("Oranges", 1200000))
                    pie.data(data)
                    pie.title("Fruits imported in 2015 (in kg)")
                    pie.labels().position("outside")
                    pie.legend().title().enabled(true)
                    pie.legend().title()
                        .text("Retail channels")
                        .padding(0.0, 0.0, 10.0, 0.0)
                    pie.legend()
                        .position("center-bottom")
                        .itemsLayout(LegendLayout.HORIZONTAL)
                        .align(Align.CENTER)
                    anyChartView.setChart(pie)
                }
            }










        }











