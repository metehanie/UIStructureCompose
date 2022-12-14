package com.metehanbolat.uistructurecompose.components.parallax

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.metehanbolat.uistructurecompose.R

@Composable
fun Parallax() {

    val scrollState = rememberScrollState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .graphicsLayer {
                        alpha = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                        translationY = 0.5f * scrollState.value
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iron_man),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = stringResource(id = R.string.title),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                style = MaterialTheme.typography.body1
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .graphicsLayer {
                    alpha = 1f.coerceAtMost((scrollState.value.toFloat() / scrollState.maxValue))
                }
                .background(color = colorResource(id = R.color.purple_500)),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = stringResource(id = R.string.iron_man),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 12.dp),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ParallaxPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Parallax()
    }
}