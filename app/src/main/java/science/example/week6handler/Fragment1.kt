package science.example.week6handler

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import science.example.week6handler.databinding.Fragment1Binding
import java.math.BigDecimal


class Fragment1 : Fragment() {

    lateinit var binding: Fragment1Binding
    private var answer: String = ""
    private var counter: Double = 0.0
    private var number: Int = 0
    private var y : BigDecimal = BigDecimal(4)
    private var x: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)

        val runnable = Runnable {
            Thread {
                while (true) {
                    counter ++
                    if (number%2 == 0) {
                        y -= (BigDecimal(4).divide(BigDecimal(x+2),300,0))
                        answer = y.toString()
                    } else {
                        y += (BigDecimal(4).divide(BigDecimal(x+2),300,0))
                        answer = y.toString()
                    }
                    x += 2
                    if (counter % 1000 == 0.0) {
                        val message = handler.obtainMessage()
                        message.obj = answer
                        handler.sendMessage(message)
                    }
                    number++
                }
            }.start()
        }
        val thread = Thread(runnable)
        thread.start()
       return binding.root
    }

    private var handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            binding.textPi.text = msg.obj.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}