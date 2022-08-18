package e.commerce.app


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import e.commerce.app.screen.navigations.Screens


@Composable

fun HomeScreen (navController: NavController) {

   Box(Modifier.verticalScroll(rememberScrollState())) {

       Image(painter = painterResource(id = R.drawable.pastel_purple_color_solid_background_1920x1080),
           contentDescription = "Header Background", contentScale = ContentScale.FillWidth,
           modifier = Modifier
               .fillMaxWidth()
               .offset(0.dp, (-30).dp))
            Column {
                AppBar(navController)
                ProductView(navController)
                Content(navController)
            }
        }
    }

@Composable
fun AppBar(navController: NavController) {
    Row(
        Modifier
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search for anything unique", fontSize = 12.sp) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { navController.navigate(route = Screens.Users.route) }) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "favorites", tint = Color.White)
        }
        IconButton(onClick = { navController.navigate(route = Screens.Users.route)}) {
            Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "shopping_cart", tint = Color.White)
        }
        IconButton(onClick = {navController.navigate(route = Screens.Users.route)}) {
            Icon(imageVector = Icons.Outlined.AccountBox, contentDescription = "user_profile", tint = Color.White)
        }
    }
}


@Composable
fun ProductView(navController: NavController) {
    
    Column() {
        
    }
    
    
    
    
    
    
}

@Composable
fun Content(navController: NavController) {
    Column() {
        CategorySection( navController )
        Spacer(modifier = Modifier.height(16.dp))
        NewCollectionSection(navController)
        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun CategorySection( navController: NavController) {
    Spacer(modifier = Modifier.height(16.dp))
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Categories", style = MaterialTheme.typography.h6)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryButton( 
                text = "DIY",
                icon = painterResource(id = R.drawable.art),
                backgroundColor = Color.White ,
                navController = navController
            )
            CategoryButton(
                text = "Handmade",
                icon = painterResource(id = R.drawable.handmade),
                backgroundColor = Color.White,
                navController = navController


            )
            CategoryButton(
                text = "Art",
                icon = painterResource(id = R.drawable.artp),
                backgroundColor = Color.White,
                navController = navController
            )
            CategoryButton(
                text = "Book",
                icon = painterResource(id = R.drawable.book),
                backgroundColor = Color.White,navController = navController
            )

        }
    }
}

@Composable
fun CategoryButton(
    text: String = "",
    icon: Painter,
    backgroundColor: Color,
    navController: NavController
    
) {
    Column(
        Modifier
            .width(72.dp)
            .clickable {  }
    ) {
        Box(
            Modifier
                .size(72.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(18.dp)
        ) {
            Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

@Composable
fun NewCollectionSection(navController: NavController) {
    Column() {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "New Collection", style = MaterialTheme.typography.h6)
            TextButton(onClick = {}) {
                Text(text = "More", color = MaterialTheme.colors.primary)
            }
        }

        NewCollectionItem(navController)
    }
}

@Composable
fun NewCollectionItem(navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

    ) {
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.balloon),
                title = "Balloon",
                price = "1.99",
                navController = navController
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.drawing_tools),
                title = "Drawing tools",
                price = "2.64",
                navController = navController
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.paint),
                title = "Artistic Kit ",
                price = "4.76",
                navController = navController
            )
        }
    }

    Spacer(modifier = Modifier.height(15.dp))

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.party),
                title = "Party Set",
                price = "3.99",
                navController = navController
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.drink),
                title = "Handmade Mugs",
                price = "2.64",
                navController = navController
            )
        }
        item {
            BestSellerItem(
                imagePainter = painterResource(id = R.drawable.flowers),
                title = "Vase ",
                price = "4.76",
                navController = navController

                )
        }
    }
}

@Composable
fun BestSellerItem(
    title: String = "",
    price: String = "",
    imagePainter: Painter,
    navController: NavController
) {
    Card(
        Modifier
            .width(160.dp)
            .clickable { navController.navigate(route = Screens.Product.route)

            }
    ) {
        Column(
            Modifier
                .padding(bottom = 32.dp)
        ) {
            Image(
                painter = imagePainter, contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable { navController.navigate(route = Screens.Product.route) },
                contentScale = ContentScale.Fit
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold)

            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenView(){
    HomeScreen(navController = rememberNavController())
}


