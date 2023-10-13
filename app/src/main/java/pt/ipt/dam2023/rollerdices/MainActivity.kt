package pt.ipt.dam2023.rollerdices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // preparar a minha app para reagir ao 'clique' do botão
        findViewById<Button>(R.id.button).setOnClickListener {
            lancaDado()
        }
    }

    /**
     * gerar um novo número para representar o dado
     */
    private fun lancaDado() {
        // 'ponteiro' para a TextView
        val txt = findViewById<TextView>(R.id.textView)

        // gerar um nº aleatório, entre 1 e 6
        val novoNumAleatorio = Random().nextInt(6) + 1

        // avisar o utilizador que o num. gerado é igual ao que existia
        if (txt.text == novoNumAleatorio.toString())
            Toast.makeText(
                this,
                getString(R.string.toastText),
                Toast.LENGTH_LONG
            ).show()

        // alterar o texto da TextView com esse valor
        txt.text = novoNumAleatorio.toString()

        // alterar a imagem do dado, para refletir esta alteração
        //    - criar o ponteiro para a ImageView
        val image = findViewById<ImageView>(R.id.imageView)
        //    - determinar a imagem (recurso) a associar à ImageView
        val recursoAMostrarNoDado = when (novoNumAleatorio) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        //     - associar o recurso à ImageView
        image.setImageResource(recursoAMostrarNoDado)


    }


}