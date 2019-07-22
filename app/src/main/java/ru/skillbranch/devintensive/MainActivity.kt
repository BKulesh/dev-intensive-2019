package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.models.Bender
import java.security.cert.LDAPCertStoreParameters

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var benderIamge: ImageView
    lateinit var textTxt: TextView
    lateinit var messageEt: EditText
    lateinit var sendBtn:ImageView
    lateinit var benderObj:Bender
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        benderIamge=iv_bender
        textTxt=tv_text
        messageEt=et_message
        sendBtn=iv_send

        val status=savedInstanceState?.getString("STATUS")?:Bender.Status.NORMAL.name
        val question=savedInstanceState?.getString("QUESTION")?:Bender.Question.NAME.name
        val message=savedInstanceState?.getString("MESSAGE")?:""

        messageEt.setText(message)
        benderObj= Bender(Bender.Status.valueOf(status),Bender.Question.valueOf(question))

        val (r,g,b)=benderObj.status.color
        benderIamge.setColorFilter(Color.rgb(r,g,b),PorterDuff.Mode.MULTIPLY)

        Log.d("M_MainActivity","onCreate $status $question")

        textTxt.text=benderObj.askQuestion()
        sendBtn.setOnClickListener(this)


    }

    override fun onRestart(){
        super.onRestart()
        Log.d("M_MainActivity","onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("M_MainActivity","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("M_MainActivity","onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("M_MainActivity","onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("M_MainActivity","onPause")
    }

    override fun onClick(v: View?){
        if (v?.id==R.id.iv_send){
        val (phrase,color)=benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
            messageEt.setText("")
            textTxt.text=phrase
            val (r,g,b)=color
            benderIamge.setColorFilter(Color.rgb(r,g,b),PorterDuff.Mode.MULTIPLY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("STATUS",benderObj.status.name)
        outState?.putString("QUESTION",benderObj.question.name)
        outState?.putString("MESSAGE",messageEt.text.toString())
        Log.d("M_MainActivity","onSaveInstanceState ${benderObj.status.name} ${benderObj.question.name} ${messageEt.text.toString()}")
    }
}
