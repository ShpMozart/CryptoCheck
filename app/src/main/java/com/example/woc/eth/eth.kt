package com.example.woc.eth

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.woc.R
import com.example.woc.databinding.FragmentEthBinding
import kotlinx.android.synthetic.main.fragment_btc.*
import kotlinx.android.synthetic.main.fragment_eth.*
import java.lang.Exception


class eth : Fragment() {
    private lateinit var binding: FragmentEthBinding
    var url = "https://api.navasan.tech/latest/?api_key=kOyejl9t0wm5vEeFZUXR7AWJSd1JTiVP"

    var requestQueue: RequestQueue? = null
    var con: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        con = this.activity
        requestQueue = Volley.newRequestQueue(con)
        getData()

            binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_eth,container,false)



            return binding.root
        }

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_eth, container, false)


    fun getData() {
        Log.i("check", "hello4")
        var jsonreq = JsonObjectRequest(Request.Method.GET, url, null
            , Response.Listener { response ->
                try {
                    Log.i("check", "hello")
                    var eth = response.getJSONObject("eth")
                    var value = eth.getString("value")
                    binding.etheriumPrice.text = value.toString()+"  TMN"
                } catch (ex: Exception) {
                    Log.i("check", "hello2")
                    Toast.makeText(con, ex.message.toString(), Toast.LENGTH_LONG).show()
                }
            }, Response.ErrorListener {
                Log.i("check", "hello3")
                Toast.makeText(con, it.message.toString(), Toast.LENGTH_LONG).show()

            })
        requestQueue?.add(jsonreq)
    }
}