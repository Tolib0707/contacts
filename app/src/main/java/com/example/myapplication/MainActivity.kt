

import android.media.Image
import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstproject.ui.theme.MyFirstProjectTheme

private va

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var counter: Int by remember {
        mutableIntStateOf(value = 0)
    }
    var isImageVisible by remember { mutableStateOf(true) }

    Box {
        Row {
            Column() {
                Text(
                    text = "Hello $name!",
                    modifier = modifier
                )
                if (isImageVisible) {
                    Image(
                        painterResource(R.drawable.__2026_02_17_203509),
                        contentDescription = null
                    )
                }
                Text(
                    text = "Последний Текст",
                    fontSize = 24.sp,
                    color = Color.Green,

                    )
                Row {
                    Button(
                        onClick = {
                            counter -= 1
                        }
                    ) { Text(text = "-") }
                    Text(

                        text = counter.toString(),
                        fontSize = 40.sp,
                        color = Color.Green
                    )
                    Button(
                        onClick = {
                            counter += 1
                        }
                    ) {
                        Text("+")
                    }
                    Button(
                        onClick = {
                            isImageVisible = !isImageVisible
                        }
                    ) { Text("Скрыть и показать/ Изображение") }
                }
                val textValues = remember { mutableStateListOf<String>() }

                var textFieldValue: String by remember {
                    mutableStateOf("")
                }
                [15.03.2026 9:22] : textValues.forEach { text ->
                Row {
                    Text(text)
                    Button(onClick = { textValues.remove(text) }) {
                        Icon(Icons.Default.Close, contentDescription = null)
                    }
                }
            }
                Row {
                    TextField(
                        value = textFieldValue,
                        onValueChange = { newText ->
                            textFieldValue = newText
                        }
                    )
                    Button(onClick = { textValues.add(textFieldValue) }) {
                        Text("Добавить в список")
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstProjectTheme {
        Greeting("Android")
    }
}