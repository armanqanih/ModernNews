package org.lotka.xenon.presentation.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ProfileScreen(
    
){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Text(text = "Profile Screen",
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
            )
    }
}