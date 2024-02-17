package common.compose.ui.home.actual_stories_menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter

@Composable
internal fun ActualStoriesMenuWidget() {
    val shapeActualStories = RoundedCornerShape(8.dp)

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }

    val gradientActualStories = listOf<Color>(
        Color(0xFFE91E63),
        Color(0xff9E00FF),
        Color(0xFFE91E63),
        Color(0xFFF06292),
        Color(0xff9E00FF),
        Color(0xFFF06292),
        Color(0xFFE91E63),
    )

    /* --- Modifier --- */
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat() / 3,  // 1/3
        endY = sizeImage.height.toFloat()
    )

    Box(
        modifier = Modifier
            .border(
                width = 2.6.dp,
                brush = Brush.sweepGradient(gradientActualStories),
                shape = shapeActualStories
            )
            .height(200.dp)
            .width(140.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = rememberImagePainter(itemActualStories.urlImage),
            modifier = Modifier
                .clip(shapeActualStories)
                .fillMaxSize()
                .onGloballyPositioned {
                    sizeImage = it.size
                },
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .clip(shapeActualStories)
                .matchParentSize()
                .background(gradient)
        )

        Text(
            text = itemActualStories.title,
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 0.dp,
                    end = 40.dp,
                    bottom = 10.dp
                ),

            color = Color.White,
            fontSize = 10.sp,
            maxLines = 2
        )
    }
}