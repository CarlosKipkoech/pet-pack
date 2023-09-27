package com.example.jetpack1.screens

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack1.R

@Composable
fun TopBar(s: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = s, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged: (name: String) -> Unit
) {
    /** ensures that the value stored in currentValue persists
     * even when the composable is recomposed due to changes in
     * the UI hierarchy or other factors.*/

    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            onTextChanged(it)
            currentValue = it
        },
        placeholder = {
            Text(text = "Enter Your Name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions { localFocusManager.clearFocus() })

}

@Composable
fun TextComponent(
    textValue: String, textSize: TextUnit, colorValue: Color = Color.Black
) {

    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Composable
fun AnimalCard(image: Int, selected: Boolean, animalSelected: (animalName: String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(15.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        var animalName = if (image == R.drawable.cat) "cat" else "Dog"
                        animalSelected(animalName)
                    },
                painter = painterResource(id = image),
                contentDescription = "Pet Preview"
            )
        }


    }
}

@Preview(showBackground = false)
@Composable
fun AnimalCardPreview() {
    AnimalCard(R.drawable.cat, false, { "dog" })
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent("carlos", 24.sp)
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("Hi there")
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent(onTextChanged = {})
}
