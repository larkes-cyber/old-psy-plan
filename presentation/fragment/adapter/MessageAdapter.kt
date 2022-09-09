package lolka.example.PsyPath.presentation.fragment.adapter

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import lolka.example.PsyPath.R
import lolka.example.PsyPath.databinding.FragmentMessageBinding
import lolka.example.PsyPath.presentation.fragment.MessageFragment

 class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageHolder>() {
     val messageList = ArrayList<MessageModel>()

    class MessageHolder(item: View):RecyclerView.ViewHolder(item){
        val binding = FragmentMessageBinding.bind(item)
        fun bind(message:MessageModel){
            binding.text.text = message.message
            binding.text.setBackgroundResource(if (message.whose == 0) R.drawable.message else R.drawable.message_other)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                weight = 1.0f
                gravity = if (message.whose == 0) Gravity.RIGHT else Gravity.LEFT
            }
            binding.text.layoutParams = params
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_message, parent, false)
         return MessageHolder(view)
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bind(messageList[position])
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
     fun addMessage(message: MessageModel){
         messageList.add(message)
         notifyDataSetChanged()
     }


}