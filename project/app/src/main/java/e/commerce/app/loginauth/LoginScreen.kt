package e.commerce.app.loginauth

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import e.commerce.app.R
import e.commerce.app.screen.navigations.Screens
import e.commerce.app.ui.theme.Purple700
import e.commerce.app.utils.isntNull


@Composable

fun LoginScreen ( navController: NavController) {

    // declare variables
    var onMain = false
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val email = remember {  mutableStateOf("") }
    val password = remember {  mutableStateOf("") }

    //Alert
    val showDialog = remember { mutableStateOf(false) }

    var auth: FirebaseAuth = Firebase.auth

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val mContext = LocalContext.current

        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.log_ins), contentDescription = "Login Icon")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Sign in to your account", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = "Email") },
            value = email.value,
            onValueChange = { email.value = it},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ), keyboardActions =  KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}
            )

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            label = { Text(text = "Password") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {password.value = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ), keyboardActions =  KeyboardActions(
                onNext = { focusManager.clearFocus()}

            )
        )



        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {
                    if (email.value.isntNull() && password.value.isntNull()) {
                            auth.signInWithEmailAndPassword(email.value, password.value)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("login", "signInWithEmail:success")
                                        val user = auth.currentUser
                                        if (!onMain) {
                                            navController.navigate("home_screen")
                                            onMain = true
                                        }

                                    } else {
                                        Log.w("login", "signInWithEmail:failure", it.exception)
                                        Toast.makeText(
                                            mContext,
                                            "Unsuccessful login!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            Log.d(TAG, "Invalid email")
                            return@Button
                        }
                },content = { Text(text = "Login") },
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("Forgot password?"),
            onClick = { navController.navigate(route = Screens.ResetP.route)},
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default
            )
        )
    }




    Box(modifier = Modifier.fillMaxSize()) {


        ClickableText(
            text = AnnotatedString("Don't have an account ? Create"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            onClick = { navController.navigate(route = Screens.SignUp.route) },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple700
            )
        )

    }




}



@Composable
@Preview(showBackground = true)
fun LoginScreenView(){
    LoginScreen(navController = rememberNavController())
}
