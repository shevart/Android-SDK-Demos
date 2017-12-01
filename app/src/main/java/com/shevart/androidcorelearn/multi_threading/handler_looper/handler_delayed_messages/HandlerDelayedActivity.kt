package com.shevart.androidcorelearn.multi_threading.handler_looper.handler_delayed_messages

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.SeekBar
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import com.shevart.androidcorelearn.utils.UiNotificationsUtils
import kotlinx.android.synthetic.main.activity_handler_delayed.*
import java.util.*

class HandlerDelayedActivity : AbsActivity() {
    private var uiHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_delayed)
        enableToolbarBackButton()
        initViews()

        uiHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                if (msg.what == PRINT_DELAYED_MESSAGE_WHAT) {
                    printDelayedMessage(msg.obj as String)
                } else {
                    super.handleMessage(msg)
                }
            }
        }
    }

    private fun initViews() {
        btSendMessageWithDelay.setOnClickListener { sendDelayedMessage() }

        sbDelayInSeconds.max = 5 // 5 sec is max value
        sbDelayInSeconds.progress = 2
        sbDelayInSeconds.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tvCurrentDelayInSecs!!.text = String.format(Locale.ENGLISH, DELAY_TIME_PATTERN, progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }

    private fun sendDelayedMessage() {
        val message = uiHandler!!.obtainMessage(PRINT_DELAYED_MESSAGE_WHAT, etDelayedMsg.text.toString())
        uiHandler!!.sendMessageDelayed(message, (sbDelayInSeconds.progress * 1000).toLong())
    }

    private fun printDelayedMessage(msg: String) {
        UiNotificationsUtils.showToast(this, msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        uiHandler!!.removeCallbacksAndMessages(null) // remove all messages in queue
    }

    companion object {
        private val PRINT_DELAYED_MESSAGE_WHAT = 1
        private val DELAY_TIME_PATTERN = "%d sec"
    }
}