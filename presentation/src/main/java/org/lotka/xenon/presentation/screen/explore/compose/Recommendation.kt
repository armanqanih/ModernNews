package org.lotka.xenon.presentation.screen.explore.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import org.lotka.xenon.domain.model.Item
import org.lotka.xenon.domain.model.WishListModel
import org.lotka.xenon.domain.util.Constants.SpaceLarge
import org.lotka.xenon.domain.util.Constants.SpaceMedium
import org.lotka.xenon.presentation.ui.navigation.ScreensNavigation


@Composable
fun Recommendation(
    modifier: Modifier = Modifier,
    onNavigateToDetail:(String)->Unit= {},
    item: Item,
    isFavorite: Boolean,
    onFavoriteButtonClick: ()-> Unit= {},
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.background)
    ) {
        Spacer(modifier = Modifier.height(SpaceMedium.dp))
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(170.dp)
                .clickable {
                onNavigateToDetail(
                    ScreensNavigation.DetailScreen.route
                    + "/${item.categoryId.toString()}"
                )
                }
                .clip(RoundedCornerShape(SpaceMedium))
                .background(MaterialTheme.colors.onBackground)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.picUrl!!.firstOrNull())
                        .crossfade(true)
                        .error(android.R.drawable.ic_menu_report_image)
                        .placeholder(android.R.drawable.ic_menu_gallery)
                        .size(Size.ORIGINAL)
                        .scale(Scale.FILL)
                        .build()
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceLarge.dp)
                    .clip(RoundedCornerShape(SpaceLarge.dp))
            )
            IconButton(
                onClick = {

                    onFavoriteButtonClick()
                },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                if (isFavorite){
                    Icon(
                        imageVector = Icons.Default.Favorite ,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }else{
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder ,
                        contentDescription = null,
                        tint = MaterialTheme.colors.surface
                    )

                }

            }
        }

        item.title?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurface
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    tint = MaterialTheme.colors.secondary,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = item.rating.toString(),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )

            }

            Text(
                text = "$${item.price.toString()}",
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }


    }
}