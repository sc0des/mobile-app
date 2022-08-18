package e.commerce.app.products

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

fun ProductDetailScreen ( navController: NavController) {


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
                text = "Product Preview",
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
            painter = painterResource(R.drawable.drawing_tools), contentDescription = "product",
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .size(300.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))


        Column(
            modifier = Modifier.padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Drawing Tools Set",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp),
                color = Color.DarkGray)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Deluxe set of 48 paint colors and 8 brushes! Light up your canvas or any other surface and get your imagination running with Ohuhu.With these high-quality paints, your work will always look great",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp),
                color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                "$ 2.64",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp),
                color = Color.DarkGray)

        }

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(onClick = {   }, content = { Text(text = "Add to cart") },shape = RoundedCornerShape(28.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            )


        }
    }
}



@Composable
@Preview(showBackground = true)
fun ProductDetailScreenView(){
    ProductDetailScreen(navController = rememberNavController())
}
