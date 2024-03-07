package gr.gkortsaridis.mobilecomputingdemolab04

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import gr.gkortsaridis.mobilecomputingdemolab04.databinding.ContactItemViewBinding

class ContactListAdapter(
    private val contacts: List<ContactItem>
): ListAdapter<ContactItem, ContactListAdapter.ContactViewHolder>(RowItemDiffCallback()) {

    override fun getItemCount() = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    class ContactViewHolder private constructor(private val binding: ContactItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): ContactViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContactItemViewBinding.inflate(layoutInflater, parent, false)
                return ContactViewHolder(binding)
            }
        }

        fun bind(contactItem: ContactItem) {
            binding.contactName.text = contactItem.name
            binding.contactPhone.text = contactItem.telephone
        }
    }
}

class RowItemDiffCallback : DiffUtil.ItemCallback<ContactItem>() {
    override fun areItemsTheSame(oldItem: ContactItem, newItem: ContactItem): Boolean { return oldItem == newItem }
    override fun areContentsTheSame(oldItem: ContactItem, newItem: ContactItem): Boolean { return oldItem == newItem }
}