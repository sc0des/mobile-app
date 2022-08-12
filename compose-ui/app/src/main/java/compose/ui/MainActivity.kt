package compose.ui

import android.accounts.AuthenticatorDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import compose.ui.ui.theme.Compose_uiTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                ImageCard(ImageDetails("Wales,United Kingdom", "Amy Turner", camera_name = "Camera"
                ,camera_n = "Nikon D3200",aperture="Aperture", aperture_v = "f/5.0",focal_length="Focal Length" , focal_length_v = "18.0mm",
                    shutter = "Shutter Speed", shutter_v = "1/125s", iso = "ISO    ", iso_v = "100", dim = "Dimensions" , dim_v =  "3906 x 4882", view = "Views", view_v = "8.8M",
                    downloads = "Downloads" , downloads_v = "99.1K", likes = "Likes", likes_v = "1.8K", wales_b = "wales", uk_b = "united kingdom"
                    ))
        }
    }

}

data class ImageDetails(val place: String, val profile_name: String,val camera_name: String,val camera_n: String,
                        val aperture: String,val aperture_v: String,val focal_length: String,val focal_length_v: String,
                        val shutter: String,val shutter_v: String,val iso: String,val iso_v: String,
                        val dim: String,val dim_v: String,val view: String,val view_v: String,val downloads: String,val downloads_v: String,
                        val likes: String,val likes_v: String,val wales_b: String,val uk_b: String,
                        )

@Composable
fun ImageCard(msg: ImageDetails) {


    Column  {
        // Location Pin
        Row( verticalAlignment = Alignment.CenterVertically){

                    Box (contentAlignment = Alignment.BottomStart){
                        Image(
                            painter = painterResource(R.drawable.wales),
                            contentDescription = "Location picture",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        val textPadding = 10.dp
                        run {
                            androidx.compose.foundation.layout.Row(
                                modifier = androidx.compose.ui.Modifier.padding(textPadding)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_baseline_location_on_24),
                                    contentDescription = "Location Pin",
                                    )
                                // Location Text
                                Text(
                                    text = msg.place,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )

                            }
                        }
                }
        }


        // Add padding around row
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(all = 12.dp)) {

            Image(
                painter = painterResource(R.drawable.pic__2_),
                contentDescription = "profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(50.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(12.dp))

            Column (modifier = Modifier.padding(all = 10.dp)) {
                Text(text = msg.profile_name,color = Color.White, fontWeight = FontWeight.Bold)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(6.dp))
            }

            // Add a horizontal space between the image and
            // the column
            Spacer(modifier = Modifier.width(65.dp))
            Button(onClick = {}, modifier = Modifier.size(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                Image(
                    painter = painterResource(R.drawable.ic_baseline_save_alt_24),
                    contentDescription = "Save"
                )
            }

            // Add a horizontal space between the image and the column
            Button(onClick = {}, modifier = Modifier.size(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                Image(
                    painter = painterResource(R.drawable.ic_baseline_favorite_border_24),
                    contentDescription = "Save"
                )
            }
            // Add a horizontal space between the image and the column

            Button(onClick = {}, modifier = Modifier.size(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)) {
                Image(
                    painter = painterResource(R.drawable.ic_baseline_bookmark_border_24),
                    contentDescription = "Save"
                )
            }
        }

        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth()
        )

        // Table layout
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Spacer(modifier = Modifier.height(8.dp))
            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts
                Text(text = msg.camera_name,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.camera_n,color = Color.White)
            }

            // Add a horizontal space between 2 columns
            Spacer(modifier = Modifier.width(50.dp))

            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts

                Spacer(modifier = Modifier.height(5.dp))

            }

            // Add a horizontal space between 2 columns
            Spacer(modifier = Modifier.width(80.dp))

            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts

                Text(text = msg.aperture,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.aperture_v,color = Color.White)
            }
        }

        // Table layout
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Spacer(modifier = Modifier.height(8.dp))
            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts
                Text(text = msg.focal_length,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.focal_length_v,color = Color.White)
            }

            // Add a horizontal space between 2 columns
            Spacer(modifier = Modifier.width(50.dp))

            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts

                Spacer(modifier = Modifier.height(5.dp))

            }

            // Add a horizontal space between 2 columns
            Spacer(modifier = Modifier.width(80.dp))

            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts

                Text(text = msg.shutter,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.shutter_v,color = Color.White)
            }
        }

        // Table layout
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Spacer(modifier = Modifier.height(8.dp))
            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts
                Text(text = msg.iso,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.iso_v,color = Color.White)
            }

            // Add a horizontal space between 2 columns
            Spacer(modifier = Modifier.width(95.dp))

            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts

                Spacer(modifier = Modifier.height(5.dp))

            }

            // Add a horizontal space between 2 columns
            Spacer(modifier = Modifier.width(80.dp))

            Column (modifier = Modifier.padding(all = 8.dp)) {
                // Add a vertical space between the author and message texts

                Text(text = msg.dim,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.dim_v,color = Color.White)
            }
        }



        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth()
        )


        Row(modifier = Modifier.padding(all = 10.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.width(35.dp))
            Column {
                // Add a vertical space between the author and message texts
                Text(text = msg.view,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.view_v,color = Color.White)
            }

            Spacer(modifier = Modifier.width(70.dp))

            Column {
                // Add a vertical space between the author and message texts
                Text(text = msg.downloads,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.downloads_v,color = Color.White)
            }

            Spacer(modifier = Modifier.width(70.dp))
            Column {
                // Add a vertical space between the author and message texts
                Text(text = msg.likes,color = Color.White,fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = msg.likes_v,color = Color.White)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(15.dp))

        Row(modifier = Modifier.padding(all = 10.dp)) {
            Column() {
                Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                    Text(text = msg.wales_b, color = Color.White)
                }

            }

            Spacer(modifier = Modifier.width(15.dp))

            Column() {
                Button(onClick = {}, shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)) {
                    Text(text = msg.uk_b,color = Color.White)
                }

            }

        }


    }

}

@Preview
@Composable
fun PreviewImageCard() {
    ImageCard(
        msg = ImageDetails("Wales,United Kingdom", "Amy Turner", camera_name = "Camera",
                            camera_n = "Nikon D3200",aperture="Aperture", aperture_v = "f/5.0",focal_length="Focal Length" , focal_length_v = "18.0mm",
                            shutter = "Shutter Speed", shutter_v = "1/125s", iso = "iso", iso_v = "100", dim = "Dimensions" , dim_v =  "3906 x 4882" ,  view = "Views", view_v = "8.8M",
                            downloads = "Downloads" , downloads_v = "99.1K", likes = "Likes", likes_v = "1.8K", wales_b = "wales", uk_b = "united kingdom")
    )
}


