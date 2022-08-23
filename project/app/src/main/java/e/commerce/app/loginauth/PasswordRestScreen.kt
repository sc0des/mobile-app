package e.commerce.app.loginauth

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import e.commerce.app.ui.theme.Purple1
import e.commerce.app.utils.isValidEmail


@Composable

fun PasswordRestScreen ( navController: NavController) {



    // declare variables
    val focusManager = LocalFocusManager.current
    val email = remember {  mutableStateOf("") }

    val firebasesAuth = FirebaseAuth.getInstance()

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val mContext = LocalContext.current
        Spacer(modifier = Modifier.height(85.dp))
        Text(text = "Forgot your Password ?", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Please enter your email to reset your password ", fontSize = 18.sp,
            textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = "Email") },
            value = email.value,
            onValueChange = { email.value = it},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ), keyboardActions =  KeyboardActions(
                onNext = { focusManager.clearFocus()}
            )
        )

        

        Spacer(modifier = Modifier.height(30.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(onClick = {
                
                if (email.value != "" ) {
                    
                    if(email.value.isValidEmail()){

                    firebasesAuth.sendPasswordResetEmail(email.value)
                        .addOnCompleteListener {
                             if(it.isSuccessful){
                                 Toast.makeText(mContext, "Please check your inbox", Toast.LENGTH_SHORT).show()

                             } else {
                                 Toast.makeText(mContext, "Error!", Toast.LENGTH_SHORT).show()
                                    }
                        }
                }}
            }, content = { Text(text = "Reset") },shape = RoundedCornerShape(28.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp),
            )


        }


        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = {
                navController.navigate("login_screen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }) {
                Text(text = "Login", color = Purple1)
            }
        }
    }
}




@Composable
@Preview(showBackground = true)
fun PasswordRestView(){
    PasswordRestScreen(navController = rememberNavController())
}