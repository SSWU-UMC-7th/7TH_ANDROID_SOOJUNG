package com.example.notepadapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notepadapp.databinding.ActivityMainBinding
import com.example.notepadapp.ui.theme.NotepadAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var temporaryNote: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java).apply {
                putExtra("note", binding.etNote.text.toString())
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        temporaryNote?.let {
            binding.etNote.setText(it)
        }
    }

    override fun onPause() {
        super.onPause()
        temporaryNote = binding.etNote.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this).apply {
            setTitle("메모 계속 작성")
            setMessage("이전에 작성하던 메모를 계속 작성하시겠습니까?")
            setPositiveButton("계속하기") { dialog, _ ->
                dialog.dismiss()
            }
            setNegativeButton("삭제하기") { dialog, _ ->
                temporaryNote = null
                binding.etNote.text.clear()
                dialog.dismiss()
            }
            show()
        }
    }
}