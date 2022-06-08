package science.example.week6handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(Fragment1.newInstance(), R.id.fragment1)
        openFragment(Fragment2.newInstance(), R.id.fragment2)
        setContentView(R.layout.activity_main)
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

}

//Handler используется для работы с очередью сообщений, связанной с потоками
//Он позволяет отправлять сообщения в другие потоки(с задержкой или без),
//а так же обрабатывать полученные сообщения.

//Работа: Handler отправляет сообщение (Message) в очередь сообщений (MessageQueue),
//Looper непрерывно получает добавленные сообщения из очереди сообщений в бесконечном цылке,
//а затем доставляет их обработчику.

