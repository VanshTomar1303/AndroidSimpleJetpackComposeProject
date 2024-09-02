package com.vansh.jetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vansh.jetpackcomposeproject.ui.theme.JetPackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeProjectTheme {
                var input by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
               Column(
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(16.dp)
               ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(22.dp)
                    ) {
                        OutlinedTextField(
                            value = input,
                            onValueChange = {
                                text -> input = text
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp)) // to give space b/w values
                        Button(onClick = {
                            if(input.isNotBlank()){
                                names += input
                                input = ""
                            }
                        }) {
                            Text(text = "ADD")
                        }
                    }
                   list(names = names, modifier = Modifier)
               }
            }
        }
    }
}
@Composable
fun list(names :List<String>,modifier: Modifier){
    LazyColumn(modifier){
        items(names) {
                currentName -> Text(
            text = currentName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
            HorizontalDivider()
        }
    }
}

/*
            var count by remember {
                    mutableIntStateOf(0)
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = count.toString(),
                        fontSize = 32.sp
                    )
                    Button(onClick = {
                        count++
                    }) {
                        Text(text = "Click me")
                    }
                }


                Click on button to increase values
 */

