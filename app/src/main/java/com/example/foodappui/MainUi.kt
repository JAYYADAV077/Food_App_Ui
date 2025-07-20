package com.example.foodappui

import android.service.quickaccesswallet.GetWalletCardsError
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Splash(navController: NavController) {
    class NavItem(val label: String, val icon: ImageVector) {
    }

    val navList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Notification", Icons.Default.Search),
        NavItem("Settings", Icons.Default.ShoppingCart),
        NavItem("Settings", Icons.Default.Person)

    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = false,
                        onClick = { },
                        icon = {
                            Icon(
                                navItem.icon,
                                contentDescription = "",
                                tint = androidx.compose.ui.graphics.Color.Black,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    )
                }
            }
        }
    )
    { innerPadding ->
        MainUi(
            modifier = Modifier.padding(innerPadding),navController

        )

    } //
    
}

@Composable
fun MainUi(modifier: Modifier,navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFD0C9C9))
            .padding(12.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Icon(
                Icons.Default.Menu, null,
                Modifier.size(45.dp)
            )

            Icon(
                Icons.Default.Search, null,
                Modifier.size(45.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ) {
            Text(
                "Meal Magic",
                fontWeight = FontWeight.W900,
                fontSize = 25.sp,
                color = Color.Black,

                )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                "Welcome,Jay",
                fontWeight = FontWeight.W700,
                fontSize = 17.sp,
                color = Color.Black,

                )
            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    Icons.Default.LocationOn, null,
                    Modifier.size(20.dp)
                )

                Text(
                    " Indore",
                    fontWeight = FontWeight.W700,
                    fontSize = 17.sp,
                    color = Color.Black,

                    )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))


            LazyRow { items(list) { it -> Cards(card = it) } }


        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.bg),
            null,
            contentScale = ContentScale.Crop, // fit to height
            modifier = Modifier
                .height(229.2.dp)
                .clip(RoundedCornerShape(16.dp))

        )

        Spacer(modifier = Modifier.height(15.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                "Populars",
                fontWeight = FontWeight.W900,
                fontSize = 25.sp,
                color = Color.Black,
            )
        }


        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFDACECE))
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
                    .padding(10.dp)
                    .clickable{navController.navigate("Page")}


            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.momosa),
                        null,
                        modifier = Modifier.size(100.dp)
                    )
                    Row(

                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Schezwan Paneer\nMomos",
                            fontWeight = FontWeight.W900,
                            fontSize = 15.sp,
                            color = Color.Black,
                        )

                        Text(
                            "(4.8)",
                            fontWeight = FontWeight.W400,
                            fontSize = 11.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 10.dp)
                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Text(
                            "Rs.160",
                            fontWeight = FontWeight.W900,
                            fontSize = 20.sp,
                            color = Color.Black,

                            )


                        Box(
                            modifier = Modifier
                                .padding(start = 40.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFDACECE),
                                    shape = CircleShape
                                )


                        ) {
                            Icon(
                                Icons.Default.Add, null,
                                Modifier.size(30.dp),
                                tint = Green

                            )
                        }
                    }

                }


            } ///

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFDACECE))
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(30.dp))
                    .padding(10.dp)


            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bugers),
                        null,
                        modifier = Modifier.size(100.dp)
                    )
                    Row(

                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Veggies Cheese\nBurger",
                            fontWeight = FontWeight.W900,
                            fontSize = 15.sp,
                            color = Color.Black,
                        )

                        Text(
                            "(4.9)",
                            fontWeight = FontWeight.W400,
                            fontSize = 11.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 10.dp)
                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {
                        Text(
                            "Rs.120",
                            fontWeight = FontWeight.W900,
                            fontSize = 20.sp,
                            color = Color.Black,

                            )


                        Box(
                            modifier = Modifier
                                .padding(start = 40.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                                .border(
                                    width = 2.dp,
                                    color = Color(0xFFDACECE),
                                    shape = CircleShape
                                )


                        ) {
                            Icon(
                                Icons.Default.Add, null,
                                Modifier.size(30.dp),
                                tint = Green

                            )
                        }
                    }

                }


            } ///


        }
    }
}

data class Card(val name: String,val image: Int)

val list = listOf<Card>(
    Card("All", image = R.drawable.bugers),
    Card("Pizza", image = R.drawable.ppp),
    Card("Rolls", image = R.drawable.rrr),
    Card("Momos", image = R.drawable.mmmm),
    Card("All", image = R.drawable.momosa),
    Card("All", image = R.drawable.momosa),
    Card("All", image = R.drawable.momosa),
    Card("All", image = R.drawable.momosa)
)

@Composable
fun Cards(modifier: Modifier = Modifier,card: Card) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(
            modifier = Modifier
                .padding(6.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFDACECE))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                .padding(5.dp)

        ){
            Image(
                painter = painterResource(id = card.image),
                null,
                modifier = Modifier.size(70.dp)
            )
        }

        Text(
            card.name,
            fontWeight = FontWeight.W800,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 3.dp)


        )

    }

}


