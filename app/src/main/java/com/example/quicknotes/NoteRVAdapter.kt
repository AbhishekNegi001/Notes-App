package com.example.quicknotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context: Context, private val listener: MainActivity): RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {
    private val allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.title)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
    }
    //to create the items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }
    //to bind the data with item
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }
    //gives the count of items in list
    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()//to update the recycler view
    }
}

//to handle clicks
interface InterfaceNoteRVAdapter{
    fun onItemClicked(note: Note)
}