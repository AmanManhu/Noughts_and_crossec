package com.example.noughtsandcrossec

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noughtsandcrossec.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var counter = 0;
    private var player = 0;
    private var gameOver = false
    private var click = true
    private val lines = arrayOf(
        intArrayOf(0, 1, 2, 3),
        intArrayOf(4, 5, 6, 7),
        intArrayOf(8, 9, 10, 11),
        intArrayOf(12, 13, 14, 15),
        intArrayOf(0, 4, 8, 12),
        intArrayOf(1, 5, 9, 13),
        intArrayOf(2, 6, 10, 14),
        intArrayOf(3, 7, 11, 15),
        intArrayOf(0, 5, 10, 15),
        intArrayOf(3, 6, 9, 12),
        intArrayOf(2, 7, 12),
        intArrayOf(2, 7, 12),
        intArrayOf(5, 10, 15),
        intArrayOf(3, 6, 9),
        intArrayOf(8, 11, 14),
    )
    private val board = IntArray(16) { 0 }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(binding.root)
        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        binding.imageRestart.setOnClickListener {
            click = true
            updateCard()
            gameOver = false
            counter = 0
            player = 0
        }
        binding.card1.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            setImage(binding.card1)
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[0] = player
            click = false
            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card2.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            setImage(binding.card2)
            board[1] = player
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card3.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            setImage(binding.card3)
            board[2] = player
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card4.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            setImage(binding.card4)
            board[3] = player
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)
            }
        }
        binding.card5.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            setImage(binding.card5)
            board[4] = player
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card6.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            setImage(binding.card6)
            board[5] = player
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card7.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            setImage(binding.card7)
            board[6] = player
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card8.setOnClickListener {
            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[7] = player
            click = false

            setImage(binding.card8)
            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card9.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[8] = player
            setImage(binding.card9)
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card10.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[9] = player
            setImage(binding.card10)
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card11.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[10] = player
            setImage(binding.card11)
            click = false
            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card12.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[11] = player
            setImage(binding.card12)
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card13.setOnClickListener {

            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[12] = player
            setImage(binding.card13)
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card14.setOnClickListener {
            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[13] = player
            setImage(binding.card14)
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }

        }
        binding.card15.setOnClickListener {
            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[14] = player
            setImage(binding.card15)
            click = false

            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.card16.setOnClickListener {
            if (gameOver)
                return@setOnClickListener
            counter++
            var player = if (counter % 2 == 1) 1 else 2
            text(binding.tvPlayer1, binding.tvPlayer2, player)
            board[15] = player
            setImage(binding.card16)
            click = false
            if (check(player)) {
                Toast.makeText(this, "Игрок $player выиграл!!!", Toast.LENGTH_LONG).show()
                gameOver = true
                board.fill(0)

            }
        }
        binding.ivSetting.setOnClickListener {
            if (binding.cardViewStyle.visibility == View.VISIBLE){
                binding.cardViewStyle.visibility = View.GONE
            } else{
                binding.cardViewStyle.visibility = View.VISIBLE
            }

        }
       // setOnclickListener(binding.card1)
    }

    fun setImage(add: ImageView): ImageView {
        when (counter) {
            1 -> add.setImageResource(R.drawable.ic_krestik)
            2 -> add.setImageResource(R.drawable.ic_nolik)
            3 -> add.setImageResource(R.drawable.ic_krestik)
            4 -> add.setImageResource(R.drawable.ic_nolik)
            5 -> add.setImageResource(R.drawable.ic_krestik)
            6 -> add.setImageResource(R.drawable.ic_nolik)
            7 -> add.setImageResource(R.drawable.ic_krestik)
            8 -> add.setImageResource(R.drawable.ic_nolik)
            9 -> add.setImageResource(R.drawable.ic_krestik)
            10 -> add.setImageResource(R.drawable.ic_nolik)
            11 -> add.setImageResource(R.drawable.ic_krestik)
            12 -> add.setImageResource(R.drawable.ic_nolik)
            13 -> add.setImageResource(R.drawable.ic_krestik)
            14 -> add.setImageResource(R.drawable.ic_nolik)
            15 -> add.setImageResource(R.drawable.ic_krestik)
            16 -> add.setImageResource(R.drawable.ic_nolik)
        }
        return add
    }

    fun text(player1: TextView, player2: TextView, counter: Int) {
        if (counter % 2 ==1) {
            player1.text = "Player1"
            player2.text = "Your Hode"
        } else {
            player2.text = "Player2"
            player1.text = "Your Hode"
        }

    }

    fun check(player: Int): Boolean {
        for (line in lines) {
            var count = 0;
            for (index in line) {
                if (board[index] == player) {
                    count++
                    if (count == 3) return true
                } else {
                    count = 0
                }
            }
        }
        return false
    }

    fun updateCard() {
        binding.card1.setImageResource(R.drawable.ic_1)
        binding.card2.setImageResource(R.drawable.ic_1)
        binding.card3.setImageResource(R.drawable.ic_1)
        binding.card4.setImageResource(R.drawable.ic_1)
        binding.card5.setImageResource(R.drawable.ic_1)
        binding.card6.setImageResource(R.drawable.ic_1)
        binding.card7.setImageResource(R.drawable.ic_1)
        binding.card8.setImageResource(R.drawable.ic_1)
        binding.card9.setImageResource(R.drawable.ic_1)
        binding.card10.setImageResource(R.drawable.ic_1)
        binding.card11.setImageResource(R.drawable.ic_1)
        binding.card12.setImageResource(R.drawable.ic_1)
        binding.card13.setImageResource(R.drawable.ic_1)
        binding.card14.setImageResource(R.drawable.ic_1)
        binding.card15.setImageResource(R.drawable.ic_1)
        binding.card16.setImageResource(R.drawable.ic_1)
    }

}
//    fun setOnclickListener(view: View): View{
//        return view
//    }
//
//    }
