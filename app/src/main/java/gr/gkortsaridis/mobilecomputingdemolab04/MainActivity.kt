package gr.gkortsaridis.mobilecomputingdemolab04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import gr.gkortsaridis.mobilecomputingdemolab04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contacts = List(50) { ContactItem() }
        binding.dataRv.layoutManager = LinearLayoutManager(this)

        binding.dataRv.adapter = ContactListAdapter(contacts)
    }
}