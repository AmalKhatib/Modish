package com.example.modish.activities.fragments

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView

import com.example.modish.R

class CartDeliveryFragment : Fragment() {

    lateinit var _view : View
    lateinit var layout_orderNote : RelativeLayout;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _view = inflater.inflate(R.layout.fragment_cart_delivery, container, false)

        layout_orderNote = _view.findViewById(R.id.layout_order)

        layout_orderNote.setOnClickListener {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.custom_order_note)

            val et_note = dialog.findViewById<EditText>(R.id.et_note)
            val txt_counter = dialog.findViewById<TextView>(R.id.txt_counter)
            val btn_save = dialog.findViewById<Button>(R.id.btn_save)
            val btn_cancel = dialog.findViewById<Button>(R.id.btn_cancel)

            et_note.setSelection(et_note.text.toString().length)
            txt_counter.text = et_note.length().toString() + ""
            et_note.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    txt_counter.text = et_note.length().toString() + ""
                }

                override fun afterTextChanged(s: Editable) {

                }

            })

            btn_save.setOnClickListener { dialog.dismiss() }
            btn_cancel.setOnClickListener { dialog.dismiss() }
        }
        return _view
    }

}
