package e.commerce.app.shop

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import e.commerce.app.R
import e.commerce.app.screen.navigations.Screens

@Composable

fun CartScreen ( navController: NavController) {


    Box(Modifier.verticalScroll(rememberScrollState())) {

        Image(painter = painterResource(id = R.drawable.pastel_purple_color_solid_background_1920x1080),
            contentDescription = "Header Background", contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp))
        Column {
            // Top appbar
            TopAppbarProfile(context = LocalContext.current.applicationContext,navController)

        }
    }
}


@Composable
fun TopAppbarProfile(context: Context,navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Cart",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { navController.navigate(route = Screens.Home.route) }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Go back",
                )
            }
        }
    )
}




@Composable
@Preview(showBackground = true)
fun CartScreenView(){
    CartScreen(navController = rememberNavController())
}
