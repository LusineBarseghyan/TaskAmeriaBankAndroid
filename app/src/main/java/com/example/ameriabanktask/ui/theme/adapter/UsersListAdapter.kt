package com.example.ameriabanktask.ui.theme.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ameriabanktask.data.UserDto
import com.example.ameriabanktask.databinding.ItemUsersDataBinding

class UsersListAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<UsersListAdapter.UsersViewHolder>() {
    private lateinit var inflater: LayoutInflater
    private lateinit var context: Context
    private val items: MutableList<UserDto> = mutableListOf()


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        context = recyclerView.context
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(ItemUsersDataBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(item:List<UserDto>?) {
        items.clear()
        item?.let {
            items.addAll(item)
        }
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class UsersViewHolder(private val binding: ItemUsersDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.nextButton.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    onClick.invoke()
                    notifyDataSetChanged()
                }
            }
        }

        fun bind(item: UserDto) {
            binding.userId.text = item.id.toString()
            Glide.with(context).load(item.avatarUrl).into(binding.circleImageView)
            binding.login.text = item.login
        }
    }
}