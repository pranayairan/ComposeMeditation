package com.binarybricks.composemeditation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binarybricks.composemeditation.BottomMenuContent
import com.binarybricks.composemeditation.Feature
import com.binarybricks.composemeditation.R
import com.binarybricks.composemeditation.standardQuadFromTo
import com.binarybricks.composemeditation.ui.theme.AquaBlue
import com.binarybricks.composemeditation.ui.theme.Beige1
import com.binarybricks.composemeditation.ui.theme.Beige2
import com.binarybricks.composemeditation.ui.theme.Beige3
import com.binarybricks.composemeditation.ui.theme.BlueViolet1
import com.binarybricks.composemeditation.ui.theme.BlueViolet2
import com.binarybricks.composemeditation.ui.theme.BlueViolet3
import com.binarybricks.composemeditation.ui.theme.ButtonBlue
import com.binarybricks.composemeditation.ui.theme.DarkerButtonBlue
import com.binarybricks.composemeditation.ui.theme.DeepBlue
import com.binarybricks.composemeditation.ui.theme.LightGreen1
import com.binarybricks.composemeditation.ui.theme.LightGreen2
import com.binarybricks.composemeditation.ui.theme.LightGreen3
import com.binarybricks.composemeditation.ui.theme.LightRed
import com.binarybricks.composemeditation.ui.theme.OrangeYellow1
import com.binarybricks.composemeditation.ui.theme.OrangeYellow2
import com.binarybricks.composemeditation.ui.theme.OrangeYellow3
import com.binarybricks.composemeditation.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingsSection()
            ChipSections(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                featureList = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }

        BottomMenu(
            menus = listOf(
                BottomMenuContent("Home", R.drawable.ic_home),
                BottomMenuContent("Meditate", R.drawable.ic_bubble),
                BottomMenuContent("Sleep", R.drawable.ic_moon),
                BottomMenuContent("Music", R.drawable.ic_music),
                BottomMenuContent("Profile", R.drawable.ic_profile),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingsSection(name: String = "Pranay") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning $name", style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "We wish you have a good day!", style = MaterialTheme.typography.bodyMedium
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ChipSections(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(color: Color = LightRed) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )
            Text(
                text = "Meditation . 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(
                    ButtonBlue
                )
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play meditation",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun FeatureSection(featureList: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // title
        Text(
            text = "Feture",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(15.dp)
        )
        // grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(featureList.size) {
                FeatureItem(featureList[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // medium color path
        val mediumColoredPoint1 = Offset(0f, height * .3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * .35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * .05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * .7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColorPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // light color path
        val lightColoredPoint1 = Offset(0f, height * .35f)
        val lightColoredPoint2 = Offset(width * 0.1f, height * .4f)
        val lightColoredPoint3 = Offset(width * 0.3f, height * .35f)
        val lightColoredPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightColoredPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColorPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(lightColoredPoint1, lightColoredPoint2)
            standardQuadFromTo(lightColoredPoint2, lightColoredPoint3)
            standardQuadFromTo(lightColoredPoint3, lightColoredPoint4)
            standardQuadFromTo(lightColoredPoint4, lightColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(
                path = mediumColorPath, color = feature.mediumColor
            )
            drawPath(
                path = lightColorPath, color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.titleMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        // do nothing
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    menus: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        menus.forEachIndexed { index, bottomMenuContent ->
            BottomMenuItem(
                bottomMenuContent = bottomMenuContent,
                isSelected = index == selectedItemIndex,
                activeTextColor = activeTextColor,
                activeHighlightColor = activeHighlightColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    bottomMenuContent: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = bottomMenuContent.iconId),
                contentDescription = bottomMenuContent.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = bottomMenuContent.title,
            color = if (isSelected) activeHighlightColor else inactiveTextColor,
            modifier = Modifier.padding(top = 4.dp)
        )
    }

}