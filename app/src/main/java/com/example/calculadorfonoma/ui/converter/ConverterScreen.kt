package com.example.calculadorfonoma.ui.converter


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadorfonoma.R
import com.example.calculadorfonoma.common.ScreenStateProducts


@Composable
fun ConverterRoute(viewModel: ConverterViewModel)
{
    val ratesState by viewModel.rates.observeAsState(initial = null)

    println("run Main Scrren")


    val onCurrencyTypeIn = { currency: String ->
        viewModel.onChangerCurrencyIn(currency)
    }

    val onCurrencyTypeOut = { currency: String ->
        viewModel.onChangerCurrencyOut(currency)
    }

    val onCurrencyValue = { value: String ->
        viewModel.onChangerValue(value)
    }

    val onConvertClicked = {
        viewModel.getRates()
    }

    ConverterScreen(
        onConvertClicked = onConvertClicked,
        onCurrencyValue = onCurrencyValue,
        onCurrencyTypeIn = onCurrencyTypeIn,
        onCurrencyTypeOut = onCurrencyTypeOut,
        ratesState = ratesState,
    )

}

@Composable
fun ConverterScreen(onConvertClicked: () -> Unit,
                    ratesState: Double?,
                    onCurrencyTypeIn: (String) -> Unit,
                    onCurrencyTypeOut: (String) -> Unit,
                    onCurrencyValue: (String) -> Unit)
{


            println("sesssefull")
         SuccessScreen(onConvertClicked, onCurrencyTypeIn, onCurrencyTypeOut, onCurrencyValue, ratesState)






}




@Composable
fun SuccessScreen(onConvertClicked: () -> Unit,
                  onCurrencyTypeIn: (String) -> Unit,
                  onCurrencyTypeOut: (String) -> Unit,
                  onCurrencyValue: (String) -> Unit,
                  ratesState: Double?)
{

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 25.dp),
            text = "Currency Converter",
        )

        CardIn(onCurrencyTypeIn, onCurrencyValue)

        Icon(
            modifier = Modifier
                .padding(25.dp)
                .size(40.dp)
                .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(30.dp))
                .align(Alignment.CenterHorizontally)
                .alpha(0.6f),
            painter = painterResource(id = R.drawable.baseline_currency_exchange_24),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = "",
        )

        CardOut(onCurrencyTypeOut, ratesState)

        Box(modifier = Modifier.fillMaxSize()) {
            Button(modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 40.dp),
                   onClick =  onConvertClicked ) {
                Text(text = "CONVERT")
            }
        }
    }
}

@Composable
private fun CardIn(onCurrencyTypeIn: (String) -> Unit, onCurrencyValue: (String) -> Unit)
{

 //   var numberCurrency by remember { mutableStateOf("") }



    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.elevatedCardColors(disabledContainerColor = MaterialTheme.colorScheme.surfaceTint),
        shape = RoundedCornerShape(20.dp),
    ) {

        Text(
            text = "Selct your currentcy type",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp),
        )


        ThemedTaskMenu(onCurrencyTypeIn)

        Text(
            text = "Enter your currentcy",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, start = 16.dp),
        )

        Row() {

            Text(text = "$", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp))

            TextFieldCost(true, onCurrencyValue, null)
        }
    }
}


@Composable
private fun CardOut(onCurrencyTypeOut: (String) -> Unit, ratesState: Double?)
{




    var numberCurrency by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.padding(8.dp),

        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.elevatedCardColors(disabledContainerColor = MaterialTheme.colorScheme.surfaceTint),

        shape = RoundedCornerShape(20.dp),
    ) {


        Text(
            text = "Selct your currentcy type",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp),
        )


        ThemedTaskMenu(onCurrencyTypeOut)

        Text(
            text = "Your converted currentcy",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, start = 16.dp),
        )

        Row() {

            Text(text = "$", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp))

            TextFieldCost(false, {},ratesState)
        }
    }


}




