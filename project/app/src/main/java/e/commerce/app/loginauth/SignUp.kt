package e.commerce.app.loginauth




import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import e.commerce.app.ui.theme.Purple1






@Composable

fun SignUpScreen (navController: NavController) {

    // declare variables
    var onLogin = false
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val focusManager = LocalFocusManager.current

    val name = rememberSaveable{ mutableStateOf("") } // to save name
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    val isEmailValid by derivedStateOf {
        Patterns.EMAIL_ADDRESS.matcher(email.value).matches()
    }

    val nameErrorState = remember { mutableStateOf(false) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val confirmPasswordErrorState = remember { mutableStateOf(false) }


    // firebase
    val auth: FirebaseAuth = Firebase.auth

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Create account", style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                label = { Text(text = "Name*") },
                value = name.value,
                onValueChange = {
                    if (nameErrorState.value) {
                        nameErrorState.value = false
                    }
                    name.value = it
                }, modifier = Modifier.fillMaxWidth(),
                isError = nameErrorState.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii,
                    imeAction = ImeAction.Next ), keyboardActions =  KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down)})

            )

            if (nameErrorState.value) {
                Text(text = "Required", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                label = { Text(text = "Email*") },
                value = email.value,
                onValueChange = { email.value = it},modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next ), keyboardActions =  KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down)}),
                isError = emailErrorState.value,
                trailingIcon = {
                    if (email.value.isNotBlank()) {
                        IconButton(onClick = { email.value = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear email"
                            )

                        }
                    }
                }
            )
            if (emailErrorState.value && isEmailValid) {
                Text(text = "Required", color = Color.Red)
            }


            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                label = { Text(text = "Password*") },
                value = password.value,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {
                    if (passwordErrorState.value) {
                        passwordErrorState.value = false
                    }
                    password.value = it
                }, modifier = Modifier.fillMaxWidth(), isError = passwordErrorState.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next ), keyboardActions =  KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down)})
            )
            if (passwordErrorState.value) {
                Text(text = "Required", color = Color.Red)
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                label = { Text(text = "Confirm Password*") },
                value = confirmPassword.value,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {
                    if (confirmPasswordErrorState.value) {
                        passwordErrorState.value = false
                    }
                    confirmPassword.value = it
                }, modifier = Modifier.fillMaxWidth(), isError = confirmPasswordErrorState.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next ), keyboardActions =  KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down)})
            )
            if (confirmPasswordErrorState.value) {
                Text(text = "Required", color = Color.Red)

                if (confirmPasswordErrorState.value) {
                    val msg = if (confirmPassword.value.isEmpty()) {
                        "Required"
                    } else if (confirmPassword.value != password.value) {
                        "Password not matching"
                    } else {
                        ""
                    }
                    Text(text = msg, color = Color.Red)
                }
            }

            Spacer(Modifier.size(35.dp))


            Button(
                onClick = {
                    if (!( name.value == "" || email.value == "" || password.value == "" || confirmPassword.value == "")) {
                        auth.createUserWithEmailAndPassword(email.value, password.value)
                            .addOnSuccessListener{
                                if (!onLogin){
                                    navController.navigate("login_screen")
                                    onLogin = true
                                    // Successful register
                                    Log.d("login", "signInWithEmail:success")
                                                                }
                                else {
                                    Log.w("register", "registerWithEmail:failure")
                                    Toast.makeText(context, "user already exist!", Toast.LENGTH_SHORT).show()
                                }
                            }

                    }
                }, content = { Text(text = "Register") },
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Purple1)
            )



            Spacer(Modifier.size(16.dp))

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

}





@Composable
@Preview(showBackground = true)
fun SignUpScreenView(){
    SignUpScreen(navController = rememberNavController())
}
