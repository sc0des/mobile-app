package e.commerce.app.user.profile


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

fun UserProfileScreen ( navController: NavController) {



    Box(Modifier.verticalScroll(rememberScrollState())) {

        Image(painter = painterResource(id = R.drawable.pastel_purple_color_solid_background_1920x1080),
            contentDescription = "Header Background", contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp))
        Column {
            // Top appbar
            TopAppbarProfile(context = LocalContext.current.applicationContext,navController)
            ProfileContent()
        }
    }
}


@Composable
fun TopAppbarProfile(context: Context,navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
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
fun ProfileContent() {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(R.drawable.woman), contentDescription = "profile",
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .size(150.dp)
        )
        Text(
            "User Name",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp),
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(15.dp))


        Column(
            modifier = Modifier.padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "settings",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(55.dp)
                )
                Text(
                    "Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    color = Color.DarkGray
                )

                Image(
                    painter = painterResource(R.drawable.home_2),
                    contentDescription = "Address",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(55.dp)
                )
                Text(
                    "Saved Addresses",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp) ,
                    color = Color.DarkGray
                )


                Image(
                    painter = painterResource(R.drawable.wishlist2),
                    contentDescription = "Order History",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(55.dp)
                )
                Text(
                    "Order History",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    color = Color.DarkGray
                )
                Image(
                    painter = painterResource(R.drawable.call_center),
                    contentDescription = "help",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(55.dp)
                )
                Text(
                    "Help",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp),
                    color = Color.DarkGray
                )

            }
        }
    }



@Composable
@Preview(showBackground = true)
fun UserProfileScreenView(){
    UserProfileScreen(navController = rememberNavController())
}
